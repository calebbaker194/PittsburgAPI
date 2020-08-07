package xtuple;

import helpers.ResultList;
import helpers.SQL;

public class XItemSite {
	private int id;
	private int item_id;
	private int warehous_id;
	private double qtyonhand;
	private boolean loccntrl;
	private char issuemethod;
	private char controlmethod;
	private boolean active;
	private int plancode_id;
	private int costcat_id;
	private boolean sold;
	private boolean freeze;
	private int location_id;
	private String notes;
	private char costmethod;
	private double value;
	private int lsseq_id;
	
	
	public XItemSite()
	{
		
	}
	public XItemSite(int itemsite_id)
	{
		ResultList r = SQL.executeQuery("SELECT * FROM itemsite WHERE itemsite_id=" + itemsite_id+";");
		
		if(r.first())
		{
			setId((Integer) r.get("itemsite_id"));
			setItem_id((Integer) r.get("itemsite_item_id"));
			setWarehous_id((Integer) r.get("itemsite_warehous_id"));
			setQtyonhand((Double) r.get("itemsite_qtyonhand"));
			setLoccntrl((Boolean) r.get("itemsite_loccntrl"));
			setIssuemethod(((String) r.get("itemsite_issuemethod")).charAt(0));
			setControlmethod(((String) r.get("itemsite_controlmethod")).charAt(0));
			setActive((Boolean) r.get("itemsite_active"));
			setPlancode_id((Integer) r.get("itemsite_plancode_id"));
			setCostcat_id((Integer) r.get("itemsite_costcat_id"));
			setSold((Boolean) r.get("itemsite_sold"));
			setFreeze((Boolean) r.get("itemsite_freeze"));
			setLocation_id((Integer) r.get("itemsite_location_id"));
			setNotes((String) r.get("itemsite_notes"));
			setCostmethod(((String) r.get("itemsite_costmethod")).charAt(0));
			setValue((Integer) r.get("itemsite_value"));
			setLsseq_id((Integer) r.get("itemsite_lsseq_id"));
		}
		else 
		{
			id = -1;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getWarehous_id() {
		return warehous_id;
	}
	public void setWarehous_id(int warehous_id) {
		this.warehous_id = warehous_id;
	}
	public double getQtyonhand() {
		return qtyonhand;
	}
	public void setQtyonhand(double qtyonhand) {
		this.qtyonhand = qtyonhand;
	}
	public boolean isLoccntrl() {
		return loccntrl;
	}
	public void setLoccntrl(boolean loccntrl) {
		this.loccntrl = loccntrl;
	}
	public char getIssuemethod() {
		return issuemethod;
	}
	public void setIssuemethod(char issuemethod) {
		this.issuemethod = issuemethod;
	}
	public char getControlmethod() {
		return controlmethod;
	}
	public void setControlmethod(char controlmethod) {
		this.controlmethod = controlmethod;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getPlancode_id() {
		return plancode_id;
	}
	public void setPlancode_id(int plancode_id) {
		this.plancode_id = plancode_id;
	}
	public int getCostcat_id() {
		return costcat_id;
	}
	public void setCostcat_id(int costcat_id) {
		this.costcat_id = costcat_id;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public boolean isFreeze() {
		return freeze;
	}
	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public char getCostmethod() {
		return costmethod;
	}
	public void setCostmethod(char costmethod) {
		this.costmethod = costmethod;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getLsseq_id() {
		return lsseq_id;
	}
	public void setLsseq_id(int lsseq_id) {
		this.lsseq_id = lsseq_id;
	}
}
