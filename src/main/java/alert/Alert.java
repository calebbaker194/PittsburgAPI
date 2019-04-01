package alert;


//@Controller
public abstract class Alert {
	
	private long id;
	private String name;
	
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
	
	//@RequestMapping(path = "/get-alert-by-id", method = RequestMethod.POST)
	public abstract Alert getAlertById();
	
	public abstract void alert();

}
