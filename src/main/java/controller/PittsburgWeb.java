package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import alert.AlertWorker;
import configuration.ConfigReader;
import configuration.RunningConfig;
import email.ImapServer;
import helpers.SQL;
import local.Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class PittsburgWeb  {
	

	public static RunningConfig config  = new RunningConfig();
	public static final Logger LOG = LoggerFactory.getLogger("PW");
	
	public static void main (String args[]) throws Exception
	{				
		//config = ConfigReader.ReadConf(config.getClass(), "data/main.conf");
		
		//config.activateConfig();

		
		// Alert Thread
		//Timer alertTimer = new Timer();
		//alertTimer.scheduleAtFixedRate(AlertWorker.instance, 0, 5 * 1000);
		
		// Main Application
		SpringApplication.run(PittsburgWeb.class, args);	
		System.out.println("running");
	}
}
