package sms;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioConfig {
  public static String ACCOUNT_SID = "";
  public static String AUTH_TOKEN = "";

  public static void init(String sid,String token)
  {
	  ACCOUNT_SID = sid;
	  AUTH_TOKEN = token;
	  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
  }
}
