package configuration;

import java.util.Map;

public class RunningConfig implements Configurable{
	
	private String keypass;
	private String keyfile;
	private MainCfg main;
	
	public RunningConfig()
	{
		
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
		 return ConfigReader.ReadConf(RunningConfig.class, "data/main.conf");
	}

	@Override
	public boolean activateConfig()
	{
		main.activateConfig();
		return true;
	}

	@Override
	public String saveConfig()
	{
		save();
		return "";
	}

	public String getKeyPass() {
		return keypass;
	}

	public void setKeyPass(String keyPass) {
		this.keypass = keyPass;
	}

	public String getKeyfile() {
		return keyfile;
	}

	public void setKeyfile(String keyfile) {
		this.keyfile = keyfile;
	}

}
