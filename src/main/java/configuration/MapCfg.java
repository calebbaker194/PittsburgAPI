package configuration;

import java.util.HashMap;

import helpers.Mapper;

public class MapCfg implements Configurable{
	
	private HashMap<String,String> mailTo = new HashMap<String,String>();
	private HashMap<String,String> numberTo = new HashMap<String,String>();
	
	public MapCfg() {
		Mapper.setEmailToNum(mailTo);
		Mapper.setNumToEmail(numberTo);
	}

	@Override
	public boolean activateConfig()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String saveConfig()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String,String> getNumberTo()
	{
		return numberTo;
	}

	public void setNumberTo(HashMap<String,String> numberTo)
	{
		this.numberTo = numberTo;
	}

	public HashMap<String,String> getMailTo()
	{
		return mailTo;
	}

	public void setMailTo(HashMap<String,String> mailTo)
	{
		this.mailTo = mailTo;
	}

}
