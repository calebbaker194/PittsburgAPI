package security;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.json.JSONObject;
import org.mindrot.jbcrypt.*;

import helpers.ResultList;
import helpers.SQL;

public class LoginManager 
{

	/**
	 * Checks to see if the username and password are correct then creates a token for the user
	 * @param username - The username to log into
	 * @param candidate - The attpemt at the correct password
	 * @return On success returns a JSONObject with "token" and "success"
	 */
	public static JSONObject loginCustomer(String username, String candidate) 
	{
		JSONObject result = new JSONObject();
		String hashed = "";
		
		if(candidate.length()>6 && candidate.indexOf("'") == -1)
		{
			ResultList r = SQL.executeQuery("SELECT user_hash,COALESCE(user_cust_id,-1) AS user_cust_id,user_id FROM pittweb.user WHERE user_type = 'C' AND user_username = '"+username+"';");
			
			if(r.first() && r.size() < 2)
			{
				hashed = (String) r.get("user_hash");
				if(BCrypt.checkpw(candidate, hashed))
				{
					JSONObject token = TokenManager.getCustomerToken((Integer) r.get("user_cust_id"),(Integer) r.get("user_id"));
					String tokenInsQ = "INSERT INTO pittweb.token (token_user_id,token_token,token_valid,token_refresh) VALUES (?,?,?,?)";
					try {
						PreparedStatement p = SQL.dbConnection.prepareStatement(tokenInsQ);
						p.setInt(1, r.getInt("user_id").intValue());
						p.setString(2, token.getString("token"));
						p.setTimestamp(3, (Timestamp)token.get("valid"));
						p.setTimestamp(4, (Timestamp)token.get("renew"));
						p.executeUpdate();
						
						p.close();
						
						result.put("token", token.getString("token"));
						result.put("success", true);
					} 
					catch (SQLException e) {
						e.printStackTrace();
						result.put("success", false);
						result.put("error", "unknonw error:" + e.getMessage());
					}
					
				}
				else
				{
					result.put("success", false);
					result.put("error", "Incorrect Password");
				}
			}
			else
			{
				result.put("success", false);
				result.put("error", "Incorrect Password");
			}
		}
		else
		{
			result.put("success", false);
			result.put("error", "Incorrect Password");
		}
		
		return result;
		
	}
	
	
	public static String refreshToken(int cust_id,int user_id,String token)
	{
		JSONObject j = TokenManager.getCustomerToken(cust_id,user_id);
		
		try {
			SQL.executeQuery("DELETE FROM pitweb.tokens WHERE token_user_id = " + user_id + " AND token_token = '"+token+"'");
			PreparedStatement p = SQL.dbConnection.prepareStatement("INSERT INTO pitweb.tokens (token_user_id,token_token,token_valid,token_refresh) VALUES(?,?,?,?)");
			p.setInt(1, user_id);
			p.setString(2, j.getString("token"));
			p.setTimestamp(3, (Timestamp)j.get("valid"));
			p.setTimestamp(4, (Timestamp)j.get("renew"));
			p.executeUpdate();
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return j.getString("token");
	}


	public static JSONObject regesterUser(String username, String password) 
	{
		try {
			PreparedStatement p = SQL.dbConnection.prepareStatement("INSERT INTO pittweb.user (user_type,user_username,user_hash) VALUES ('C',?,?)");
			p.setString(1, username);
			p.setString(2, BCrypt.hashpw(password,"$2a$10$pNWD6DnCiElc8LleRHlEce"));
			p.executeUpdate();
			p.close();
			
			return LoginManager.loginCustomer(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
