package table;

import java.util.ArrayList;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;

public class DataTable {
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private ArrayList<JsonNode> data = new ArrayList<JsonNode>();
	
	public DataTable() {
		
	}

	public int getDraw()
	{
		return draw;
	}

	public void setDraw(int draw)
	{
		this.draw = draw;
	}

	public int getRecordsTotal()
	{
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal)
	{
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered()
	{
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered)
	{
		this.recordsFiltered = recordsFiltered;
	}

	public ArrayList<JsonNode> getData()
	{
		return data;
	}

	public void setData(ArrayList<JsonNode> list)
	{
		this.data = list;
	}
	
	
	
}
