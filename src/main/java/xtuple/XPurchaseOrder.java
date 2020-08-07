package xtuple;

import java.sql.Timestamp;

import helpers.ResultList;
import helpers.SQL;

public class XPurchaseOrder {
	private int id;
	private char status;
	private String number;
	private Timestamp orderdate;
	private int vend_id;
	private String fob;
	private String shipvia;
	private String comments;
	private double freight;
	private boolean printed;
	private int terms_id;
	private int warehous_id;
	private int vendaddr_id;
	private String agent_username;
	private int curr_id;
	private boolean saved;
	private int taxzone_id;
	private int taxtype_id;
	private boolean dropship;
	private int vend_cntct_id;
	private String vend_cntct_first_name;
	private String vend_cntct_last_name;
	private String vend_cntct_phone;
	private String vend_cntct_email;
	private String vendaddress;
	private int shipto_cntct_id;
	private String shipto_cntct_first_name;
	private String shipto_cntct_last_name;
	private String shipto_cntct_phone;
	private String shipto_cntct_email;
	private int shiptoaddress_id;
	private String shiptoaddress;
    private int cohead_id;
    private Timestamp released;
    private String shiptoname;
    private Timestamp created;
    private Timestamp lastupdated;
    private int potype_id;
    
    public XPurchaseOrder()
    {
    	
    }
    
    public XPurchaseOrder(String poNumber)
    {
    	ResultList r = SQL.executeQuery("SELECT * FROM pohead WHERE pohead_number = '"+poNumber+"';");
    	
    	if(r.first())
    	{
    		setId(r.getInt("pohead_id"));
    		setStatus(r.getString("pohead_status").charAt(0));
    		setNumber(r.getString("pohead_number"));
    		setOrderdate(r.getTimeStamp("pohead_orderdate"));
    		setVend_id(r.getInt("pohead_vend_id"));
    		setFob(r.getString("pohead_fob"));
    		setShipvia(r.getString("pohead_shipvia"));
    		setComments(r.getString("pohead_comments"));
    		setFreight(r.getDouble("pohead_freight"));
    		setPrinted(r.getBoolean("pohead_printed"));
    		setTerms_id(r.getInt("pohead_terms_id"));
    		setWarehous_id(r.getInt("pohead_warehous_id"));
    		setVendaddr_id(r.getInt("pohead_vendaddr_id"));
    		setAgent_username(r.getString("pohead_agent_username"));
    		setCurr_id(r.getInt("pohead_curr_id"));
    		setSaved(r.getBoolean("pohead_saved"));
    		setTaxzone_id(r.getInt("pohead_taxzone_id"));
    		setTaxtype_id(r.getInt("pohead_taxtype_id"));
    		setDropship(r.getBoolean("pohead_dropship"));
    		setVend_cntct_id(r.getInt("pohead_vend_cntct_id"));
    		setVend_cntct_first_name(r.getString("pohead_vend_cntct_first_name"));
    		setVend_cntct_last_name(r.getString("pohead_vend_cntct_last_name"));
    		setVend_cntct_phone(r.getString("pohead_vend_cntct_phone"));
    		setVend_cntct_email(r.getString("pohead_vend_cntct_email"));
    		setVendaddress(r.getString("pohead_vendaddress1")+"\n"+r.getString("pohead_vendaddress2")+"\n"+r.getString("pohead_vendaddress3"));
    		setShipto_cntct_id(r.getInt("pohead_shipto_cntct_id"));
    		setShipto_cntct_first_name(r.getString("pohead_shipto_cntct_first_name"));
    		setShipto_cntct_last_name(r.getString("pohead_shipto_cntct_last_name"));
    		setShipto_cntct_phone(r.getString("pohead_shipto_cntct_phone"));
    		setShipto_cntct_email(r.getString("pohead_shipto_cntct_email"));
    		setShiptoaddress_id(r.getInt("pohead_shiptoaddress_id"));
    		setShiptoaddress(r.getString("pohead_shiptoaddress1")+"\n"+r.getString("pohead_shiptoaddress2")+"\n"+r.getString("pohead_shiptoaddress3"));
    		setCohead_id(r.getInt("pohead_cohead_id"));
    		setReleased(r.getTimeStamp("pohead_released"));
    		setShiptoname(r.getString("pohead_shiptoname"));
    		setCreated(r.getTimeStamp("pohead_created"));
    		setLastupdated(r.getTimeStamp("pohead_lastupdated"));
    		setPotype_id(r.getInt("pohead_potype_id"));
    	}
    	else
    	{
    		setId(-1);
    	}
    }
    
    public XPurchaseOrder(int poId)
    {
    	ResultList r = SQL.executeQuery("SELECT * FROM pohead WHERE pohead_id = "+poId+";");
    	
    	if(r.first())
    	{
    		setId(r.getInt("pohead_id"));
    		setStatus(r.getString("pohead_status").charAt(0));
    		setNumber(r.getString("pohead_number"));
    		setOrderdate(r.getTimeStamp("pohead_orderdate"));
    		setVend_id(r.getInt("pohead_vend_id"));
    		setFob(r.getString("pohead_fob"));
    		setShipvia(r.getString("pohead_shipvia"));
    		setComments(r.getString("pohead_comments"));
    		setFreight(r.getDouble("pohead_freight"));
    		setPrinted(r.getBoolean("pohead_printed"));
    		setTerms_id(r.getInt("pohead_terms_id"));
    		setWarehous_id(r.getInt("pohead_warehous_id"));
    		setVendaddr_id(r.getInt("pohead_vendaddr_id"));
    		setAgent_username(r.getString("pohead_agent_username"));
    		setCurr_id(r.getInt("pohead_curr_id"));
    		setSaved(r.getBoolean("pohead_saved"));
    		setTaxzone_id(r.getInt("pohead_taxzone_id"));
    		setTaxtype_id(r.getInt("pohead_taxtype_id"));
    		setDropship(r.getBoolean("pohead_dropship"));
    		setVend_cntct_id(r.getInt("pohead_vend_cntct_id"));
    		setVend_cntct_first_name(r.getString("pohead_vend_cntct_first_name"));
    		setVend_cntct_last_name(r.getString("pohead_vend_cntct_last_name"));
    		setVend_cntct_phone(r.getString("pohead_vend_cntct_phone"));
    		setVend_cntct_email(r.getString("pohead_vend_cntct_email"));
    		setVendaddress(r.getString("pohead_vendaddress1")+"\n"+r.getString("pohead_vendaddress2")+"\n"+r.getString("pohead_vendaddress3"));
    		setShipto_cntct_id(r.getInt("pohead_shipto_cntct_id"));
    		setShipto_cntct_first_name(r.getString("pohead_shipto_cntct_first_name"));
    		setShipto_cntct_last_name(r.getString("pohead_shipto_cntct_last_name"));
    		setShipto_cntct_phone(r.getString("pohead_shipto_cntct_phone"));
    		setShipto_cntct_email(r.getString("pohead_shipto_cntct_email"));
    		setShiptoaddress_id(r.getInt("pohead_shiptoaddress_id"));
    		setShiptoaddress(r.getString("pohead_shiptoaddress1")+"\n"+r.getString("pohead_shiptoaddress2")+"\n"+r.getString("pohead_shiptoaddress3"));
    		setCohead_id(r.getInt("pohead_cohead_id"));
    		setReleased(r.getTimeStamp("pohead_released"));
    		setShiptoname(r.getString("pohead_shiptoname"));
    		setCreated(r.getTimeStamp("pohead_created"));
    		setLastupdated(r.getTimeStamp("pohead_lastupdated"));
    		setPotype_id(r.getInt("pohead_potype_id"));
    	}
    	else
    	{
    		setId(-1);
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Timestamp getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}
	public int getVend_id() {
		return vend_id;
	}
	public void setVend_id(int vend_id) {
		this.vend_id = vend_id;
	}

	public String getFob() {
		return fob;
	}

	public void setFob(String fob) {
		this.fob = fob;
	}

	public String getShipvia() {
		return shipvia;
	}

	public void setShipvia(String hipvia) {
		this.shipvia = hipvia;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public boolean isPrinted() {
		return printed;
	}

	public void setPrinted(boolean printed) {
		this.printed = printed;
	}

	public int getTerms_id() {
		return terms_id;
	}

	public void setTerms_id(int terms_id) {
		this.terms_id = terms_id;
	}

	public int getWarehous_id() {
		return warehous_id;
	}

	public void setWarehous_id(int warehous_id) {
		this.warehous_id = warehous_id;
	}

	public int getVendaddr_id() {
		return vendaddr_id;
	}

	public void setVendaddr_id(int vendaddr_id) {
		this.vendaddr_id = vendaddr_id;
	}

	public String getAgent_username() {
		return agent_username;
	}

	public void setAgent_username(String agent_username) {
		this.agent_username = agent_username;
	}

	public int getCurr_id() {
		return curr_id;
	}

	public void setCurr_id(int curr_id) {
		this.curr_id = curr_id;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public int getTaxzone_id() {
		return taxzone_id;
	}

	public void setTaxzone_id(int taxzone_id) {
		this.taxzone_id = taxzone_id;
	}

	public int getTaxtype_id() {
		return taxtype_id;
	}

	public void setTaxtype_id(int taxtype_id) {
		this.taxtype_id = taxtype_id;
	}

	public boolean isDropship() {
		return dropship;
	}

	public void setDropship(boolean dropship) {
		this.dropship = dropship;
	}

	public int getVend_cntct_id() {
		return vend_cntct_id;
	}

	public void setVend_cntct_id(int vend_cntct_id) {
		this.vend_cntct_id = vend_cntct_id;
	}

	public String getVend_cntct_first_name() {
		return vend_cntct_first_name;
	}

	public void setVend_cntct_first_name(String vend_cntct_first_name) {
		this.vend_cntct_first_name = vend_cntct_first_name;
	}

	public String getVend_cntct_last_name() {
		return vend_cntct_last_name;
	}

	public void setVend_cntct_last_name(String vend_cntct_last_name) {
		this.vend_cntct_last_name = vend_cntct_last_name;
	}

	public String getVend_cntct_phone() {
		return vend_cntct_phone;
	}

	public void setVend_cntct_phone(String vend_cntct_phone) {
		this.vend_cntct_phone = vend_cntct_phone;
	}

	public String getVend_cntct_email() {
		return vend_cntct_email;
	}

	public void setVend_cntct_email(String vend_cntct_email) {
		this.vend_cntct_email = vend_cntct_email;
	}

	public String getVendaddress() {
		return vendaddress;
	}

	public void setVendaddress(String vendaddress) {
		this.vendaddress = vendaddress;
	}

	public int getShipto_cntct_id() {
		return shipto_cntct_id;
	}

	public void setShipto_cntct_id(int shipto_cntct_id) {
		this.shipto_cntct_id = shipto_cntct_id;
	}

	public String getShipto_cntct_first_name() {
		return shipto_cntct_first_name;
	}

	public void setShipto_cntct_first_name(String shipto_cntct_first_name) {
		this.shipto_cntct_first_name = shipto_cntct_first_name;
	}

	public String getShipto_cntct_last_name() {
		return shipto_cntct_last_name;
	}

	public void setShipto_cntct_last_name(String shipto_cntct_last_name) {
		this.shipto_cntct_last_name = shipto_cntct_last_name;
	}

	public String getShipto_cntct_phone() {
		return shipto_cntct_phone;
	}

	public void setShipto_cntct_phone(String shipto_cntct_phone) {
		this.shipto_cntct_phone = shipto_cntct_phone;
	}

	public String getShipto_cntct_email() {
		return shipto_cntct_email;
	}

	public void setShipto_cntct_email(String shipto_cntct_email) {
		this.shipto_cntct_email = shipto_cntct_email;
	}

	public int getShiptoaddress_id() {
		return shiptoaddress_id;
	}

	public void setShiptoaddress_id(int shiptoaddress_id) {
		this.shiptoaddress_id = shiptoaddress_id;
	}

	public String getShiptoaddress() {
		return shiptoaddress;
	}

	public void setShiptoaddress(String shiptoaddress) {
		this.shiptoaddress = shiptoaddress;
	}

	public int getCohead_id() {
		return cohead_id;
	}

	public void setCohead_id(int cohead_id) {
		this.cohead_id = cohead_id;
	}

	public Timestamp getReleased() {
		return released;
	}

	public void setReleased(Timestamp released) {
		this.released = released;
	}

	public String getShiptoname() {
		return shiptoname;
	}

	public void setShiptoname(String shiptoname) {
		this.shiptoname = shiptoname;
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

	public int getPotype_id() {
		return potype_id;
	}

	public void setPotype_id(int potype_id) {
		this.potype_id = potype_id;
	}
	

}
