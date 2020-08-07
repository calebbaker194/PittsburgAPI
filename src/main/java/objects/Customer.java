package objects;

import java.util.ArrayList;
import java.util.HashMap;

import helpers.DataTableRequest;
import xtuple.XSalesOrder;

public class Customer {
	private int id;
	private String name;
	private StreetAddress address;
	private EmailAddress email;
	private PhoneNumber phoneNumber;
	
	
	public static ArrayList<XSalesOrder> getOrders(DataTableRequest dr)
	{
		ArrayList<XSalesOrder> reply = new ArrayList<XSalesOrder>();
		
		String sql = "SELECT item_id,item_number,itemalias_number,item_descrip1,"
				+ "COALESCE(ipsitem_price,item_listprice) AS item_listprice,"
				+ "uom_id AS inv_uom_id, \n"
				+ "uom_name AS inv_uom_name, \n"
				+ "itemsite_qtyonhand AS item_qoh\n"
				+ "FROM item\n"
				+ "JOIN itemsite ON (itemsite_item_id = item_id AND itemsite_warehous_id = 35)\n"
				+ "LEFT JOIN crmacct ON (crmacct_cust_id = "+dr.getSearch().get("cust_id")+")\n"
				+ "LEFT JOIN itemalias ON (itemalias_item_id = item_id AND itemalias_crmacct_id = crmacct_id)\n"
				+ "LEFT JOIN ipsass ON ipsass_cust_id = "+dr.getSearch().get("cust_id")+"\n"
				+ "LEFT JOIN ipshead ON (ipshead_id = ipsass_ipshead_id AND NOW() BETWEEN ipshead_effective AND ipshead_expires)\n"
				+ (dr.getSearch().get("isPriced").equals("true") ? "" : "LEFT") + " JOIN ipsiteminfo ON (ipsitem_ipshead_id = ipshead_id AND ipsitem_item_id = item_id)\n"
				+ "JOIN uom ON(COALESCE(ipsitem_qty_uom_id,item_inv_uom_id) = uom_id)\n";
		
		
		sql += " WHERE item_number || item_descrip1 || item_listprice LIKE '%"+ dr.getSearch().get("value") +"%'\n ORDER BY ";
			
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
		
		return null;
	}
	
	public Customer() {
		
	}
	public Customer(int id) {
		
	}
	public Customer(String name) {
		
	}

	public PhoneNumber getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = new PhoneNumber(phoneNumber);
	}

	public EmailAddress getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{	
		this.email = new EmailAddress(email);
	}

	public StreetAddress getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = new StreetAddress();
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
