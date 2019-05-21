package email;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import controller.PittsburgWeb;
import helpers.EmailMessage;
import helpers.Sender;

public class EmailSender extends Sender{

	private ImapServer conn;
	private Session emailSessionObj = null;
	private Store storeObj = null;
	
	
	public EmailSender(ImapServer c) {
		conn = c;
		Properties props = new Properties();
		props.put("mail.imap.host",conn.getImapHost()+"");
		props.put("mail.imap.port", conn.getImapPort()+"");
		props.put("mail.imap.starttls.enable", conn.getStarttls()+"");
		props.put("mail.smtp.auth", conn.getAuth()+"");
		emailSessionObj = Session.getInstance(props);
	}
	
	public boolean send(MimeMessage msg)
	{
		
		Properties prop;
		// Set send address properties
		prop = System.getProperties();
		prop.put("mail.smtp.starttls.enable", conn.getStarttls());
		prop.put("mail.smtp.host", conn.getSmtpHost());
		prop.put("mail.smtp.user", conn.getUsername());
		prop.put("mail.smtp.password", conn.getPassword());
		prop.put("mail.smtp.port", conn.getSmtpPort()+"");
		prop.put("mail.smtp.auth", conn.getAuth()+"");
		//prop.put("mail.smtp.ssl.enable", "true");

		// Open Session
		Session session = Session.getDefaultInstance(prop);
		try
		{
			
			Transport transport = session.getTransport("smtp");
		
			transport.connect(conn.getSmtpHost(),conn.getSmtpPort(), conn.getUsername(),
				conn.getPassword());
		
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			
		} catch (MessagingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		

		
		return true;
	}
	
	
	@Override
	public boolean send(helpers.Message msg)
	{
		boolean sent = false;


		Properties prop;
		// Set send address properties
		prop = System.getProperties();
		prop.put("mail.smtp.starttls.enable", conn.getStarttls());
		prop.put("mail.smtp.host", conn.getSmtpHost());
		prop.put("mail.smtp.user", conn.getUsername());
		prop.put("mail.smtp.password", conn.getPassword());
		prop.put("mail.smtp.port", conn.getSmtpPort()+"");
		prop.put("mail.smtp.auth", conn.getAuth()+"");
		//prop.put("mail.smtp.ssl.enable", "true");

		// Open Session
		Session session = Session.getDefaultInstance(prop);
		
		// Create New Message
		MimeMessage message = new MimeMessage(session);

		PittsburgWeb.LOG.info("Building Email");
		
		try
		{
			EmailMessage emsg = (EmailMessage) msg;
			message.setFrom(new InternetAddress(conn.getAddress()));

			for(Address a : message.getFrom())
				PittsburgWeb.LOG.info("Sending Mail From: "+ a.toString());
			// SET HEADER //Check for messages in this thread.
			if (emsg.getId() != null)
				message.setHeader("In-Reply-To", emsg.getId());

			InternetAddress[] toAddress = new InternetAddress[emsg.getRecipients().size()];

			// CREATE RICIPIENTS// To get the array of addresses // Currently will always be
			// one
			for (int i = 0; i < emsg.getRecipients().size(); i++)
			{
				toAddress[i] = new InternetAddress(emsg.getRecipients().get(i));
			}

			// SET RECIPIENTS//Add all recepients to the message // Still only one
			for (int i = 0; i < toAddress.length; i++)
			{
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			// SET SUBJECT//Sets the subject unless not specified then use previous message
			// subject
			message.setSubject(emsg.getSubject());

			// Create Multipart for message body
			Multipart multipart = new MimeMultipart();

			// SET BODY TEXT//Set the content of the email
			BodyPart messageBody = new MimeBodyPart();
			messageBody.setText(emsg.getBody());
			multipart.addBodyPart(messageBody);

			PittsburgWeb.LOG.info("Adding Attachments");

			// ADD ATTACHMENTS// if there are any
			if (emsg.getAttachments() != null)
			{
				for (String name : emsg.getAttachments().keySet())
				{
					if (name != null && emsg.getAttachments().get(name).length > 10)
					{
						ByteArrayDataSource source = new ByteArrayDataSource(emsg.getAttachments().get(name), name);
						MimeBodyPart messageBodyPart = new MimeBodyPart();
						try
						{
							messageBodyPart.setDataHandler(new DataHandler(source));
							messageBodyPart.setFileName(name);
							multipart.addBodyPart(messageBodyPart);
						} catch (MessagingException e)
						{
							PittsburgWeb.LOG.error("Attachement Failed To Retrieve");
							e.printStackTrace();
						}
					}
					PittsburgWeb.LOG.info("name:" + name);
				}
			}
			message.setContent(multipart, "text/plain");

			PittsburgWeb.LOG.info("Sending Message from email");
			// Connect the transport and send the email. // May move this to its own thread.
			// It can take some time.
			return send(message);

		}
		catch (MessagingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sent;
	}

	public boolean testConnection() {

		try
		{
			storeObj = emailSessionObj.getStore(conn.getImapProtocol());
			
			// Initiate Imap Connection
			storeObj.connect(conn.getImapHost(),conn.getImapPort(),conn.getUsername(), conn.getPassword());
			
			// Grab The default INBOX folder
			storeObj.getDefaultFolder();
			// Create Folder SENT mail
			
			PittsburgWeb.LOG.info("Sender Valid");
			return true;
		} catch (MessagingException e)
		{
			PittsburgWeb.LOG.warn("Sender Invalid");
			PittsburgWeb.LOG.info(e.toString(), e);
			return false;
		}
	}
	
	@Override
	public Sender getSenderById()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
