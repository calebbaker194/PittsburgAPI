package alert;

import objects.EmailAddress;

public class EmailAlert extends Alert{
	
	private String subject;
	private String body;
	private EmailAddress emailFrom;
	private EmailAddress emailTo;

	public EmailAlert(String subject, String body, String emailFrom, String emailTo)
	{
		this.subject = subject;
		this.body = body;
		this.emailFrom = new EmailAddress(emailFrom);
		this.emailTo = new EmailAddress(emailTo);
	}
	
	@Override
	public void alert()
	{
		//TODO - Get some configured Package and Class that stores the possible email methods and allows you to send out emails based on all open email configurations.
	}

	@Override
	public Alert getAlertById()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
