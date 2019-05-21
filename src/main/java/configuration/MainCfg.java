package configuration;

import java.util.HashMap;

import helpers.SQL;
import objects.PDatabase;

public class MainCfg implements Configurable{
	
	private HashMap<String, String> admin;
	private int ipLimit = 30;
	private boolean allowRemote = false;
	private PDatabase database;
	
	public MainCfg() {
		
	}
	
	public HashMap<String, String> getAdmin()
	{
		return admin;
	}
	public void setAdmin(HashMap<String, String> admin)
	{
		this.admin = admin;
	}
	public int getIpLimit()
	{
		return ipLimit;
	}
	public void setIpLimit(int ipLimit)
	{
		this.ipLimit = ipLimit;
	}
	public boolean isAllowRemote()
	{
		return allowRemote;
	}
	public void setAllowRemote(boolean allowRemote)
	{
		this.allowRemote = allowRemote;
	}
	public PDatabase getDatabase()
	{
		return database;
	}
	public void setDatabase(PDatabase database)
	{
		this.database = database;
	}

	@Override
	public boolean activateConfig()
	{
		//Connect With configured Data
		SQL.SQLConnection(database.getName(), database.getHost(), database.getPort(), database.getUsername(), database.getPassword());
		
		return true;
	}

	@Override
	public String saveConfig()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
