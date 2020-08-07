package sms;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import helpers.Sender;

public class TextSender extends Sender{

	
	
	@Override
	public boolean send(helpers.Message msg)
	{
		
		TextMessage textmsg = (TextMessage)(msg);
		Message text = null;
//		if(textmsg.getAttachmentId() != -1)
//		{
//			//Message.cre
//		}
//		else
//		{
//			text = Message.creator(new PhoneNumber(textmsg.getRecipient()),new PhoneNumber(getNumber()), textmsg.getText()).create();
//		}
//			
		return true;
	}

	@Override
	public Sender getSenderById()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
