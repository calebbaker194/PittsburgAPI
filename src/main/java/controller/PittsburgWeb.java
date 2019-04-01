package controller;

import java.util.Timer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import alert.AlertWorker;

@SpringBootApplication
public class PittsburgWeb  {
	

	
	public static void main (String args[]) throws Exception
	{		
		// Alert Thread
		Timer alertTimer = new Timer();
		alertTimer.scheduleAtFixedRate(AlertWorker.instance, 0, 5 * 1000);
		
		// Main Application
		SpringApplication.run(PittsburgWeb.class, args);	
	}
}
