package controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerView {

	@GetMapping("/customer")
	public String customerLanding(Model model)
	{
		return "customer-landing.html";
	}
	
	@GetMapping("/customer/{cust_id}}")
	public String customerIndex(@PathVariable String  cust_id, Model model) 
	{
		return "customer-index.html";
	}
	
	@GetMapping("/customer/{cust_id}/inventory")
	public String customerInventory(@PathVariable String cust_id, Model model)
	{
		return "customer-inventory.html";
	}
}
