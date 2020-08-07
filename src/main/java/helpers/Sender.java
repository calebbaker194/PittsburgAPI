package helpers;

//@Controller
public abstract class Sender 
{
	private long id;
	private String name;
	private String number;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public abstract boolean send(Message msg);
	
	//@RequestMapping(path = "/get-sender-by-id", method = RequestMethod.POST)
	public abstract Sender getSenderById();

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
