package prodmon;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import helpers.SQL;

public class ProductionMonitor {
	private int id;
	private String name;
	private String mac = "";
	private String ip = "";
	private DateTime viewStart = new DateTime();
	private DateTime viewStop = new DateTime();
	private HashMap<Timestamp, Integer> data = new HashMap<Timestamp, Integer>();
	
	public ProductionMonitor(int id,String name)
	{
		this.id = id;
		setName(name);
	}
	
	public ProductionMonitor(HashMap<String, Object> monitor)
	{
		if(monitor.containsKey("station_id"))
		{
			id = ((Integer) monitor.get("station_id"));
		}
		if(monitor.containsKey("station_name"))
		{
			setName((String) monitor.get("station_name"));
		}
		if(monitor.containsKey("station_ip_addr"))
		{
			setIp((String) monitor.get("station_ip_addr"));
		}
		if(monitor.containsKey("station_mac"))
		{
			try 
			{
				setMac(((BigDecimal) monitor.get("station_mac")).toPlainString());
			}
			catch(NullPointerException e) {setMac("");};
			
		}
		if(monitor.containsKey("station_ip"))
		{
			setIp((String) monitor.get("station_ip"));
		}
	}
	
	public int getStationId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getMac()
	{
		return mac;
	}

	public void setMac(String mac)
	{
		this.mac = mac;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public HashMap<Timestamp, Integer> getData()
	{
		return data;
	}
	
	public static ArrayList<ObjectNode> dataRequest(Timestamp start, Timestamp stop, int id)
	{	
		System.out.println("Begin");
		try
		{
		ObjectMapper m = new ObjectMapper();
		String cq = "SELECT activity_start_time,\r\n"+ 
				"ROUND((SELECT SUM(prodtakt_takt) FROM psproductivity.prodtakt WHERE prodtakt_start BETWEEN (activity_start_time - interval '2 min')"+
				" AND (activity_stop_time + interval '2 min') \r\n" + 
				"AND prodtakt_station_id = activity_station_id)\r\n" + 
				"/(EXTRACT(EPOCH FROM (activity_stop_time - activity_start_time))/60.0)::numeric,2) AS Average,\r\n"+ 
				"activity_stop_time,\r\n"+ 
				"(SELECT SUM(prodtakt_takt) FROM psproductivity.prodtakt WHERE prodtakt_start BETWEEN activity_start_time - interval '2 min' AND activity_stop_time + interval '2 min' \r\n" + 
				"AND prodtakt_station_id = activity_station_id) AS pieces\r\n" + 
				"FROM psproductivity.activity \r\n" + 
				"WHERE activity_station_id = ? \r\n" + 
				"AND (activity_start_time BETWEEN ? AND ?) \r\n";
		ArrayList<ObjectNode> t = new ArrayList<ObjectNode>();
		PreparedStatement prep = null;
		ResultSet r = null;
		System.out.println("try");
		try
		{
			
			prep= SQL.dbConnection.prepareStatement(cq,ResultSet.CONCUR_READ_ONLY,Statement.NO_GENERATED_KEYS);
			prep.setInt(1, id);
			prep.setTimestamp(2, start);
			prep.setTimestamp(3, stop);
			System.out.println("Q" + prep.toString());
			r = prep.executeQuery();
			if(r.first())
			{
				do
				{
					ObjectNode j = m.createObjectNode();
					j.put("start_time", r.getTimestamp(1).toString());
					j.put("stop_time", r.getTimestamp(3).toString());
					j.put("takt", r.getDouble(2));
					j.put("pieces", r.getInt(4));
					t.add(j);
				}
				while(r.next());
			}
			r.close();
			prep.close();
		} catch (Exception e)
		{
			try
			{
				if(!(prep == null) && !prep.isClosed())
					prep.close();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try
			{
				if(!(r == null) && !r.isClosed())
					r.close();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.print(e.getMessage());
		}
		return t;
		}
		catch(Exception e)
		{e.printStackTrace(); return null;}
	}

	public void setData(HashMap<Timestamp, Integer> data)
	{
		this.data = data;
	}
	public void setData(Timestamp start, Timestamp stop)
	{
		String q = "SELECT prodtakt_start,prodtakt_takt FROM WHERE prodtakt_station_id = ? AND prodtakt_start BETWEEN ? AND ? ";
		HashMap<Timestamp, Integer> t = new HashMap<Timestamp,Integer>();
		PreparedStatement prep = null;
		ResultSet r = null;
		try
		{
			prep= SQL.dbConnection.prepareStatement(q);
			prep.setInt(1, id);
			prep.setTimestamp(2, start);
			prep.setTimestamp(3, stop);
			r = prep.executeQuery();
			if(r.first())
			{
				do
				{
					t.put(r.getTimestamp(1), r.getInt(2));
				}
				while(r.next());
				setData(t);
			}
			r.close();
			prep.close();
		} catch (SQLException e)
		{
			try
			{
				if(!(prep == null) && !prep.isClosed())
					prep.close();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try
			{
				if(!(r == null) && !r.isClosed())
					r.close();
			} catch (SQLException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

	public DateTime getViewStart()
	{
		return viewStart;
	}

	public void setViewStart(DateTime viewStart)
	{
		this.viewStart = viewStart;
	}

	public DateTime getViewStop()
	{
		return viewStop;
	}

	public void setViewStop(DateTime viewStop)
	{
		this.viewStop = viewStop;
	}
	
	
}
