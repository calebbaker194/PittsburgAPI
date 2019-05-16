package configuration;

public class RunningConfig {
	private MailCfg mail;
	private MapCfg map;
	private MainCfg main;
	
	public RunningConfig()
	{
		
	}
	
	public MailCfg getMail()
	{
		return mail;
	}
	public void setMail(MailCfg mail)
	{
		this.mail = mail;
	}
	public MapCfg getMap()
	{
		return map;
	}
	public void setMap(MapCfg map)
	{
		this.map = map;
	}
	public MainCfg getMain()
	{
		return main;
	}
	public void setMain(MainCfg main)
	{
		this.main = main;
	}

}
