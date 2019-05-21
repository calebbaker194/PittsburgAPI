package configuration;

import java.util.ArrayList;

import email.ImapServer;


public class MailCfg implements Configurable{
	private ArrayList<ImapServer> mailServers = new ArrayList<ImapServer>();

	public MailCfg() {
		
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

	public ArrayList<ImapServer> getMailServers()
	{
		return mailServers;
	}

	public void setMailServers(ArrayList<ImapServer> mailServers)
	{
		this.mailServers = mailServers;
	}

}
