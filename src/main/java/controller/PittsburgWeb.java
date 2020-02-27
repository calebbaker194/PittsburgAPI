package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Timer;
import java.util.regex.Pattern;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import alert.AlertWorker;
import configuration.ConfigReader;
import configuration.RunningConfig;
import email.ImapServer;
import helpers.ResultList;
import helpers.SQL;
import local.Database;

import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//@SpringBootApplication
public class PittsburgWeb  {
	

	public static RunningConfig config  = new RunningConfig();
	public static final Logger LOG = null;//LoggerFactory.getLogger("PW");
	
	public static void main (String args[]) throws Exception
	{	
		
		config = ConfigReader.ReadConf(config.getClass(), "data/main.conf");
		
		config.activateConfig();

		
		// Alert Thread
		Timer alertTimer = new Timer();
		alertTimer.scheduleAtFixedRate(AlertWorker.instance, 0, 5 * 1000);
		
		// Main Application
//		SpringApplication.run(PittsburgWeb.class, args);	
		System.out.println("running");
	}
	
//	SQL.SQLConnection("PittSteel", "192.168.2.6", 5432, "caleb", "tori");
//	//System.out.println("start");
//	// itemsite_id,itemsite_plancode_id,itemsite_costcat_id
//
//	Scanner in;
//	Scanner ln;
//	String output ="";
//	try
//	{
//		in = new Scanner(new File("C:\\workspace\\PittsburgMessenger\\info_blank.csv"));
//		ln = new Scanner(new File("C:\\workspace\\PittsburgMessenger\\info_blank.csv"));
//		in.useDelimiter(Pattern.compile("[\\r\\n,]"));
//		while(in.hasNextLine())
//		{	
//			String line = ln.nextLine();
//			in.next();
//			in.next();
//			in.next();
//			in.next();
//			String bfpitem = in.next();
//			in.nextLine();
//			
//			
//			ResultList rl = SQL.executeQuery("SELECT item_number,item_descrip1 FROM item JOIN itemalias ON item_id = itemalias_item_id " + 
//					"WHERE itemalias_number = '"+bfpitem+"'");
//			
//			String psitem = (String) rl.get("item_number");
//			String psdescrip = (String) rl.get("item_descrip1");
//			
//			line = line.substring(0,line.indexOf(',')+1) + psitem + ",\"" +psdescrip +"\""+ line.substring(line.indexOf(',')+2);
//			output+= line+"\n";
//			
//			
//		}
//	}catch(Exception e) {};
//	
//    FileWriter fileWriter = new FileWriter("C:\\workspace\\PittsburgMessenger\\info_full.csv");
//    PrintWriter printWriter = new PrintWriter(fileWriter);
//    printWriter.print(output);
}
