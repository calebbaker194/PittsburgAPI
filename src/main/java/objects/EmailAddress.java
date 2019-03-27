package objects;

public class EmailAddress {
	public static final String pattern = ".+@.+\\..+";
	private String emailAddress = null;
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public EmailAddress(String address) {
		if(address.matches(EmailAddress.pattern))
			emailAddress = address;
		else
			System.err.println("This is not a valid email address: "+ address);
	}
	
	public String toString()
	{
		return emailAddress;
	}
}
