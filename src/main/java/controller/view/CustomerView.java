package controller.view;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import security.TokenManager;

@Controller
public class CustomerView {

	@GetMapping("/customer/login")
	public String customerLogin(@CookieValue(value = "cttech-pittsteel-token",defaultValue ="-1") String token,Model model,HttpServletResponse response)
	{
		JSONObject oldToken = TokenManager.validToken(token);
		if(oldToken.getBoolean("valid"))
		{
			if(oldToken.has("newToken"))
				response.addCookie(new Cookie("cttech-pittsteel-token",oldToken.getString("newToken")));
			return "forward:/customer";
		}
		return "customer-login.html";
	}
	
	@GetMapping("/customer")
	public String customerLanding(@CookieValue(value = "cttech-pittsteel-token",defaultValue ="-1") String token,Model model,HttpServletResponse response)
	{
		JSONObject oldToken = token.equals("-1") ? null : TokenManager.validToken(token);
		if(oldToken != null && oldToken.getBoolean("valid"))
		{
			if(oldToken.has("newToken"))
				response.addCookie(new Cookie("cttech-pittsteel-token",oldToken.getString("newToken")));
			return "customer-landing.html";
		}
		else 
		{
			System.out.println("No Token");
			try {
				response.sendRedirect("/customer/login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "forward:/customer/login";
		}
	}
	
	@GetMapping("/customer/register-user")
	public String customerRegesterUser(Model model,HttpServletResponse response) 
	{
		return "customer-regester-user.html";
	}
	
	@GetMapping("/customer/{cust_id}/inventory")
	public String customerInventory(@PathVariable String cust_id, Model model)
	{
		return "customer-inventory.html";
	}
}
