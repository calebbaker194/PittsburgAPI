package xtuple;

import java.util.ArrayList;
import java.util.HashMap;

import helpers.DataTableRequest;
import helpers.Mapper;
import helpers.ResultList;
import helpers.SQL;

public class XInvoiceItem {
	private int invcitem_id;
	private int invcitem_invchead_id;
	private int invcitem_linenumber;
	private int invcitem_item_id;
	private int invcitem_warehous_id;
	private String invcitem_custpn;
	private String invcitem_number;
	private String invcitem_descrip;
	private double invcitem_ordered;
	private double invcitem_billed;
	private double invcitem_custprice;
	private double invcitem_price;
	private String invcitem_notes;
	private int invcitem_salescat_id;
	private int invcitem_taxtype_id;
	private int invcitem_qty_uom_id;
	private double invcitem_qty_invuomratio;
	private int invcitem_price_uom_id;
	private double invcitem_price_invuomratio;
	private int invcitem_coitem_id;
	private boolean invcitem_updateinv;
	private int invcitem_rev_accnt_id;
	private double invcitem_listprice;
	private int invcitem_subnumber;
	
	public XInvoiceItem()
	{
		
	}
	
	public static ArrayList<XInvoiceItem> getInvoiceItems(int invchead_id)
	{
		String sql = "SELECT * FROM invcitem WHERE invcitem_invchead_id = "+invchead_id;
		
		ResultList r = SQL.executeQuery(sql);
		
		ArrayList<XInvoiceItem> result = new ArrayList<XInvoiceItem>();
		
		if(r.first())
		{
			do
			{
				HashMap<String, Object> row = r.getRow();
				XInvoiceItem temp = Mapper.OM.convertValue(row, XInvoiceItem.class);
				result.add(temp);
			}
			while(r.next());
		}
		
		return result;	
		
	}
	
	public int getInvcitem_id() {
		return invcitem_id;
	}
	public void setInvcitem_id(int invcitem_id) {
		this.invcitem_id = invcitem_id;
	}
	public int getInvcitem_invchead_id() {
		return invcitem_invchead_id;
	}
	public void setInvcitem_invchead_id(int invcitem_invchead_id) {
		this.invcitem_invchead_id = invcitem_invchead_id;
	}
	public int getInvcitem_linenumber() {
		return invcitem_linenumber;
	}
	public void setInvcitem_linenumber(int invcitem_linenumber) {
		this.invcitem_linenumber = invcitem_linenumber;
	}
	public int getInvcitem_item_id() {
		return invcitem_item_id;
	}
	public void setInvcitem_item_id(int invcitem_item_id) {
		this.invcitem_item_id = invcitem_item_id;
	}
	public int getInvcitem_warehous_id() {
		return invcitem_warehous_id;
	}
	public void setInvcitem_warehous_id(int invcitem_warehous_id) {
		this.invcitem_warehous_id = invcitem_warehous_id;
	}
	public String getInvcitem_custpn() {
		return invcitem_custpn;
	}
	public void setInvcitem_custpn(String invcitem_custpn) {
		this.invcitem_custpn = invcitem_custpn;
	}
	public String getInvcitem_number() {
		return invcitem_number;
	}
	public void setInvcitem_number(String invcitem_number) {
		this.invcitem_number = invcitem_number;
	}
	public String getInvcitem_descrip() {
		return invcitem_descrip;
	}
	public void setInvcitem_descrip(String invcitem_descrip) {
		this.invcitem_descrip = invcitem_descrip;
	}
	public double getInvcitem_ordered() {
		return invcitem_ordered;
	}
	public void setInvcitem_ordered(double invcitem_ordered) {
		this.invcitem_ordered = invcitem_ordered;
	}
	public double getInvcitem_billed() {
		return invcitem_billed;
	}
	public void setInvcitem_billed(double invcitem_billed) {
		this.invcitem_billed = invcitem_billed;
	}
	public double getInvcitem_custprice() {
		return invcitem_custprice;
	}
	public void setInvcitem_custprice(double invcitem_custprice) {
		this.invcitem_custprice = invcitem_custprice;
	}
	public double getInvcitem_price() {
		return invcitem_price;
	}
	public void setInvcitem_price(double invcitem_price) {
		this.invcitem_price = invcitem_price;
	}
	public String getInvcitem_notes() {
		return invcitem_notes;
	}
	public void setInvcitem_notes(String invcitem_notes) {
		this.invcitem_notes = invcitem_notes;
	}
	public int getInvcitem_salescat_id() {
		return invcitem_salescat_id;
	}
	public void setInvcitem_salescat_id(int invcitem_salescat_id) {
		this.invcitem_salescat_id = invcitem_salescat_id;
	}
	public int getInvcitem_taxtype_id() {
		return invcitem_taxtype_id;
	}
	public void setInvcitem_taxtype_id(int invcitem_taxtype_id) {
		this.invcitem_taxtype_id = invcitem_taxtype_id;
	}
	public int getInvcitem_qty_uom_id() {
		return invcitem_qty_uom_id;
	}
	public void setInvcitem_qty_uom_id(int invcitem_qty_uom_id) {
		this.invcitem_qty_uom_id = invcitem_qty_uom_id;
	}
	public double getInvcitem_qty_invuomratio() {
		return invcitem_qty_invuomratio;
	}
	public void setInvcitem_qty_invuomratio(double invcitem_qty_invuomratio) {
		this.invcitem_qty_invuomratio = invcitem_qty_invuomratio;
	}
	public int getInvcitem_price_uom_id() {
		return invcitem_price_uom_id;
	}
	public void setInvcitem_price_uom_id(int invcitem_price_uom_id) {
		this.invcitem_price_uom_id = invcitem_price_uom_id;
	}
	public double getInvcitem_price_invuomratio() {
		return invcitem_price_invuomratio;
	}
	public void setInvcitem_price_invuomratio(double invcitem_price_invuomratio) {
		this.invcitem_price_invuomratio = invcitem_price_invuomratio;
	}
	public int getInvcitem_coitem_id() {
		return invcitem_coitem_id;
	}
	public void setInvcitem_coitem_id(int invcitem_coitem_id) {
		this.invcitem_coitem_id = invcitem_coitem_id;
	}
	public boolean isInvcitem_updateinv() {
		return invcitem_updateinv;
	}
	public void setInvcitem_updateinv(boolean invcitem_updateinv) {
		this.invcitem_updateinv = invcitem_updateinv;
	}
	public int getInvcitem_rev_accnt_id() {
		return invcitem_rev_accnt_id;
	}
	public void setInvcitem_rev_accnt_id(int invcitem_rev_accnt_id) {
		this.invcitem_rev_accnt_id = invcitem_rev_accnt_id;
	}
	public double getInvcitem_listprice() {
		return invcitem_listprice;
	}
	public void setInvcitem_listprice(double invcitem_listprice) {
		this.invcitem_listprice = invcitem_listprice;
	}
	public int getInvcitem_subnumber() {
		return invcitem_subnumber;
	}
	public void setInvcitem_subnumber(int invcitem_subnumber) {
		this.invcitem_subnumber = invcitem_subnumber;
	}
}
