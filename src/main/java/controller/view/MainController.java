package controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index()
	{
		return "index.html";
	}
	
	@GetMapping("/login")
	public String login() 
	{
		return "admin-login";
	}
}
