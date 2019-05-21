package email.actions;

import javax.mail.Message;

public abstract class MailMonitorAction {
	public abstract void check(Message message);
	public EmailActionFilter filter;
	public void setFilter(EmailActionFilter f)
	{
		filter = f;
	}
	public EmailActionFilter getFilter()
	{
		return filter;
	}
}
