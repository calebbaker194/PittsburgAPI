package controller.rest;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import helpers.DataTableRequest;
import helpers.ResultList;
import helpers.SQL;
import table.Page;
import xtuple.XItem;

@RestController
public class ItemController {
	
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
		Long l = (Long)SQL.SFQ("SELECT Count(item_id) FROM item WHERE item_number || item_descrip1 LIKE '%"+search+"%'");
		return (l.intValue());
	}


	public static XItem[] getItems(DataTableRequest dr)
	{
		ArrayList<XItem> items = new ArrayList<XItem>();
		
		String sql = "SELECT * FROM item\n";
		
		sql += " WHERE item_number || item_descrip1 || item_listprice LIKE '%"+ dr.getSearch().get("value") +"%'\n ORDER BY ";
			
		for(HashMap<String,String> order : dr.getOrder())
		{
			switch(Integer.parseInt(order.get("column")))
			{
			case 0:
				sql += "item_number "+ order.get("dir").toUpperCase() +", ";
				break;
			case 1:
				sql += "item_descrip1 "+ order.get("dir").toUpperCase() +", ";
				break;
			case 2:
				sql += "item_listprice "+ order.get("dir").toUpperCase() +", ";
				break;
			case 3:
				sql += "item_inv_uom_id "+ order.get("dir").toUpperCase() +", ";
				break;
			}
		}
		sql = sql.substring(0, sql.length()-2);
			
		sql+= " LIMIT "+dr.getLength() + " OFFSET " + dr.getStart();
		
		System.out.println(sql);
		ResultList r = SQL.executeQuery(sql);
		
		for(HashMap<String,Object> item : r)
		{
			items.add(new XItem(item));
		}
		
		return items.toArray(new XItem[0]);
	}
}
