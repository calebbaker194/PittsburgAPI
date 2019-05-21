package configuration;

import java.util.Map;

public class RunningConfig implements Configurable{
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
	public void save()
	{
		ConfigReader.WriteConf(this, "data/main.conf");
	}
	public RunningConfig reload()
	{
		 return ConfigReader.ReadConf(RunningConfig.class, "data/main,conf");
	}

	@Override
	public boolean activateConfig()
	{
		mail.activateConfig();
		main.activateConfig();
		map.activateConfig();
		
		return true;
	}

	@Override
	public String saveConfig()
	{
		save();
		return "";
	}

}
