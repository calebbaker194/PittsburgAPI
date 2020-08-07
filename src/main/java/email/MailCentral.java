package email;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.mail.search.SearchTerm;
import com.sun.mail.gimap.GmailMsgIdTerm;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import helpers.CommonRegex;
import local.FetchNStore;


public class MailCentral {
	
	private static HashMap<String, String> ipData = new HashMap<String, String>();
	private static String accessKey = FetchNStore.readAccessKey();
	public static ArrayList<ImapServer> accounts;
	static {
		accounts = new ArrayList<ImapServer>();
		accounts.add(new ImapServer(true,"192.168.2.6",443,"192.168.2.6",23,"imaps","smtps","smsmail","smsmail@smsmail.pittsteel.com","Sms","Arcon194!($",true));
	}
	
	public static String getCountryCode(String ipAddress) {
        URL url;
        if(ipData.get(ipAddress) != null)
        {
        	return ipData.get(ipAddress);
        }
        if(ipAddress.matches(CommonRegex.LOCAL_IP))
        {
        	return "LOCAL";
        }
		try
		{
			url = new URL("http://api.ipstack.com/"+ipAddress+"?access_key="+accessKey);
	        HttpURLConnection con = (HttpURLConnection) url.openConnection();
	        con.setRequestMethod("GET");
	        con.getResponseCode();
	        ObjectMapper mapper = new ObjectMapper();
	        JsonParser jsonParser = mapper.getFactory().createParser(con.getInputStream());
	        @SuppressWarnings("unchecked")
			Map<String, Object> jsonMap = mapper.readValue(jsonParser, Map.class);
	        ipData.put(ipAddress, (String) jsonMap.get("country_code"));
	        
	        return (String) jsonMap.get("country_code");
		}
        catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return "UNK";
	}

	public static ArrayList<MailAttachment> getAttachments(Message message) throws Exception {
	    Object content = message.getContent();
	    if (content instanceof String)
	        return null;        

	    if (content instanceof Multipart) {
	        Multipart multipart = (Multipart) content;
	        ArrayList<MailAttachment> result = new ArrayList<MailAttachment>();

	        for (int i = 0; i < multipart.getCount(); i++) {
	        	if(!message.isExpunged())
	        		result.addAll(getAttachments(multipart.getBodyPart(i)));
	        }
	        return result;

	    }
	    return null;
	}

	private static ArrayList<MailAttachment> getAttachments(BodyPart part) {
		ArrayList<MailAttachment> result = new ArrayList<MailAttachment>();
	    Object content;
		try
		{
			content = part.getContent();

	    if (content instanceof InputStream || content instanceof String) {
	        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition()) || StringUtils.isNotBlank(part.getFileName())) {
	            result.add(new MailAttachment(part.getFileName(),new BufferedInputStream(part.getInputStream())));
	            return result;
	        } else {
	            return new ArrayList<MailAttachment>();
	        }
	    }

	    if (content instanceof Multipart) {
	            Multipart multipart = (Multipart) content;
	            for (int i = 0; i < multipart.getCount(); i++) {
	                BodyPart bodyPart = multipart.getBodyPart(i);
	                result.addAll(getAttachments(bodyPart));
	            }
	    }
		} catch (MessageRemovedException e)
		{
			System.out.println("Message Removed");
		} catch (IOException e)
		{
			if(e.getCause() instanceof MessageRemovedException)
				System.out.println("Message Removed");
			else
				e.printStackTrace();
		} catch (MessagingException e)
		{
			
			e.printStackTrace();
		}
	    return result;
	}

	public static void saveIpData()
	{
		FetchNStore.saveIpData(ipData);
	}

	public static String getBody(Message message)
	{
		try 
		{
		    Object content = message.getContent();
		    if (content instanceof String)
		        return (String) content;        

		    if (content instanceof Multipart) {
		        Multipart multipart = (Multipart) content;
		        String result = "";
	
		        for (int i = 0; i < multipart.getCount(); i++) {
		        	if(!message.isExpunged())
		        		result += (getBody(multipart.getBodyPart(i)));
		        }
		        return result;
	
		    }
		} catch (MessageRemovedException e)
		{
			System.out.println("Message Removed");
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (MessagingException e)
		{
			e.printStackTrace();
		}
	    return "";
	}

	private static String getBody(BodyPart part)
	{
		String result = "";
	    Object content;
		try
		{
			content = part.getContent();

	    if (content instanceof String) 
	    {
	       return result + content;
	    }

	    if (content instanceof Multipart) {
	            Multipart multipart = (Multipart) content;
	            for (int i = 0; i < multipart.getCount(); i++) {
	                BodyPart bodyPart = multipart.getBodyPart(i);
	                result += (getAttachments(bodyPart));
	            }
	    }
		} catch (MessageRemovedException e)
		{
			System.out.println("Message Removed");
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (MessagingException e)
		{
			
			e.printStackTrace();
		}
	    return result;
	}
	
	public static Message getMessageById(Long id)
	{
		for(ImapServer account : accounts)
		{
			Properties props = new Properties();
			props.put("mail.imap.host", account.getImapHost());
			props.put("mail.imap.port", account.getImapPort());
			props.put("mail.imap.starttls.enable", account.isStarttls());
			Session emailSession = Session.getDefaultInstance(props);
			try {
				Store store = emailSession.getStore("imap");
				store.connect();
				Folder inbox = store.getFolder("INBOX");
				inbox.open(Folder.READ_ONLY);
				GmailMsgIdTerm t = new GmailMsgIdTerm(id);
				Message[] messages = inbox.search(t);
				if(messages.length > 0 )
				{
					return messages[0];
				}
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
