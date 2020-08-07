package controller.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.mortbay.jetty.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import security.LoginManager;

public class FileController {
	
	@RequestMapping(path = "/file/email/{emailid}", method = RequestMethod.POST)
	public ResponseEntity<byte[]> getEmailAttachments(@PathVariable String emailid,HttpServletResponse response)
	{		
		
		return null;
	}

}
