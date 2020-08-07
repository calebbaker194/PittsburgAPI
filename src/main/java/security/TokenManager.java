package security;

import java.security.Key;
import java.security.KeyPair;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;

import helpers.SQL;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenManager {
	
	private KeyPair keypair;
	private static TokenManager instance = null;
	
	public static TokenManager getInstance()
	{
		if(instance == null)
			instance = new TokenManager();
		return instance;
	}
	
	private TokenManager()
	{
		
	}

	public KeyPair getKeyPair() {
		return keypair;
	}

	public void setKeyPair(KeyPair key) {
		this.keypair = key;
	}

	
	public static String getAdminToken() {
		return null;
	}
	public static JSONObject getEmployeeToken(int employee_id,int login_id) {
		Calendar c = Calendar.getInstance();
		Calendar r = Calendar.getInstance();
		r.add(Calendar.DAY_OF_MONTH, 4);
		c.add(Calendar.DAY_OF_MONTH, 7);
		
		JSONObject tokenInfo = new JSONObject();
		
		tokenInfo.put("token", 
				Jwts.builder()
				.setSubject("customer")
				.setExpiration(c.getTime())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.RS256,TokenManager.getInstance().getKeyPair().getPrivate())
				.claim("emp_id", employee_id)
				.claim("refresh", r.getTime())
				.claim("user_id",login_id)
				.setIssuer("https://www.pittsburgsteel.com/employee")
				.compact());
		
		tokenInfo.put("valid",new Timestamp(c.getTimeInMillis()));
		tokenInfo.put("renew",new Timestamp(r.getTimeInMillis()));
		
		return tokenInfo;
	}
	public static JSONObject getCustomerToken(int customer_id,int login_id) {
		Calendar c = Calendar.getInstance();
		Calendar r = Calendar.getInstance();
		int crm_id = SQL.executeQuery("SELECT crmacct_id FROM crmacct WHERE crmacct_cust_id = "+customer_id).getInt("crmacct_id");
		r.add(Calendar.DAY_OF_MONTH, 4);
		c.add(Calendar.DAY_OF_MONTH, 7);
		
		JSONObject tokenInfo = new JSONObject();
		
		tokenInfo.put("token", 
				Jwts.builder()
				.setSubject("customer")
				.setExpiration(c.getTime())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.RS256,TokenManager.getInstance().getKeyPair().getPrivate())
				.claim("cust_id", customer_id)
				.claim("crmacct_id",crm_id)
				.claim("renew", r.getTimeInMillis())
				.claim("user_id",login_id)
				.setIssuer("https://www.pittsburgsteel.com/customer")
				.compact());
		
		tokenInfo.put("valid",new Timestamp(c.getTimeInMillis()));
		tokenInfo.put("renew",new Timestamp(r.getTimeInMillis()));
		
		return tokenInfo;
	}

	public static JSONObject validToken(String token) 
	{
		JSONObject t = new JSONObject();
		try
		{
			Jws<Claims> data = Jwts.parser().setSigningKey(TokenManager.getInstance().getKeyPair().getPrivate()).parseClaimsJws(token);
			t.put("valid", true);
			
			// Check for refresh of the token
			data.getBody().forEach((ckey,cvalue) -> {
				t.put(ckey, cvalue);
			});
			
			if((t.has("renew")) &&(t.getLong("renew")) < System.currentTimeMillis())
			{
				String newToken = LoginManager.refreshToken(t.getInt("cust_id"), t.getInt("user_id"), t.getString("token"));
				t.put("newToken", newToken);
			}
		}
		catch(JwtException e)
		{
			t.put("valid", false);
		}
		catch(Exception e)
		{
			System.out.println("Exception");
			t.put("valid", false);
		}
		catch(NoSuchMethodError e)
		{
			System.out.println("No method");
			e.printStackTrace();
		}
		return t;
	}
}
