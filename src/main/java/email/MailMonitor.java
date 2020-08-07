package email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.event.MessageCountAdapter;
import javax.mail.event.MessageCountEvent;
import org.apache.poi.poifs.filesystem.FileMagic;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPStore;

import email.actions.MailMonitorAction;
import local.Database;

public class MailMonitor {

    private IdleThread idleThread;
    private ArrayList<MailMonitorAction> actions = new ArrayList<MailMonitorAction>(); 
    
	public MailMonitor(ImapServer user, ArrayList<MailMonitorAction> actionList) {
	
		actions = actionList;
		
		System.out.println("Prepairing to monitor "+user.getAddress());
		
	    Properties properties = new Properties();
	    // properties.put("mail.debug", "true");
	    properties.put("mail.store.protocol", user.getImapProtocol());
	    properties.put("mail.imaps.host", user.getImapHost());
	    properties.put("mail.imaps.port", user.getImapPort());
	    properties.put("mail.imaps.timeout", "10000");
	
	    Session session = Session.getInstance(properties);
	    //session.setDebug(true);
	                                                       
	    IMAPStore store = null;
	    Folder inbox = null;
	
	    try {
	        store = (IMAPStore) session.getStore(user.getImapProtocol());
	        store.connect(user.getUsername(), user.getPassword());
	
	        if (!store.hasCapability("IDLE")) {
	            throw new RuntimeException("IDLE not supported");
	        }
	
	        inbox = (IMAPFolder) store.getFolder("INBOX");
	        inbox.addMessageCountListener(new MessageCountAdapter() {
	
	            @Override
	            public void messagesAdded(MessageCountEvent event) {
	                Message[] messages = event.getMessages();
	                
	                for (Message message : messages) 
	                {
	                    try // MAIN MESSAGE PARSE LOGIC
	                    {   
	                    	
	                    	String fromField = message.getFrom()[0].toString();
	                    	String fromFieldAddress = "";
	                    	try 
	                    	{
	                    		fromFieldAddress = fromField.substring(fromField.indexOf('<')+1,fromField.indexOf('>'));
	                    	}
	                    	catch(StringIndexOutOfBoundsException err)
	                    	{
	                    		fromFieldAddress = fromField;
	                    	}
	                    	
	                    	// Macro Check
	                    	int macroCount = 0;
	                    	ArrayList<MailAttachment> attachments = MailCentral.getAttachments(message);
	                    	ArrayList<MailAttachment> corrupt = new ArrayList<MailAttachment>();
	                    	if(attachments != null)
	                    	{
		                    	for(MailAttachment st : attachments)
		                    	{
		                    		if(FileMagic.valueOf(st.getAttachment()) == FileMagic.OLE2 || FileMagic.valueOf(st.getAttachment()) ==  FileMagic.OOXML)
		                    		{
		                    			if(PoiMaster.hasMacro(st.getAttachment()))
		                    			{
		                    				corrupt.add(st);
		                    				macroCount++;
		                    			}
		                    		}
		                    		else if(st.getName().substring(st.getName().lastIndexOf('.')).matches("(.exe)|(.zip)"))
		                    		{
		                    			corrupt.add(st);
		                    			macroCount++;
		                    		}
		                    	}
	                    	}
	                    	
	                    	for(MailMonitorAction action : actions)
	                    	{
	                    		action.check(message);
	                    	}
	                    	
	                    }
	                    catch (FolderClosedException e)
	                    {
	                    	System.out.println("Folder Closed Attemting to reopen");
	                    }
	                    catch (Exception e) 
	                    {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        });
	
	        idleThread = new IdleThread(inbox, user);
	        idleThread.setDaemon(false);
	        
	
	    } catch (AuthenticationFailedException e) {
	    	System.out.println("Authentication Failed");
	    	System.out.println("Username:" +user.getUsername()+ "\nPassword: " + user.getPassword());
	        e.printStackTrace();
	    } catch (NoSuchProviderException e)
		{
			e.printStackTrace();
		} catch (MessagingException e)
		{
			e.printStackTrace();
		} finally {
	
	        close(inbox);
	        close(store);
	    }
	}

	public IdleThread getIdleThread() {
		return idleThread;
	}
	
    public static class IdleThread extends Thread {
        private final Folder folder;
        private volatile boolean running = true;
        private ImapServer user;

        public IdleThread(Folder folder, ImapServer user) {
            super();
            this.folder = folder;
            this.user = user;
        }

        public synchronized void kill() {
        	
            if (!running)
                return;
            this.running = false;
        }

        @Override
        public void run() {
            while (running) {

                try {
                    ensureOpen(folder, user);
                    ((IMAPFolder) folder).idle();
                }
                catch (FolderClosedException e) {
                	System.out.println("Folder Closed. Re-opening "+folder.getName()+" For "+user.getAddress());
                }
                catch (Exception e) {
                    // something went wrong
                    // wait and try again
                    e.printStackTrace();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        // ignore
                    }
                }

            }
        }
    }

    public static void close(final Folder folder) {
        try {
            if (folder != null && folder.isOpen()) {
                folder.close(false);
            }
        } catch (final Exception e) {
            // ignore
        }

    }

    public static void close(final Store store) {
        try {
            if (store != null && store.isConnected()) {
                store.close();
            }
        } catch (final Exception e) {
            // ignore
        }

    }

    public static void ensureOpen(final Folder folder, ImapServer user) throws MessagingException {

        if (folder != null) {
            Store store = folder.getStore();
            if (store != null && !store.isConnected()) {
                store.connect(user.getUsername(), user.getPassword());
            }
        } else {
            throw new MessagingException("Unable to open a null folder");
        }

        if (folder.exists() && !folder.isOpen() && (folder.getType() & Folder.HOLDS_MESSAGES) != 0) {
            System.out.println("open " + user.getAddress() + " " + folder.getFullName());
            folder.open(Folder.READ_ONLY);
            if (!folder.isOpen())
                throw new MessagingException("Unable to open folder " + folder.getFullName());
        }

    }
}