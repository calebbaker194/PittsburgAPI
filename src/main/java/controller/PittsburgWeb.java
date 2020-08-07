package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.Certificate;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.Scanner;
import java.util.Timer;
import java.util.regex.Pattern;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import alert.AlertWorker;
import configuration.ConfigReader;
import configuration.MainCfg;
import configuration.RunningConfig;
import helpers.ResultList;
import helpers.SQL;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import objects.PDatabase;
import security.TokenManager;

import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.KeyFactory;

@SpringBootApplication
public class PittsburgWeb  {
	

	public static RunningConfig config  = new RunningConfig();
	public static final Logger LOG = null;//LoggerFactory.getLogger("PW");
	
	public static void main (String args[]) throws Exception
	{	
		
		config = ConfigReader.ReadConf(config.getClass(), "data/main.conf");
		
//		config.activateConfig();
//		String to  = "it@pittsburgsteel.com";
//		String from = "mail@sms.pittsburgfoundry.com";
//		String localhost = "";
		
// 		Actual key when i figure it out
//		CertificateFactory fact = CertificateFactory.getInstance("PKCS7");
//		FileInputStream is = new FileInputStream("data/cert.p12");
//		java.security.cert.Certificate cer = fact.generateCertificate(is);
//		
		KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
		keygen.initialize(2056, new SecureRandom());
		KeyPair pair = keygen.genKeyPair();
		
		TokenManager.getInstance().setKeyPair(pair);
			
		// Alert Thread

		
		// Main Application
		SpringApplication.run(PittsburgWeb.class, args);	
		
		PDatabase db = config.getMain().getDatabase();
		SQL.SQLConnection(db.getName(), db.getHost(), db.getPort(), db.getUsername(), db.getPassword());
		
		System.out.println("running");
	}
	
//	Timer alertTimer = new Timer();
//	alertTimer.scheduleAtFixedRate(AlertWorker.instance, 0, 5 * 1000);
//	
//	String sql = "";
//	Scanner in;
//	try
//	{
//		
//		in = new Scanner(new File("\\\\PSH1\\Documents\\MHOME\\Part_Number_Change.csv"));
//		in.useDelimiter(",");
//		System.out.println("start");
//		while(in.hasNextLine())
//		{	
//			String ItemNum = in.next();
//			String newItemNum = in.nextLine();
//			sql+="UPDATE item SET item_number ='"+newItemNum+"' WHERE item_number = '"+ItemNum+"';\n";
//			
//		}
//		System.out.println(sql);
//	}catch(Exception e) {System.out.print("eh");e.printStackTrace();};
//	
//    FileWriter fileWriter = new FileWriter("C:\\workspace\\PittsburgMessenger\\info_full.csv");
//    PrintWriter printWriter = new PrintWriter(fileWriter);
//    printWriter.print(sql);

}
