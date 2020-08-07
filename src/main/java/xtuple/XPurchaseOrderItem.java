package xtuple;

import java.sql.Timestamp;
import java.util.ArrayList;
import helpers.ResultList;
import helpers.SQL;

public class XPurchaseOrderItem {
	private int id;
	private char status;
	private int pohead_id;
	private int linenumber;
	private Timestamp duedate;
	private int itemsite_id;
	private String vend_item_descrip;
	private String vend_uom;
	private double invvenduomratio;
	private double qty_ordered;
	private double qty_received;
	private double qty_returned;
	private double qty_vouchered;
	private double unitprice;
	private String vend_item_number;
	private String comments;
	private double qty_toreceive;
	private int expcat_id;
	private int itemsrc_id;
	private double freight;
	private double freight_received;
	private double freight_vouchered;
	private int prj_id;
	private double stdcost;
	private int bom_rev_id;
	private int boo_rev_id;
	private String manuf_name;
	private String manuf_item_number;
	private String manuf_item_descrip;
	private int taxtype_id;
	private boolean tax_recoverable;
	private Timestamp rlsd_duedate;
	private int order_id;
	private char order_type;
	private Timestamp created;
	private Timestamp lastupdated;
	
	public XPurchaseOrderItem()
	{
		
	}
	
	public XPurchaseOrderItem(int poitem_id)
	{
		ResultList r = SQL.executeQuery("SELECT * FROM poitem WHERE poitem_id = "+poitem_id);
		
		setId(r.getInt("poitem_id"));
		setStatus(r.getChar("poitem_status"));
		setPohead_id(r.getInt("poitem_pohead_id"));
		setLinenumber(r.getInt("poitem_linenumber"));
		setDuedate(r.getTimeStamp("poitem_duedate"));
		setItemsite_id(r.getInt("poitem_itemsite_id"));
		setVend_item_descrip(r.getString("poitem_vend_item_descrip"));
		setVend_uom(r.getString("poitem_vend_uom"));
		setInvvenduomratio(r.getDouble("poitem_invvenduomratio"));
		setQty_ordered(r.getDouble("poitem_qty_ordered"));
		setQty_received(r.getDouble("poitem_qty_received"));
		setQty_returned(r.getDouble("poitem_qty_returned"));
		setQty_vouchered(r.getDouble("poitem_qty_vouchered"));
		setUnitprice(r.getDouble("poitem_unitprice"));
		setVend_item_number(r.getString("poitem_vend_item_number"));
		setComments(r.getString("poitem_comments"));
		setQty_toreceive(r.getDouble("poitem_qty_toreceive"));
		setExpcat_id(r.getInt("poitem_expcat_id"));
		setItemsrc_id(r.getInt("poitem_itemsrc_id"));
		setFreight(r.getDouble("poitem_freight"));
		setFreight_received(r.getDouble("poitem_freight_received"));
		setFreight_vouchered(r.getDouble("poitem_freight_vouchered"));
		setPrj_id(r.getInt("poitem_prj_id"));
		setStdcost(r.getDouble("poitem_stdcost"));
		setBom_rev_id(r.getInt("poitem_bom_rev_id"));
		setBoo_rev_id(r.getInt("poitem_boo_rev_id"));
		setManuf_name(r.getString("poitem_manuf_name"));
		setManuf_item_number(r.getString("poitem_manuf_item_number"));
		setManuf_item_descrip(r.getString("poitem_manuf_item_descrip"));
		setTaxtype_id(r.getInt("poitem_taxtype_id"));
		setTax_recoverable(r.getBoolean("poitem_tax_recoverable"));
		setRlsd_duedate(r.getTimeStamp("poitem_rlsd_duedate"));
		setOrder_id(r.getInt("poitem_order_id"));
		setOrder_type(r.getChar("poitem_order_type"));
		setCreated(r.getTimeStamp("poitem_created"));
		setLastupdated(r.getTimeStamp("poitem_lastupdated"));		
	}

	public static ArrayList<XPurchaseOrderItem> getXPurchaseOrderItmes(int pohead_id)
	{
		ResultList r = SQL.executeQuery("SELECT * FROM poitem WHERE poitem_pohead_id = "+pohead_id);
		
		if(r.first())
		{
			ArrayList<XPurchaseOrderItem> temp = new ArrayList<XPurchaseOrderItem>();
			do
			{
				
				XPurchaseOrderItem tempItem = new XPurchaseOrderItem();
				tempItem.setId(r.getInt("poitem_id"));
				tempItem.setStatus(r.getChar("poitem_status"));
				tempItem.setPohead_id(r.getInt("poitem_pohead_id"));
				tempItem.setLinenumber(r.getInt("poitem_linenumber"));
				tempItem.setDuedate(r.getTimeStamp("poitem_duedate"));
				tempItem.setItemsite_id(r.getInt("poitem_itemsite_id"));
				tempItem.setVend_item_descrip(r.getString("poitem_vend_item_descrip"));
				tempItem.setVend_uom(r.getString("poitem_vend_uom"));
				tempItem.setInvvenduomratio(r.getDouble("poitem_invvenduomratio"));
				tempItem.setQty_ordered(r.getDouble("poitem_qty_ordered"));
				tempItem.setQty_received(r.getDouble("poitem_qty_received"));
				tempItem.setQty_returned(r.getDouble("poitem_qty_returned"));
				tempItem.setQty_vouchered(r.getDouble("poitem_qty_vouchered"));
				tempItem.setUnitprice(r.getDouble("poitem_unitprice"));
				tempItem.setVend_item_number(r.getString("poitem_vend_item_number"));
				tempItem.setComments(r.getString("poitem_comments"));
				tempItem.setQty_toreceive(r.getDouble("poitem_qty_toreceive"));
				tempItem.setExpcat_id(r.getInt("poitem_expcat_id"));
				tempItem.setItemsrc_id(r.getInt("poitem_itemsrc_id"));
				tempItem.setFreight(r.getDouble("poitem_freight"));
				tempItem.setFreight_received(r.getDouble("poitem_freight_received"));
				tempItem.setFreight_vouchered(r.getDouble("poitem_freight_vouchered"));
				tempItem.setPrj_id(r.getInt("poitem_prj_id"));
				tempItem.setStdcost(r.getDouble("poitem_stdcost"));
				tempItem.setBom_rev_id(r.getInt("poitem_bom_rev_id"));
				tempItem.setBoo_rev_id(r.getInt("poitem_boo_rev_id"));
				tempItem.setManuf_name(r.getString("poitem_manuf_name"));
				tempItem.setManuf_item_number(r.getString("poitem_manuf_item_number"));
				tempItem.setManuf_item_descrip(r.getString("poitem_manuf_item_descrip"));
				tempItem.setTaxtype_id(r.getInt("poitem_taxtype_id"));
				tempItem.setTax_recoverable(r.getBoolean("poitem_tax_recoverable"));
				tempItem.setRlsd_duedate(r.getTimeStamp("poitem_rlsd_duedate"));
				tempItem.setOrder_id(r.getInt("poitem_order_id"));
				tempItem.setOrder_type(r.getChar("poitem_order_type"));
				tempItem.setCreated(r.getTimeStamp("poitem_created"));
				tempItem.setLastupdated(r.getTimeStamp("poitem_lastupdated"));	
				
				temp.add(tempItem);
			}
			while(r.next());
			
			return temp;
		}
		else
		{
			return new ArrayList<XPurchaseOrderItem>();
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getPohead_id() {
		return pohead_id;
	}

	public void setPohead_id(int pohead_id) {
		this.pohead_id = pohead_id;
	}

	public int getLinenumber() {
		return linenumber;
	}

	public void setLinenumber(int linenumber) {
		this.linenumber = linenumber;
	}

	public Timestamp getDuedate() {
		return duedate;
	}

	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}

	public int getItemsite_id() {
		return itemsite_id;
	}

	public void setItemsite_id(int itemsite_id) {
		this.itemsite_id = itemsite_id;
	}

	public String getVend_item_descrip() {
		return vend_item_descrip;
	}

	public void setVend_item_descrip(String vend_item_descrip) {
		this.vend_item_descrip = vend_item_descrip;
	}

	public String getVend_uom() {
		return vend_uom;
	}

	public void setVend_uom(String vend_uom) {
		this.vend_uom = vend_uom;
	}

	public double getInvvenduomratio() {
		return invvenduomratio;
	}

	public void setInvvenduomratio(double invvenduomratio) {
		this.invvenduomratio = invvenduomratio;
	}

	public double getQty_ordered() {
		return qty_ordered;
	}

	public void setQty_ordered(double qty_ordered) {
		this.qty_ordered = qty_ordered;
	}

	public double getQty_received() {
		return qty_received;
	}

	public void setQty_received(double qty_received) {
		this.qty_received = qty_received;
	}

	public double getQty_returned() {
		return qty_returned;
	}

	public void setQty_returned(double qty_returned) {
		this.qty_returned = qty_returned;
	}

	public double getQty_vouchered() {
		return qty_vouchered;
	}

	public void setQty_vouchered(double qty_vouchered) {
		this.qty_vouchered = qty_vouchered;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public String getVend_item_number() {
		return vend_item_number;
	}

	public void setVend_item_number(String vend_item_number) {
		this.vend_item_number = vend_item_number;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public double getQty_toreceive() {
		return qty_toreceive;
	}

	public void setQty_toreceive(double qty_toreceive) {
		this.qty_toreceive = qty_toreceive;
	}

	public int getExpcat_id() {
		return expcat_id;
	}

	public void setExpcat_id(int expcat_id) {
		this.expcat_id = expcat_id;
	}

	public int getItemsrc_id() {
		return itemsrc_id;
	}

	public void setItemsrc_id(int itemsrc_id) {
		this.itemsrc_id = itemsrc_id;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public double getFreight_received() {
		return freight_received;
	}

	public void setFreight_received(double freight_received) {
		this.freight_received = freight_received;
	}

	public double getFreight_vouchered() {
		return freight_vouchered;
	}

	public void setFreight_vouchered(double freight_vouchered) {
		this.freight_vouchered = freight_vouchered;
	}

	public int getPrj_id() {
		return prj_id;
	}

	public void setPrj_id(int prj_id) {
		this.prj_id = prj_id;
	}

	public double getStdcost() {
		return stdcost;
	}

	public void setStdcost(double stdcost) {
		this.stdcost = stdcost;
	}

	public int getBom_rev_id() {
		return bom_rev_id;
	}

	public void setBom_rev_id(int bom_rev_id) {
		this.bom_rev_id = bom_rev_id;
	}

	public int getBoo_rev_id() {
		return boo_rev_id;
	}

	public void setBoo_rev_id(int boo_rev_id) {
		this.boo_rev_id = boo_rev_id;
	}

	public String getManuf_name() {
		return manuf_name;
	}

	public void setManuf_name(String manuf_name) {
		this.manuf_name = manuf_name;
	}

	public String getManuf_item_number() {
		return manuf_item_number;
	}

	public void setManuf_item_number(String manuf_item_number) {
		this.manuf_item_number = manuf_item_number;
	}

	public String getManuf_item_descrip() {
		return manuf_item_descrip;
	}

	public void setManuf_item_descrip(String manuf_item_descrip) {
		this.manuf_item_descrip = manuf_item_descrip;
	}

	public int getTaxtype_id() {
		return taxtype_id;
	}

	public void setTaxtype_id(int taxtype_id) {
		this.taxtype_id = taxtype_id;
	}

	public boolean isTax_recoverable() {
		return tax_recoverable;
	}

	public void setTax_recoverable(boolean tax_recoverable) {
		this.tax_recoverable = tax_recoverable;
	}

	public Timestamp getRlsd_duedate() {
		return rlsd_duedate;
	}

	public void setRlsd_duedate(Timestamp rlsd_duedate) {
		this.rlsd_duedate = rlsd_duedate;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public char getOrder_type() {
		return order_type;
	}

	public void setOrder_type(char order_type) {
		this.order_type = order_type;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Timestamp lastupdated) {
		this.lastupdated = lastupdated;
	}
	
}
