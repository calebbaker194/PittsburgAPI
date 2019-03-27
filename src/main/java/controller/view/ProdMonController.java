package controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdMonController {
	
	@GetMapping("/production")
	public String showProduction()
	{
		return "production-summary.html";
	}
}
