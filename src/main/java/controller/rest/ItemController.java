package controller.rest;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maxmind.geoip2.DatabaseReader;

import helpers.DataTableRequest;
import helpers.ResultList;
import helpers.SQL;
import table.Page;
import xtuple.XItem;

@RestController
public class ItemController {
	
	public static long lastItemCountTime=0;
	public static Long lastItemCount=0l;
	
	@RequestMapping(path = "/item/get-by-id", method = RequestMethod.POST)
	public static XItem getItemById(int itm_id)
	{
		return null;
	}
	
	@RequestMapping(path = "/item/get-by-classcode", method = RequestMethod.POST)
	public static XItem[] getItemsByClassCode(int ccode_id)
	{
		return null;
	}
	
	@RequestMapping(path = "/item/get-by-prodcat", method = RequestMethod.POST)
	public static XItem[] getItemsByProdCat(int pcat_id)
	{
		return null;
	}
	
	@RequestMapping(path = "/item/get-by-plancode", method = RequestMethod.POST)
	public static XItem[] getItemsByPlanCode(int pcode_id)
	{
		return getItemsByPlanCode(pcode_id,35);
	}

	public static XItem[] getItemsByPlanCode(int pcode_id, int warehous_id)
	{
		return null;
	}
	
	@RequestMapping(path = "/item/get-items", method = RequestMethod.POST)
	public static XItem[] getItems(Page itempage)
	{
		ArrayList<XItem> items = new ArrayList<XItem>();
		
		
		
		ResultList r = SQL.executeQuery("SELECT * FROM item LIMIT "+itempage.getLength()+" OFFSET " + itempage.getStart());
		
		for(HashMap<String,Object> item : r)
		{
			items.add(new XItem(item));
		}
		return items.toArray(new XItem[0]);
	}
	
	public static int getItemCount()
	{
		Long l = (Long)SQL.SFQ("SELECT Count(item_id) FROM item");
		return (l.intValue());
	}
	
	public static int getItemCount(String search)
	{
		if(System.currentTimeMillis()-lastItemCountTime > ((1000)*60)*10) //((1s)*60) -- 1minute -- 10 minutes
		{
		  lastItemCount = (Long)SQL.SFQ("SELECT Count(item_id) FROM item WHERE item_number || item_descrip1 LIKE '%"+search+"%'");
		}
		return (lastItemCount.intValue());
	}


	public static XItem[] getItems(DataTableRequest dr)
	{
		ArrayList<XItem> items = new ArrayList<XItem>();
		
		String sql = "SELECT item_id,item_number,itemalias_number,item_descrip1,"
				+ "COALESCE(ipsitem_price,item_listprice) AS item_listprice,"
				+ "uom_id AS inv_uom_id, \n"
				+ "uom_name AS inv_uom_name, \n"
				+ "itemsite_qtyonhand AS item_qoh\n"
				+ "FROM item\n"
				+ "JOIN itemsite ON (itemsite_item_id = item_id AND itemsite_warehous_id = 35)\n"
				+ "LEFT JOIN itemalias ON (itemalias_item_id = item_id AND itemalias_crmacct_id = "+dr.getSearch().get("crmacct_id")+")\n"
				+ "LEFT JOIN ipsass ON ipsass_cust_id = "+dr.getSearch().get("cust_id")+"\n"
				+ "LEFT JOIN ipshead ON (ipshead_id = ipsass_ipshead_id AND NOW() BETWEEN ipshead_effective AND ipshead_expires)\n"
				+ (dr.getSearch().get("isPriced").equals("true") ? "" : "LEFT") + " JOIN ipsiteminfo ON (ipsitem_ipshead_id = ipshead_id AND ipsitem_item_id = item_id)\n"
				+ "JOIN uom ON(COALESCE(ipsitem_qty_uom_id,item_inv_uom_id) = uom_id)\n";
		
		
		sql += " WHERE item_number || item_descrip1 || item_listprice || itemalias_number LIKE '%"+ dr.getSearch().get("value") +"%'\n ORDER BY ";
			
		for(HashMap<String,String> order : dr.getOrder())
		{
			switch(Integer.parseInt(order.get("column")))
			{
			case 0:
				sql += "item_number "+ order.get("dir").toUpperCase() +", ";
				break;
			case 1:
				sql += "itemalias_number "+ order.get("dir").toUpperCase() +", ";
				break;
			case 2:
				sql += "item_descrip1 "+ order.get("dir").toUpperCase() +", ";
				break;
			case 3:
				sql += "item_listprice "+ order.get("dir").toUpperCase() +", ";
				break;
			case 4:
				sql += "uom_name "+ order.get("dir").toUpperCase() +", ";
				break;
			default:
				sql += "item_number "+ order.get("dir").toUpperCase() +", ";
				break;
			}
		}
		sql = sql.substring(0, sql.length()-2);
			
		sql+= " LIMIT "+dr.getLength() + " OFFSET " + dr.getStart();
		
		ResultList r = SQL.executeQuery(sql);
		
		for(HashMap<String,Object> item : r)
		{
			items.add(new XItem(item));
		}
		
		return items.toArray(new XItem[0]);
	}

	public static int getItemFiltered(DataTableRequest dr) {
		
		String sql = "SELECT COUNT(item_id) AS result "
				+ "FROM item\n"
				+ "LEFT JOIN itemalias ON (itemalias_item_id = item_id AND itemalias_crmacct_id = "+dr.getSearch().get("crmacct_id")+")\n"
				+ "LEFT JOIN ipsass ON ipsass_cust_id = "+dr.getSearch().get("cust_id")+"\n"
				+ "LEFT JOIN ipshead ON (ipshead_id = ipsass_ipshead_id AND NOW() BETWEEN ipshead_effective AND ipshead_expires)\n"
				+ (dr.getSearch().get("isPriced").equals("true") ? "" : "LEFT") + " JOIN ipsiteminfo ON (ipsitem_ipshead_id = ipshead_id AND ipsitem_item_id = item_id)\n";		
		
		sql += " WHERE item_number || item_descrip1 || item_listprice || itemalias_number LIKE '%"+ dr.getSearch().get("value") +"%'\n ";
		return (SQL.executeQuery(sql).getLong("result")).intValue();
	}
}
