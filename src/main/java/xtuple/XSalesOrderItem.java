package xtuple;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import helpers.ResultList;
import helpers.SQL;

public class XSalesOrderItem {
	private int id;
	private int cohead_id;
	private int linenumber;
	private String item_number;
	private String inv_uom;
	private String price_uom;
	private int itemsite_id;
	private char status;
	private Date scheddate;
	private Date promdate;
	private double qtyord;
	private double unitcost;
	private double price;
	private double custprice;
	private double qtyshipped;
	private int order_id;
	private String memo;
	private boolean imported;
	private double qtyreturned;
	private Timestamp closedate;
	private String custpn;
	private char order_type;
	private String close_username;
	private Timestamp lastupdated;
	private int substitute_item_id;
	private Timestamp created;
	private String creator;
	private double prcost;
	private int qty_uom_id;
	private double qty_invuomratio;
	private int price_uom_id;
	private double price_invuomratio;
	private boolean warranty;
	private int cos_accnt_id;
	private double qtyreserved;
	private int subnumber;
	private boolean firm;
	private int taxtype_id;
	private char pricemode;
	private int rev_accnt_id;
	private int qtyreserved_uom_id;
	private double listprice;
	private boolean dropship;
	
	public XSalesOrderItem()
	{
		
	}
	public XSalesOrderItem(int coitem_id)
	{
		ResultList r = SQL.executeQuery("SELECT * FROM coitem WHERE coitem_id="+coitem_id);
		
		setId(r.getInt("coitem_id"));
		setCohead_id(r.getInt("coitem_cohead_id"));
		setLinenumber(r.getInt("coitem_linenumber"));
		setItemsite_id(r.getInt("coitem_itemsite_id"));
		setStatus(r.getChar("coitem_status"));
		setScheddate(r.getDate("coitem_scheddate"));
		setPromdate(r.getDate("coitem_promdate"));
		setQtyord(r.getDouble("coitem_qtyord"));
		setUnitcost(r.getDouble("coitem_unitcost"));
		setPrice(r.getDouble("coitem_price"));
		setCustprice(r.getDouble("coitem_custprice"));
		setQtyshipped(r.getDouble("coitem_qtyshipped"));
		setOrder_id(r.getInt("coitem_order_id"));
		setMemo(r.getString("coitem_memo"));
		setImported(r.getBoolean("coitem_imported"));
		setQtyreturned(r.getDouble("coitem_qtyreturned"));
		setClosedate(r.getTimeStamp("coitem_closedate"));
		setCustpn(r.getString("coitem_custpn"));
		setOrder_type(r.getChar("coitem_order_type"));
		setClose_username(r.getString("coitem_close_username"));
		setLastupdated(r.getTimeStamp("coitem_lastupdated"));
		setSubstitute_item_id(r.getInt("coitem_substitute_item_id"));
		setCreated(r.getTimeStamp("coitem_created"));
		setCreator(r.getString("coitem_creator"));
		setPrcost(r.getDouble("coitem_prcost"));
		setQty_uom_id(r.getInt("coitem_qty_uom_id"));
		setQty_invuomratio(r.getDouble("coitem_qty_invuomratio"));
		setPrice_uom_id(r.getInt("coitem_price_uom_id"));
		setPrice_invuomratio(r.getDouble("coitem_price_invuomratio"));
		setWarranty(r.getBoolean("coitem_warranty"));
		setCos_accnt_id(r.getInt("coitem_cos_accnt_id"));
		setQtyreserved(r.getDouble("coitem_qtyreserved"));
		setSubnumber(r.getInt("coitem_subnumber"));
		setFirm(r.getBoolean("coitem_firm"));
		setTaxtype_id(r.getInt("coitem_taxtype_id"));
		setPricemode(r.getChar("coitem_pricemode"));
		setRev_accnt_id(r.getInt("coitem_rev_accnt_id"));
		setQtyreserved_uom_id(r.getInt("coitem_qtyreserved_uom_id"));
		setListprice(r.getDouble("coitem_listprice"));
		setDropship(r.getBoolean("coitem_dropship"));
		
	}
	public static ArrayList<XSalesOrderItem> getXSalseOrderItems(int cohead_id)
	{
		ResultList r = SQL.executeQuery("SELECT coitem.*,uom_name,item_number FROM coitem "
				+ "JOIN uom ON (uom_id = coitem_qty_uom_id) "
				+ "JOIN itemsite ON (itemsite_id = coitem_itemsite_id) "
				+ "JOIN item ON (itemsite_item_id = item_id)  WHERE coitem_cohead_id= "+cohead_id 
				+ " ORDER BY coitem_linenumber ASC");
		if(r.first())
		{
			ArrayList<XSalesOrderItem> temp = new ArrayList<XSalesOrderItem>();
			do
			{
				XSalesOrderItem tempItem = new XSalesOrderItem();
				tempItem.setId(r.getInt("coitem_id"));
				tempItem.setCohead_id(r.getInt("coitem_cohead_id"));
				tempItem.setItem_number(r.getString("item_number"));
				tempItem.setInv_uom(r.getString("uom_name"));
				tempItem.setLinenumber(r.getInt("coitem_linenumber"));
				tempItem.setItemsite_id(r.getInt("coitem_itemsite_id"));
				tempItem.setStatus(r.getChar("coitem_status"));
				tempItem.setScheddate(r.getDate("coitem_scheddate"));
				tempItem.setPromdate(r.getDate("coitem_promdate"));
				tempItem.setQtyord(r.getDouble("coitem_qtyord"));
				tempItem.setUnitcost(r.getDouble("coitem_unitcost"));
				tempItem.setPrice(r.getDouble("coitem_price"));
				tempItem.setCustprice(r.getDouble("coitem_custprice"));
				tempItem.setQtyshipped(r.getDouble("coitem_qtyshipped"));
				tempItem.setOrder_id(r.getInt("coitem_order_id"));
				tempItem.setMemo(r.getString("coitem_memo"));
				tempItem.setImported(r.getBoolean("coitem_imported"));
				tempItem.setQtyreturned(r.getDouble("coitem_qtyreturned"));
				tempItem.setClosedate(r.getTimeStamp("coitem_closedate"));
				tempItem.setCustpn(r.getString("coitem_custpn"));
				tempItem.setOrder_type(r.getChar("coitem_order_type"));
				tempItem.setClose_username(r.getString("coitem_close_username"));
				tempItem.setLastupdated(r.getTimeStamp("coitem_lastupdated"));
				tempItem.setSubstitute_item_id(r.getInt("coitem_substitute_item_id"));
				tempItem.setCreated(r.getTimeStamp("coitem_created"));
				tempItem.setCreator(r.getString("coitem_creator"));
				tempItem.setPrcost(r.getDouble("coitem_prcost"));
				tempItem.setQty_uom_id(r.getInt("coitem_qty_uom_id"));
				tempItem.setQty_invuomratio(r.getDouble("coitem_qty_invuomratio"));
				tempItem.setPrice_uom_id(r.getInt("coitem_price_uom_id"));
				tempItem.setPrice_invuomratio(r.getDouble("coitem_price_invuomratio"));
				tempItem.setWarranty(r.getBoolean("coitem_warranty"));
				tempItem.setCos_accnt_id(r.getInt("coitem_cos_accnt_id"));
				tempItem.setQtyreserved(r.getDouble("coitem_qtyreserved"));
				tempItem.setSubnumber(r.getInt("coitem_subnumber"));
				tempItem.setFirm(r.getBoolean("coitem_firm"));
				tempItem.setTaxtype_id(r.getInt("coitem_taxtype_id"));
				tempItem.setPricemode(r.getChar("coitem_pricemode"));
				tempItem.setRev_accnt_id(r.getInt("coitem_rev_accnt_id"));
				tempItem.setQtyreserved_uom_id(r.getInt("coitem_qtyreserved_uom_id"));
				tempItem.setListprice(r.getDouble("coitem_listprice"));
				tempItem.setDropship(r.getBoolean("coitem_dropship"));
				temp.add(tempItem);
			}
			while(r.next());
			
			return temp;
		}
		else
		{
			return new ArrayList<XSalesOrderItem>();
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCohead_id() {
		return cohead_id;
	}
	public void setCohead_id(int cohead_id) {
		this.cohead_id = cohead_id;
	}
	public int getLinenumber() {
		return linenumber;
	}
	public void setLinenumber(int linenumber) {
		this.linenumber = linenumber;
	}
	public int getItemsite_id() {
		return itemsite_id;
	}
	public void setItemsite_id(int itemsite_id) {
		this.itemsite_id = itemsite_id;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Date getScheddate() {
		return scheddate;
	}
	public void setScheddate(Date scheddate) {
		this.scheddate = scheddate;
	}
	public Date getPromdate() {
		return promdate;
	}
	public void setPromdate(Date promdate) {
		this.promdate = promdate;
	}
	public double getQtyord() {
		return qtyord;
	}
	public void setQtyord(double qtyord) {
		this.qtyord = qtyord;
	}
	public double getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(double unitcost) {
		this.unitcost = unitcost;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCustprice() {
		return custprice;
	}
	public void setCustprice(double custprice) {
		this.custprice = custprice;
	}
	public double getQtyshipped() {
		return qtyshipped;
	}
	public void setQtyshipped(double qtyshipped) {
		this.qtyshipped = qtyshipped;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public double getQtyreturned() {
		return qtyreturned;
	}
	public void setQtyreturned(double qtyreturned) {
		this.qtyreturned = qtyreturned;
	}
	public Timestamp getClosedate() {
		return closedate;
	}
	public void setClosedate(Timestamp closedate) {
		this.closedate = closedate;
	}
	public String getCustpn() {
		return custpn;
	}
	public void setCustpn(String custpn) {
		this.custpn = custpn;
	}
	public char getOrder_type() {
		return order_type;
	}
	public void setOrder_type(char order_type) {
		this.order_type = order_type;
	}
	public String getClose_username() {
		return close_username;
	}
	public void setClose_username(String close_username) {
		this.close_username = close_username;
	}
	public Timestamp getLastupdated() {
		return lastupdated;
	}
	public void setLastupdated(Timestamp lastupdated) {
		this.lastupdated = lastupdated;
	}
	public int getSubstitute_item_id() {
		return substitute_item_id;
	}
	public void setSubstitute_item_id(int substitute_item_id) {
		this.substitute_item_id = substitute_item_id;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public double getPrcost() {
		return prcost;
	}
	public void setPrcost(double prcost) {
		this.prcost = prcost;
	}
	public int getQty_uom_id() {
		return qty_uom_id;
	}
	public void setQty_uom_id(int qty_uom_id) {
		this.qty_uom_id = qty_uom_id;
	}
	public double getQty_invuomratio() {
		return qty_invuomratio;
	}
	public void setQty_invuomratio(double qty_invuomratio) {
		this.qty_invuomratio = qty_invuomratio;
	}
	public int getPrice_uom_id() {
		return price_uom_id;
	}
	public void setPrice_uom_id(int price_uom_id) {
		this.price_uom_id = price_uom_id;
	}
	public double getPrice_invuomratio() {
		return price_invuomratio;
	}
	public void setPrice_invuomratio(double price_invuomratio) {
		this.price_invuomratio = price_invuomratio;
	}
	public boolean isWarranty() {
		return warranty;
	}
	public void setWarranty(boolean warranty) {
		this.warranty = warranty;
	}
	public int getCos_accnt_id() {
		return cos_accnt_id;
	}
	public void setCos_accnt_id(int cos_accnt_id) {
		this.cos_accnt_id = cos_accnt_id;
	}
	public double getQtyreserved() {
		return qtyreserved;
	}
	public void setQtyreserved(double qtyreserved) {
		this.qtyreserved = qtyreserved;
	}
	public int getSubnumber() {
		return subnumber;
	}
	public void setSubnumber(int subnumber) {
		this.subnumber = subnumber;
	}
	public boolean isFirm() {
		return firm;
	}
	public void setFirm(boolean firm) {
		this.firm = firm;
	}
	public int getTaxtype_id() {
		return taxtype_id;
	}
	public void setTaxtype_id(int taxtype_id) {
		this.taxtype_id = taxtype_id;
	}
	public char getPricemode() {
		return pricemode;
	}
	public void setPricemode(char pricemode) {
		this.pricemode = pricemode;
	}
	public int getRev_accnt_id() {
		return rev_accnt_id;
	}
	public void setRev_accnt_id(int rev_accnt_id) {
		this.rev_accnt_id = rev_accnt_id;
	}
	public int getQtyreserved_uom_id() {
		return qtyreserved_uom_id;
	}
	public void setQtyreserved_uom_id(int qtyreserved_uom_id) {
		this.qtyreserved_uom_id = qtyreserved_uom_id;
	}
	public double getListprice() {
		return listprice;
	}
	public void setListprice(double listprice) {
		this.listprice = listprice;
	}
	public boolean isDropship() {
		return dropship;
	}
	public void setDropship(boolean dropship) {
		this.dropship = dropship;
	}
	public String getItem_number() {
		return item_number;
	}
	public void setItem_number(String item_number) {
		this.item_number = item_number;
	}
	public String getInv_uom() {
		return inv_uom;
	}
	public void setInv_uom(String inv_uom) {
		this.inv_uom = inv_uom;
	}
	public String getPrice_uom() {
		return price_uom;
	}
	public void setPrice_uom(String price_uom) {
		this.price_uom = price_uom;
	}
	
	
}
