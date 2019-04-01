package alert;

import java.util.PriorityQueue;
import java.util.TimerTask;

public class AlertWorker extends TimerTask{
	
	public static AlertWorker instance = new AlertWorker();
	private PriorityQueue<Alert> alerts;
	private boolean isPaused = false;
	
	
	private AlertWorker() 
	{
		alerts = new PriorityQueue<Alert>();
	}
	
	public void addAlert(Alert e)
	{
		alerts.add(e);
	}
	
	public void removeAlert(Alert a)
	{
		alerts.remove(a);
	}
	
	public PriorityQueue<Alert> getAlerts()
	{
		return alerts;
	}
	
	public void setIsPaused(boolean b)
	{
		isPaused = b;
	}
	
	
	public static void sAddAlert(Alert e)
	{
		instance.alerts.add(e);
	}
	
	public static void sRemoveAlert(Alert a)
	{
		instance.alerts.remove(a);
	}
	
	public static PriorityQueue<Alert> sGetAlerts()
	{
		return instance.alerts;
	}
	
	public static void sSetIsPaused(boolean b)
	{
		instance.isPaused = b;
	}

	@Override
	public void run()
	{
		if(isPaused)
			return;
		
		for(Alert a : alerts)
		{
			a.alert();
			alerts.remove(a);
		}
		
	}

}
