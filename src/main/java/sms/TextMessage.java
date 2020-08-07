 package sms;

import java.util.ArrayList;

public class TextMessage extends helpers.Message{
	private String text;
	private String recipient;
	private ArrayList<String> attachmentList = new ArrayList<String>();
	
	public TextMessage(String text,String recipient, ArrayList<String> tlist)
	{
		setText(text);
		setRecipient(recipient);
		setAttachmentList(tlist);
	}
	
	public TextMessage(String text,String recipient)
	{
		setText(text);
		setRecipient(recipient);
	}
	
	public TextMessage()
	{
		
	}
	public String getRecipient()
	{
		return recipient;
	}
	public void setRecipient(String recipient)
	{
		this.recipient = recipient;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}

	public ArrayList<String> getAttachmentList()
	{
		return attachmentList;
	}

	public void setAttachmentList(ArrayList<String> attachmentName)
	{
		this.attachmentList = attachmentName;
	}
}
