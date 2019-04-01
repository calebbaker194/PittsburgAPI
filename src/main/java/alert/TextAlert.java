package alert;

import objects.PhoneNumber;

public class TextAlert extends Alert{
	
	public PhoneNumber from;
	public PhoneNumber to;
	public String text;
	

	@Override
	public void alert()
	{
		// TODO Same Package as email alerts to configure method of communication. maybe a contacts package with a super 
		// Contact and sub classes for smsContact, emailContact. This will directly link to how I send out information. like smsContact.send(TextAlert) And emailContact.send(EmailAlert)		
	}

	@Override
	public Alert getAlertById()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
