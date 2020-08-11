package controller.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import helpers.DataTableRequest;
import helpers.Mapper;
import helpers.ResultList;
import helpers.SQL;
import objects.CustInvoice;
import objects.Customer;
import security.LoginManager;
import security.TokenManager;
import table.DataTable;
import xtuple.XInvoice;
import xtuple.XItem;
import xtuple.XSalesOrder;
import xtuple.XSalesOrderItem;

@RestController
public class CustomerController {
	
	@RequestMapping(path = "/customer/login", method = RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, @CookieValue(value="cttech-pittsteel-token" , defaultValue="-1") String token,HttpServletResponse response)
	{		
		JSONObject result = LoginManager.loginCustomer(username, password);
		
		if(result.has("success") && result.getBoolean("success"))
		{
			response.addCookie(new Cookie("cttech-pittsteel-token", result.getString("token")));
			result.put("redirect","/customer");
		}
		
		return result.toString();	
	}
	
	@RequestMapping(path = "/customer/regester-user", method = RequestMethod.POST)
	public JSONObject regesterUser(@RequestParam String username,@RequestParam String password,HttpServletResponse response)
	{
		JSONObject t = LoginManager.regesterUser(username,password);
		if(!t.getBoolean("success"))
			System.out.println(t.getString("error"));
		response.addCookie(new Cookie("cttech-pittsteel-token",t.getString("token")));
		t.put("redirect", "/customer");
		return t;
	}
	
	@RequestMapping(path = "/customer/get-open-invoices", method = RequestMethod.POST)
	public DataTable getInvoicePage(@ModelAttribute DataTableRequest dr, @CookieValue(value="cttech-pittsteel-token" , defaultValue="-1") String token,HttpServletResponse response)
	{
		DataTable d = new DataTable();
		
		JSONObject tk = token.equals("-1") ? null : TokenManager.validToken(token);
		if(tk == null)
		{
			try {
				response.sendRedirect("/customer/login/");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ArrayList<CustInvoice> invoices = XInvoice.getOpenInvoices((Integer) tk.get("cust_id"));
		
		d.setRecordsTotal(invoices.size());
		d.setRecordsFiltered(invoices.size());
		d.setDraw(d.getDraw());
		
		ArrayList<JsonNode> list = new ArrayList<JsonNode>();
		
		for(CustInvoice invoice: invoices)
		{
			JsonNode j = Mapper.OM.createObjectNode();
			((ObjectNode) j).put("DT_RowId", "row_"+invoice.getAropen_id());
			((ObjectNode) j).put("invchead_invcnumber", ""+invoice.getDocnumber());
			((ObjectNode) j).put("invc_total", invoice.getAmount());
			((ObjectNode) j).put("invc_paid", invoice.getPaid());
			((ObjectNode) j).put("invc_due", invoice.getBalance());
			((ObjectNode) j).put("invc_duedate", ""+invoice.getDuedate());
			list.add(j);
		}
		
		
		d.setData(list);
		
		return d;
	}

	@RequestMapping(path = "/customer/get-credit-info", method = RequestMethod.POST)
	public JsonNode getCustCreditInfo(@CookieValue(value="cttech-pittsteel-token" , defaultValue="-1") String token, HttpServletResponse response)
	{
		JSONObject tk = token.equals("-1") ? null : TokenManager.validToken(token);
		if(tk == null)
		{
			try {
				response.sendRedirect("/customer/login/");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ResultList rl = SQL.executeQuery("SELECT *,creditlimit - opencredit AS availablecredit FROM \r\n" + 
				"(SELECT \r\n" + 
				"(SELECT cst.cust_creditlmt FROM custinfo cst WHERE cst.cust_id = "+tk.get("cust_id")+") AS creditlimit,\r\n" + 
				"SUM(CASE WHEN duedate < NOW() THEN balance ELSE 0 END) AS overdue,\r\n" + 
				"SUM(balance) AS opencredit\r\n" + 
				"FROM (  \r\n" + 
				"	SELECT\r\n" + 
				"		   aropen_duedate AS duedate,  \r\n" + 
				"		   (aropen_amount - aropen_paid) AS balance  \r\n" + 
				"	FROM aropen  \r\n" + 
				"	WHERE ( (aropen_cust_id="+tk.get("cust_id")+"  \r\n" + 
				"	AND aropen_doctype = 'I')  \r\n" + 
				"	AND aropen_open  \r\n" + 
				"))AS data) AS info  ");
		
		JsonNode creditinfo = Mapper.OM.createObjectNode();
		
		((ObjectNode) creditinfo).put("creditlimit",rl.getInt("creditlimit"));
		((ObjectNode) creditinfo).put("overdue",rl.getDouble("overdue"));
		((ObjectNode) creditinfo).put("opencredit",rl.getDouble("opencredit"));
		((ObjectNode) creditinfo).put("availablecredit",rl.getDouble("availablecredit"));
		
		
		return creditinfo;
		
	}
	
	@RequestMapping(path = "/customer/get-orders-page", method = RequestMethod.POST)
	public DataTable getOrderPage(@ModelAttribute DataTableRequest dr, @CookieValue(value="cttech-pittsteel-token" , defaultValue="-1") String token,HttpServletResponse response)
	{
		DataTable d = new DataTable();
		
		JSONObject tk = token.equals("-1") ? null : TokenManager.validToken(token);
		if(tk == null)
		{
			try {
				response.sendRedirect("/customer/login/");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		dr.getSearch().put("cust_id", tk.get("cust_id")+"");
		
		ArrayList<XSalesOrder> orders = XSalesOrder.getSalesOrder(dr);
		
		d.setRecordsTotal(orders.size());
		d.setRecordsFiltered(orders.size());
		
		d.setDraw(dr.getDraw());
		
		ArrayList<JsonNode> list = new ArrayList<JsonNode>();

		
		for(XSalesOrder order: orders)
		{
			JsonNode j = Mapper.OM.createObjectNode();
			((ObjectNode) j).put("DT_RowId", "row_"+order.getId());
			((ObjectNode) j).put("cohead_number", ""+order.getNumber());
			((ObjectNode) j).put("cohead_custpo", ""+order.getCustponumber());
			((ObjectNode) j).put("cohead_orderdate", ""+order.getOrderdate());
			((ObjectNode) j).put("cohead_shipto", ""+order.getShiptoname());
			((ObjectNode) j).put("test", "");
			list.add(j);
		}
		d.setData(list);
		
		return d;
	}
	
	@RequestMapping(path = "/customer/get-item-page", method = RequestMethod.POST)
	public DataTable getItemPage(@ModelAttribute DataTableRequest dr,  @CookieValue(value="cttech-pittsteel-token" , defaultValue="-1") String token,HttpServletResponse response) {
		
		JSONObject tk = token.equals("-1") ? null : TokenManager.validToken(token);
		
		if(tk == null)
		{
			try {
				response.sendRedirect("/customer/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		dr.getSearch().put("cust_id", tk.get("cust_id")+"");
		dr.getSearch().put("crmacct_id", tk.get("crmacct_id")+"");
		
		XItem[] items = ItemController.getItems(dr);
		
		DataTable d = new DataTable();
		d.setRecordsTotal(ItemController.getItemCount());
		d.setRecordsFiltered(546);//ItemController.getItemFiltered(dr));
		d.setDraw(dr.getDraw());
		
		ArrayList<JsonNode> list= new ArrayList<JsonNode>();

		
		
		for(XItem item : items)
		{
			JsonNode j = Mapper.OM.createObjectNode();
			((ObjectNode) j).put("DT_RowId", "row_"+item.getId());
			((ObjectNode) j).put("item_number", item.getNumber());
			((ObjectNode) j).put("itemalias_number", item.getAlias());
			((ObjectNode) j).put("item_descrip1", item.getDescrip1());
			((ObjectNode) j).put("item_listprice", item.getListprice());
			((ObjectNode) j).put("item_uom", item.getInv_uom_name());
			((ObjectNode) j).put("item_qoh", item.getQoh());
			list.add(j);
		}
		
		d.setData(list);
		
		
		return d;
		
	}
	
	@RequestMapping(path = "/customer/orders/get-order-items", method = RequestMethod.POST)
	public ArrayList<JsonNode> getOrderItems(@RequestParam int cohead_id,  @CookieValue(value="cttech-pittsteel-token" , defaultValue="-1") String token,HttpServletResponse response)
	{
		JSONObject tk = token.equals("-1") ? null : TokenManager.validToken(token);
		
		if(tk == null)
		{
			try {
				response.sendRedirect("/customer/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		ArrayList<XSalesOrderItem> xsois = XSalesOrderItem.getXSalseOrderItems(cohead_id);
		
		ArrayList<JsonNode> list= new ArrayList<JsonNode>();
		
		for(XSalesOrderItem xsoi : xsois)
		{
			
			JsonNode j = Mapper.OM.createObjectNode();
			((ObjectNode) j).put("DT_RowId", "row_"+xsoi.getId());
			((ObjectNode) j).put("coitem_linenumber", xsoi.getLinenumber());
			((ObjectNode) j).put("coitem_item_nubmber", xsoi.getItem_number());
			((ObjectNode) j).put("coitem_scheddate", xsoi.getScheddate().toString());
			((ObjectNode) j).put("coitem_qtyord", xsoi.getQtyord());
			((ObjectNode) j).put("coitem_qtyshipped", xsoi.getQtyshipped());
			((ObjectNode) j).put("coitem_uom", xsoi.getInv_uom());
			list.add(j);
		}
		
		return list;
	}
}
