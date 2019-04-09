package controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import objects.Customer;
import page.ItemPage;

@RestController
public class CustomerController {
	
	@RequestMapping(path = "/customer", method = RequestMethod.POST)
	public Customer customer() {
		
		Customer c = new Customer();
		c.setEmail("test@test.test");
		c.setAddress("");
		c.setPhoneNumber("9039463351");
		return c;
	}
	
	@RequestMapping(path = "/customer/item-data", method = RequestMethod.POST)
	public ItemPage getCustomerItemPage(int customer_id,int offset, int lemgth)
	{
		ItemPage ip = new ItemPage();
		return ip;
	}
}
