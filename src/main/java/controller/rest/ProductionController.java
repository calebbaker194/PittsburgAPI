package controller.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.DateTime;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import helpers.DataTableRequest;
import helpers.ResultList;
import helpers.SQL;
import prodmon.ProductionMonitor;
import table.DataTable;
import table.Page;
import xtuple.XItem;

@RestController
public class ProductionController {

	
	@RequestMapping(path = "/production/get-production-summary/{id}", method = RequestMethod.POST)
	public static DataTable allProdMonInfo(@ModelAttribute DataTableRequest dr, @PathVariable String id)
	{
		
		DataTable d = new DataTable();
		d.setRecordsTotal(getMonitorCount().intValue());
		d.setRecordsFiltered(getMonitorCount().intValue());
		d.setDraw(dr.getDraw());
		
		
		ArrayList<ProductionMonitor> monitors = new ArrayList<ProductionMonitor>();
		
		ArrayList<JsonNode> list= new ArrayList<JsonNode>();
		ObjectMapper mapper = new ObjectMapper();
		
		
		String pageFilter = "LIMIT "+dr.getLength()+" OFFSET " + dr.getStart();
		String filter = "WHERE station_monitored ";
		// DELETE FOLOWING LINE AFTER UPDATING DATABASE
		  filter = "WHERE TRUE ";
		  
		if(!id.equals("all"))
			filter += " AND station_id = "+id;
			
		ResultList r = SQL.executeQuery("SELECT station_id, station_name, station_mac FROM psproductivity.station " + filter + pageFilter);
		
		for(HashMap<String,Object> monitor : r)
		{
			monitors.add(new ProductionMonitor(monitor));
		}
		
		for(ProductionMonitor m : monitors)
		{
			JsonNode j = mapper.createObjectNode();
			((ObjectNode) j).put("DT_RowId", +m.getStationId());
			((ObjectNode) j).put("station_name", m.getName());
			String tpm = Long.toHexString(Long.parseLong(m.getMac().equals("")? "-1" : m.getMac()));
			tpm = tpm.replaceAll("(.{2})", "$1"+"\\:").substring(0,17);
			System.out.println(tpm);
			((ObjectNode) j).put("station_mac", tpm);
			((ObjectNode) j).put("station_ip", m.getIp());	
			list.add(j);
		}
		
		d.setData(list);
		
		return d;
	}
	
	@RequestMapping(path = "/production/get-production-detail/{id}", method = RequestMethod.POST)
	public static ProductionMonitor prodmonDetail(@PathVariable String id)
	{
		ProductionMonitor p = new ProductionMonitor(null);
		
		return p;
	}
	
	@RequestMapping(path = "/production/get-monitor-data/{id}", method = RequestMethod.POST)
	public static ArrayList<ObjectNode> prodmanData(@PathVariable int id, @RequestParam Timestamp start, @RequestParam Timestamp stop)
	{
		try
		{
		ArrayList<ObjectNode> n = ProductionMonitor.dataRequest(start, stop, id);
		return n;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static Long getMonitorCount()
	{
		return (Long) SQL.SFQ("SELECT count(station_id) FROM psproductivity.station");
	}
	
	
	
	
}
