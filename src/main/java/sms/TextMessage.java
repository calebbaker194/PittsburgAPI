package sms;

public class TextMessage extends helpers.Message{
	private String text;
	private String recipient;
	private String attachmentName;
	
	public TextMessage(String text,String recipient, String attachmentName)
	{
		setText(text);
		setRecipient(recipient);
		setAttachmentName(attachmentName);
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

	public String getAttachmentName()
	{
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName)
	{
		this.attachmentName = attachmentName;
	}
}
