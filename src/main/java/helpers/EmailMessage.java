package helpers;

import java.util.ArrayList;
import java.util.HashMap;

public class EmailMessage extends Message{

	private String id;
	private String subject;
	private String body;
	private HashMap<String, byte[]> attachments;
	private ArrayList<String> recipients;
	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public ArrayList<String> getRecipients()
	{
		return recipients;
	}

	public void setRecipients(ArrayList<String> recipients)
	{
		this.recipients = recipients;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public HashMap<String, byte[]> getAttachments()
	{
		return attachments;
	}

	public void setAttachments(HashMap<String, byte[]> attachments)
	{
		this.attachments = attachments;
	}
	

}
