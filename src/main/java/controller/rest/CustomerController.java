package controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import objects.Customer;

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
}
