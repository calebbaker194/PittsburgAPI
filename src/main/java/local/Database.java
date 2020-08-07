package local;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import email.ImapServer;
public class Database {


	public static boolean exists()
	{
		return new File("data/domaindata.sqlite").exists();
	}
	
	private static Connection connect()
	{
		String url = "jdbc:sqlite:data/domaindata.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
	}
	
	public static boolean createDatabase()
	{
		Connection conn = null;
		
		try 
		{
			conn = connect();
			if(conn != null)
			{
				conn.setAutoCommit(false);
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is "+ meta.getDriverName());
				
				
				String conf="CREATE TABLE IF NOT EXISTS conf (\n"
						+ " conf_id integer PRIMARY KEY,\n"
						+ " conf_domain_id integer,\n"
						+ " conf_country_code text,\n"
						+ " conf_occurences real\n"
						+ ");";
				
				String accp="CREATE TABLE IF NOT EXISTS accp (\n"
						+ " accp_id integer PRIMARY KEY,\n"
						+ " accp_domain_id integer,\n"
						+ " accp_country_code text,\n"
						+ " accp_occurences real,\n"
						+ " accp_data integer\n"
						+ ");";
				
				String domain="CREATE TABLE IF NOT EXISTS domain (\n"
						+ " domain_id integer PRIMARY KEY,\n"
						+ " domain_name text\n"
						+ ");";
				
				String appSend="CREATE TABLE IF NOT EXISTS appsend (\n"
						+ " appsend_id integer PRIMARY KEY,\n"
						+ " appsend_domain_id integer,\n"
						+ " appsend_app_domain_name text \n"
						+ ");";
				
				String atmpSend="CREATE TABLE IF NOT EXISTS atmpsend (\n"
						+ " atmpsend_id integer PRIMARY KEY,\n"
						+ " atmpsend_domain_id integer,\n"
						+ " atmpsend_app_domain_name text\n"
						+ ");";
				
				// This table is designed to look at things like constant contact and "bounce" the type will refer to wether it is a subdomain of if its a SRS
				// Example would be bounce.e.zoro.com coming from zoro.com VS zoro.constant-contact.com
				String autoRead="CREATE TABLE IF NOT EXISTS autoread (\n"
						+ " autoread_id integer PRIMARY KEY,\n"
						+ " autoread_domain_name text,\n"
						+ " autoread_type text\n"
						+ ");";
				
				
				Statement confQry = conn.createStatement();
				confQry.execute(conf);
				
				Statement accpQry = conn.createStatement();
				accpQry.execute(accp);
				
				Statement domainQry = conn.createStatement();
				domainQry.execute(domain);
				
				Statement appSendQry = conn.createStatement();
				appSendQry.execute(appSend);
				
				Statement atmpSendQry = conn.createStatement();
				atmpSendQry.execute(atmpSend);
				
				Statement autoReadQry = conn.createStatement();
				autoReadQry.execute(autoRead);
				
				conn.commit();
				conn.close();
				return true;
			}
		} catch (SQLException e)
		{
			try
			{
				conn.rollback();
				conn.close();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}
		return false;
	}
}
	
