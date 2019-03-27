package objects;

public class Customer {
	private int id;
	private String name;
	private StreetAddress address;
	private EmailAddress email;
	private PhoneNumber phoneNumber;
	
	public Customer() {
		
	}
	public Customer(int id) {
		
	}
	public Customer(String name) {
		
	}

	public PhoneNumber getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = new PhoneNumber(phoneNumber);
	}

	public EmailAddress getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{	
		this.email = new EmailAddress(email);
	}

	public StreetAddress getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = new StreetAddress();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
