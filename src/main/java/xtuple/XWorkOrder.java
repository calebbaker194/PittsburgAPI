package xtuple;

import java.sql.Timestamp;

import helpers.ResultList;
import helpers.SQL;

public class XWorkOrder {
	private int id;
	private int number;
	private int subnumber;
	private char status;
	private int itemsite_id;
	private Timestamp startdate;
	private Timestamp duedate;
	private char ordtype;
	private int ordid;
	private double qtyord;
	private double qtyrcv;
	private boolean adhoc;
	private int itemcfg_series;
	private boolean imported;
	private double wipvalue;
	private double postedvalue;
	private String prodnotes;
	private int prj_id;
	private int priority;
	private double brdvalue;
	private int bom_rev_id;
	private int boo_rev_id;
	private char cosmethod;
	private int womatl_id;
	private String username;
	private Timestamp created;
	private Timestamp lastupdated;
	private Timestamp closedate;
	
	public XWorkOrder() {
		
	}
	
	public XWorkOrder(int wo_id) 
	{
		ResultList r = SQL.executeQuery("SELECT * FROM wo WHERE wo_id="+wo_id);
		
		setId(r.getInt("wo_id"));
		setNumber(r.getInt("wo_number"));
		setSubnumber(r.getInt("wo_subnumber"));
		setStatus(r.getChar("wo_status"));
		setItemsite_id(r.getInt("wo_itemsite_id"));
		setStartdate(r.getTimeStamp("wo_startdate"));
		setDuedate(r.getTimeStamp("wo_duedate"));
		setOrdtype(r.getChar("wo_ordtype"));
		setOrdid(r.getInt("wo_ordid"));
		setQtyord(r.getDouble("wo_qtyord"));
		setQtyrcv(r.getDouble("wo_qtyrcv"));
		setAdhoc(r.getBoolean("wo_adhoc"));
		setItemcfg_series(r.getInt("wo_itemcfg_series"));
		setImported(r.getBoolean("wo_imported"));
		setWipvalue(r.getDouble("wo_wipvalue"));
		setPostedvalue(r.getDouble("wo_postedvalue"));
		setProdnotes(r.getString("wo_prodnotes"));
		setPrj_id(r.getInt("wo_prj_id"));
		setPriority(r.getInt("wo_priority"));
		setBrdvalue(r.getDouble("wo_brdvalue"));
		setBom_rev_id(r.getInt("wo_bom_rev_id"));
		setBoo_rev_id(r.getInt("wo_boo_rev_id"));
		setCosmethod(r.getChar("wo_cosmethod"));
		setWomatl_id(r.getInt("wo_womatl_id"));
		setUsername(r.getString("wo_username"));
		setCreated(r.getTimeStamp("wo_created"));
		setLastupdated(r.getTimeStamp("wo_lastupdated"));
		setClosedate(r.getTimeStamp("wo_closedate"));
	}
	
	public XWorkOrder(String wo_number) 
	{
		ResultList r = SQL.executeQuery("SELECT * FROM wo WHERE wo_number="+wo_number);
		
		setId(r.getInt("wo_id"));
		setNumber(r.getInt("wo_number"));
		setSubnumber(r.getInt("wo_subnumber"));
		setStatus(r.getChar("wo_status"));
		setItemsite_id(r.getInt("wo_itemsite_id"));
		setStartdate(r.getTimeStamp("wo_startdate"));
		setDuedate(r.getTimeStamp("wo_duedate"));
		setOrdtype(r.getChar("wo_ordtype"));
		setOrdid(r.getInt("wo_ordid"));
		setQtyord(r.getDouble("wo_qtyord"));
		setQtyrcv(r.getDouble("wo_qtyrcv"));
		setAdhoc(r.getBoolean("wo_adhoc"));
		setItemcfg_series(r.getInt("wo_itemcfg_series"));
		setImported(r.getBoolean("wo_imported"));
		setWipvalue(r.getDouble("wo_wipvalue"));
		setPostedvalue(r.getDouble("wo_postedvalue"));
		setProdnotes(r.getString("wo_prodnotes"));
		setPrj_id(r.getInt("wo_prj_id"));
		setPriority(r.getInt("wo_priority"));
		setBrdvalue(r.getDouble("wo_brdvalue"));
		setBom_rev_id(r.getInt("wo_bom_rev_id"));
		setBoo_rev_id(r.getInt("wo_boo_rev_id"));
		setCosmethod(r.getChar("wo_cosmethod"));
		setWomatl_id(r.getInt("wo_womatl_id"));
		setUsername(r.getString("wo_username"));
		setCreated(r.getTimeStamp("wo_created"));
		setLastupdated(r.getTimeStamp("wo_lastupdated"));
		setClosedate(r.getTimeStamp("wo_closedate"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSubnumber() {
		return subnumber;
	}

	public void setSubnumber(int subnumber) {
		this.subnumber = subnumber;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getItemsite_id() {
		return itemsite_id;
	}

	public void setItemsite_id(int itemsite_id) {
		this.itemsite_id = itemsite_id;
	}

	public Timestamp getStartdate() {
		return startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	public Timestamp getDuedate() {
		return duedate;
	}

	public void setDuedate(Timestamp duedate) {
		this.duedate = duedate;
	}

	public char getOrdtype() {
		return ordtype;
	}

	public void setOrdtype(char ordtype) {
		this.ordtype = ordtype;
	}

	public int getOrdid() {
		return ordid;
	}

	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}

	public double getQtyord() {
		return qtyord;
	}

	public void setQtyord(double qtyord) {
		this.qtyord = qtyord;
	}

	public double getQtyrcv() {
		return qtyrcv;
	}

	public void setQtyrcv(double qtyrcv) {
		this.qtyrcv = qtyrcv;
	}

	public boolean isAdhoc() {
		return adhoc;
	}

	public void setAdhoc(boolean adhoc) {
		this.adhoc = adhoc;
	}

	public int getItemcfg_series() {
		return itemcfg_series;
	}

	public void setItemcfg_series(int itemcfg_series) {
		this.itemcfg_series = itemcfg_series;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public double getWipvalue() {
		return wipvalue;
	}

	public void setWipvalue(double wipvalue) {
		this.wipvalue = wipvalue;
	}

	public double getPostedvalue() {
		return postedvalue;
	}

	public void setPostedvalue(double postedvalue) {
		this.postedvalue = postedvalue;
	}

	public String getProdnotes() {
		return prodnotes;
	}

	public void setProdnotes(String prodnotes) {
		this.prodnotes = prodnotes;
	}

	public int getPrj_id() {
		return prj_id;
	}

	public void setPrj_id(int prj_id) {
		this.prj_id = prj_id;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public double getBrdvalue() {
		return brdvalue;
	}

	public void setBrdvalue(double brdvalue) {
		this.brdvalue = brdvalue;
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

	public char getCosmethod() {
		return cosmethod;
	}

	public void setCosmethod(char cosmethod) {
		this.cosmethod = cosmethod;
	}

	public int getWomatl_id() {
		return womatl_id;
	}

	public void setWomatl_id(int womatl_id) {
		this.womatl_id = womatl_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Timestamp getClosedate() {
		return closedate;
	}

	public void setClosedate(Timestamp closedate) {
		this.closedate = closedate;
	}
	
	
	
}
