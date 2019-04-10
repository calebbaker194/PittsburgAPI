package controller.rest;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
		
		ResultList r = SQL.executeQuery("SELECT * FROM item LIMIT "+itempage.getSize()+" OFFSET" + itempage.getOffset());
		
		for(HashMap<String,Object> item : r)
		{
			items.add(new XItem(item));
		}
		
		return (XItem[]) items.toArray();
	}
	
	@RequestMapping(path = "/item/get-item-pages", method = RequestMethod.POST)
	public static int getItemPageCount()
	{
		return 0;
	}

}
