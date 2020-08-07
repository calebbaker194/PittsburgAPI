package xtuple;

import helpers.ResultList;
import helpers.SQL;

public class XItemLot {
	private int itemloc_id;
	private int itemsite_id;
	private int location_id;
	private double qty;
	private int ls_id;
	private int item_id;
	private int ls_number;
	
	public XItemLot()
	{
		
	}
	public XItemLot(int itemloc_id)
	{
		this(itemloc_id,"itemloc_id");
	}
	public XItemLot(String lsNumber)
	{
		ResultList r = SQL.executeQuery("SELECT * FROM itemloc JOIN ls ON (ls_id = itemloc_ls_id) WHERE ls_number = '" +lsNumber+ "';");
		setItemloc_id((Integer) r.get("itemloc_id"));
		setItem_id((Integer) r.get("ls_item_id"));
		setItemsite_id((Integer) r.get("itemloc_itemsite_id"));
		setLocation_id((Integer) r.get("itemloc_location_id"));
		setQty((Double) r.get("itemloc_location_id"));
		setLs_id((Integer) r.get("itemloc_location_id"));
		setItem_id((Integer) r.get("itemloc_location_id"));
		setLsNumber((Integer) r.get("itemloc_location_id"));	
	}
	/**
	 * 
	 * @param id - the id for the table that you will be using this from.
	 * @param fromTable - itemloc_id if you have that integer and ls_id if you want to go from that Table
	 */
	public XItemLot(int id,String fromTable)
	{
		ResultList r = SQL.executeQuery("SELECT * FROM itemloc JOIN ls ON (ls_id = itemloc_ls_id) WHERE "+fromTable+" = " +itemloc_id+ ";");
		setItemloc_id((Integer) r.get("itemloc_id"));
		setItem_id((Integer) r.get("ls_item_id"));
		setItemsite_id((Integer) r.get("itemloc_itemsite_id"));
		setLocation_id((Integer) r.get("itemloc_location_id"));
		setQty((Double) r.get("itemloc_location_id"));
		setLs_id((Integer) r.get("itemloc_location_id"));
		setItem_id((Integer) r.get("itemloc_location_id"));
		setLsNumber((Integer) r.get("itemloc_location_id"));
	}

	
	public int getItemloc_id() {
		return itemloc_id;
	}
	public void setItemloc_id(int itemloc_id) {
		this.itemloc_id = itemloc_id;
	}
	public int getItemsite_id() {
		return itemsite_id;
	}
	public void setItemsite_id(int itemsite_id) {
		this.itemsite_id = itemsite_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public int getLs_id() {
		return ls_id;
	}
	public void setLs_id(int ls_id) {
		this.ls_id = ls_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getLsNumber() {
		return ls_number;
	}
	public void setLsNumber(int number) {
		this.ls_number = number;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	private String notes;
	
}
