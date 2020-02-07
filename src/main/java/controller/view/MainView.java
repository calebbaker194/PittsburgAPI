package controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainView {
	
	@GetMapping("/")
	public String index()
	{
		return "home.html";
	}
	
	@GetMapping("/login")
	public String login() 
	{
		return "admin-login";
	}
}
