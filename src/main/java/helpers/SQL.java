package helpers;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.login.FailedLoginException;

public class SQL {
	
	public static HashMap<String,Integer> flagMap = new HashMap<String,Integer>();
	public static Connection dbConnection;
	
	
	static {
		flagMap.put("SELECT", 0);
		flagMap.put("INSERT", 1);
		flagMap.put("UPDATE", 2);
		flagMap.put("DELETE", 3);
		flagMap.put("CREATE", 4);
		flagMap.put("ALTER", 5);
		flagMap.put("DROP", 6);
	}
	
	private static String connectionString = null;
	private static String username;
	private static String password;

	public static String SQLConnection(String db,String host,int port,String username,String password)
	{
		connectionString="jdbc:postgresql://"+host+":"+port+"/"+db;
		
		
		try
		{
			dbConnection = DriverManager.getConnection(connectionString,username,password);
			
		} catch (SQLException e)
		{
			System.err.println("UNABLE TO LOG IN TO DATABASE "+ e);
			e.printStackTrace();
		}
		setPassword(password);
		setUsername(username);
		return "0";
	}
	
	public static ResultList executeQuery(String query)
	{
		int flag = 0;
		
		String function = query.contains(" ") ? query.split(" ")[0].toUpperCase() : query.toUpperCase();
		
		flag = SQL.flagMap.get(function) != null ? SQL.flagMap.get(function) : 0;
		
		
		return executeQuery(query,flag);
	}
	
	/*
	 *Execute a query. the flag currently states if you want to return generated keys 
	 */
	public static ResultList executeQuery(String query,int flag)
	{
		
		try 
		{
			if(!dbConnection.isClosed())
				dbConnection = DriverManager.getConnection(connectionString,username,password);
		}
		catch (SQLException e) 
		{
			System.out.println("Failed To Connect");
			e.printStackTrace();
		}
		
		try {
			if(dbConnection!=null)
			{
				try {
					Statement st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					PreparedStatement p = dbConnection.prepareStatement(query);
					List<HashMap<String,Object>> resultArray = new ArrayList<HashMap<String,Object>>();
					HashMap<String,Object> row;
					ResultSet results;
					
					if(flag==0)
					{
						results = st.executeQuery(query);
					}	
					else
					{
						st.executeUpdate(query,Statement.NO_GENERATED_KEYS);
						results = st.getGeneratedKeys();
					}
					
					ResultSetMetaData meta= results.getMetaData();
					
						
					int columns = meta.getColumnCount();
					while(results.next())
					{
						row = new HashMap<String,Object>(columns);
						for(int i=1;i<=columns;i++)
						{
							row.put(meta.getColumnName(i), results.getObject(i));
						}
						resultArray.add(row);
					}
				
					results.close();
					st.close();
					return new ResultList(resultArray);
				} catch (SQLException e) {
					ResultList r = new ResultList();
					r.addRow();
					r.put("error",e.getMessage());
					System.err.println("Query Failed: " + e.getMessage());
					return r;
				}
			}
			else
			{
				throw new FailedLoginException("Failed to connect to the database");
			}
		} catch (FailedLoginException e) {
			System.err.println(e.toString());
			return null;
		}
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		SQL.password = password;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		SQL.username = username;
	}
	/**
	 * Single field query. made for getting one field using an id. 
	 * If you use more then one field. it will only return the value of the first field
	 * @param query The query for the value
	 * @see If the query throws any exception. null will be returned
	 */
	public static Object SFQ(String query)
	{
		ResultList r = executeQuery(query);
		try
		{
			return r.get(r.get(0).keySet().iterator().next());
		}catch(Exception e) { return null; }
	}

	
}