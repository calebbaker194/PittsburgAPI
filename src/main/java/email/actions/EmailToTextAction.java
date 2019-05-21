package email.actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;

import org.apache.commons.lang3.StringUtils;

import controller.PittsburgWeb;
import helpers.CommonRegex;
import javax.mail.Flags.Flag;

import sms.TextMessage;
import sms.TextSender;

public class EmailToTextAction extends MailMonitorAction{
	TextSender phone;
	
	public EmailToTextAction(TextSender p)
	{
		phone = p;
	}
	
	@Override
	public void check(Message message)
	{
		String returnVal = "";
		try
		{
			returnVal += "Message To: " +message.getAllRecipients()[0].toString();
			// Parse Phone number out of email address.
			String toParser = message.getAllRecipients()[0].toString();
			if (toParser.indexOf('+') > -1)
			{
				String phoneNumber = toParser.substring(toParser.indexOf('+'), toParser.indexOf('@'));
				if (phoneNumber.matches(CommonRegex.PHONE_NUMBER))
				{
					String reply;
					// Get reply with previous email text
					if(message.getContent() instanceof Multipart)
					{
						reply = ((Multipart)message.getContent()).getBodyPart(0).getContent().toString();
					}
					else
					{
						reply = message.getContent().toString();
					}
					// Get email address sent from
					String from = message.getFrom()[0].toString();
					// Strip Additional text from previous emails
					Matcher matcher = Pattern.compile(CommonRegex.MESSAGE_SEPERATOR).matcher(reply);
					// getMatch
					String parsedReply;
					if (matcher.find())
					{
						parsedReply = reply.substring(0, matcher.start());

					} else
					{
						parsedReply = reply;
					}

					// Get number to send reply from.
					String sendReplyFrom = null;
					String parseFrom = null;
					
					if(from.indexOf('<') > -1 && from.indexOf('>') > -1)
						parseFrom=from.substring(from.indexOf('<')+1, from.indexOf('>'));
					else
						parseFrom=from;
					
					
					
					// Send Text
					if(parsedReply.length()>0)
					{
						phone.send(new TextMessage(parsedReply,phoneNumber));
					}
					
					// Check For Attachments
					ArrayList<File> attachments = new ArrayList<File>();
					try
					{
						Multipart multipart = (Multipart) message.getContent();
						
						for (int z = 0; z < multipart.getCount(); z++) 
					    {
							BodyPart bodyPart = multipart.getBodyPart(z);
							if(!Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition()) &&
									StringUtils.isBlank(bodyPart.getFileName())) {
					            continue; // dealing with attachments only
					        } 
					        InputStream is = bodyPart.getInputStream();
					        new File("/tmp/").mkdirs();
					        File f = new File("/tmp/" + bodyPart.getFileName());
					        FileOutputStream fos = new FileOutputStream(f);
					        byte[] buf = new byte[4096];
					        int bytesRead;
					        while((bytesRead = is.read(buf))!=-1) {
					            fos.write(buf, 0, bytesRead);
					        }
					        fos.close();
					        attachments.add(f);
					    }
					}catch(ClassCastException | FileNotFoundException e)
					{
						PittsburgWeb.LOG.info(e.getMessage());
					} catch (IOException e)
					{
						PittsburgWeb.LOG.info(e.toString(), e);
					}
				    
				    // Iterator through attachments and send them
				    if(!(attachments == null || attachments.size() < 1))
				    {
				    	for(File tempfile : attachments)
				    	{
				    		phone.send(new TextMessage(parsedReply,phoneNumber,tempfile.getName()));
				    	}
				    }
					
					// Mark As Answered
					message.setFlag(Flag.ANSWERED, true);
				}
			}		
		
		} catch (MessagingException e)
		{
			PittsburgWeb.LOG.info(e.toString(), e);
			e.printStackTrace();
		} catch (IOException e)
		{
			PittsburgWeb.LOG.info(e.toString(), e);
			e.printStackTrace();
		}
		
	}

}
