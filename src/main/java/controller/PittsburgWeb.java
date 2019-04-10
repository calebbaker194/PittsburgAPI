package controller;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;
import org.json.JSONTokener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import alert.AlertWorker;
import helpers.SQL;

import org.json.JSONObject;

@SpringBootApplication
public class PittsburgWeb  {
	

	
	public static void main (String args[]) throws Exception
	{		
		//Read in configurations.
		String configString = new String(Files.readAllBytes(Paths.get("credentials/main.cfg")), StandardCharsets.UTF_8);
		JSONTokener parser = new JSONTokener(configString);
		JSONObject cfg = new JSONObject(parser);
		
		//Connect With configured Data
		SQL.SQLConnection(cfg.getString("database"), cfg.getString("host"), cfg.getInt("port"), cfg.getString("username"), cfg.getString("password"));
		
		// Alert Thread
		Timer alertTimer = new Timer();
		alertTimer.scheduleAtFixedRate(AlertWorker.instance, 0, 5 * 1000);
		
		// Main Application
		SpringApplication.run(PittsburgWeb.class, args);	
	}
}
