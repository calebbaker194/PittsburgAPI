package configuration;

import java.util.ArrayList;
import java.util.HashMap;

import objects.ImapServer;


public class MailCfg implements Configurable{
	private ArrayList<ImapServer> mailServers = new ArrayList<ImapServer>();

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
}
