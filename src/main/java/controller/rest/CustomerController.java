package controller.rest;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import helpers.DataTableRequest;
import objects.Customer;
import table.DataTable;
import xtuple.XItem;

@RestController
public class CustomerController {
	
	@RequestMapping(path = "/customer", method = RequestMethod.POST)
	public Customer customer() {
		
		Customer c = new Customer();
		c.setEmail("test@test.test");
		c.setAddress("");
		c.setPhoneNumber("9039463351");
		return c;
	}
	
	@RequestMapping(path = "/customer/get-orders-page", method = RequestMethod.POST)
	public DataTable getOrderPage(@ModelAttribute DataTableRequest dr)
	{
		DataTable d = new DataTable();
		
		return d;
	}
	
	@RequestMapping(path = "/customer/get-item-page", method = RequestMethod.POST)
	public DataTable getItemPage(@ModelAttribute DataTableRequest dr) {
		
		XItem[] items = ItemController.getItems(dr);
		
		DataTable d = new DataTable();
		d.setRecordsTotal(ItemController.getItemCount());
		d.setRecordsFiltered(ItemController.getItemCount(dr.getSearch().get("value")));
		d.setDraw(dr.getDraw());
		
		ArrayList<JsonNode> list= new ArrayList<JsonNode>();
		ObjectMapper mapper = new ObjectMapper();
		
		
		for(XItem item : items)
		{
			JsonNode j = mapper.createObjectNode();
			((ObjectNode) j).put("DT_RowId", "row_"+item.getId());
			((ObjectNode) j).put("item_number", item.getNumber());
			((ObjectNode) j).put("item_descrip1", item.getDescrip1());
			((ObjectNode) j).put("item_listprice", item.getListprice());
			((ObjectNode) j).put("item_qoh", item.getInv_uom_id());
			list.add(j);
		}
		
		d.setData(list);
		
		
		return d;
		
	}
}
