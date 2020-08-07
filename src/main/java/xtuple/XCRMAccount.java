package xtuple;

import java.sql.Timestamp;
import java.util.ArrayList;

import helpers.ResultList;
import helpers.SQL;

public class XCRMAccount 
{
	private int id;
	private String number;
	private String name;
	private boolean active;
	private char type;
	private int cust_id;
	private XCustInfo customer = null;
	private int competitor_id;
	private int partner_id;
	private int prospect_id;
	private int vend_id;
	private XVendInfo vendor = null;
	private int cntct_id_1;
	private int cntct_id_2;
	private int parent_id;
	private String notes;
	private int taxauth_id;
	private String owner_username;
	private int emp_id;
	private int salesrep_id;
	private String usr_username;
	private Timestamp created;
	private Timestamp lastupdated;
	private ArrayList<XContact> contacts = null;
	
	public XCRMAccount() {
		
	}
	
	public XCRMAccount(String crmacct_number) 
	{
		ResultList r = SQL.executeQuery("SELECT * FROM crmacct WHERE crmacct_number='"+crmacct_number+"';");
		
		setId(r.getInt("crmacct_id"));
		setNumber(r.getString("crmacct_number"));
		setName(r.getString("crmacct_name"));
		setActive(r.getBoolean("crmacct_active"));
		setType(r.getChar("crmacct_type"));
		setCust_id(r.getInt("crmacct_cust_id"));
		setCompetitor_id(r.getInt("crmacct_competitor_id"));
		setPartner_id(r.getInt("crmacct_partner_id"));
		setProspect_id(r.getInt("crmacct_prospect_id"));
		setVend_id(r.getInt("crmacct_vend_id"));
		setCntct_id_1(r.getInt("crmacct_cntct_id_1"));
		setCntct_id_2(r.getInt("crmacct_cntct_id_2"));
		setParent_id(r.getInt("crmacct_parent_id"));
		setNotes(r.getString("crmacct_notes"));
		setTaxauth_id(r.getInt("crmacct_taxauth_id"));
		setOwner_username(r.getString("crmacct_owner_username"));
		setEmp_id(r.getInt("crmacct_emp_id"));
		setSalesrep_id(r.getInt("crmacct_salesrep_id"));
		setUsr_username(r.getString("crmacct_usr_username"));
		setCreated(r.getTimeStamp("crmacct_created"));
		setLastupdated(r.getTimeStamp("crmacct_lastupdated"));
	}

	public XCRMAccount(int crmacct_id) 
	{
		ResultList r = SQL.executeQuery("SELECT * FROM crmacct WHERE crmacct_id="+crmacct_id+";");
		
		setId(r.getInt("crmacct_id"));
		setNumber(r.getString("crmacct_number"));
		setName(r.getString("crmacct_name"));
		setActive(r.getBoolean("crmacct_active"));
		setType(r.getChar("crmacct_type"));
		setCust_id(r.getInt("crmacct_cust_id"));
		setCompetitor_id(r.getInt("crmacct_competitor_id"));
		setPartner_id(r.getInt("crmacct_partner_id"));
		setProspect_id(r.getInt("crmacct_prospect_id"));
		setVend_id(r.getInt("crmacct_vend_id"));
		setCntct_id_1(r.getInt("crmacct_cntct_id_1"));
		setCntct_id_2(r.getInt("crmacct_cntct_id_2"));
		setParent_id(r.getInt("crmacct_parent_id"));
		setNotes(r.getString("crmacct_notes"));
		setTaxauth_id(r.getInt("crmacct_taxauth_id"));
		setOwner_username(r.getString("crmacct_owner_username"));
		setEmp_id(r.getInt("crmacct_emp_id"));
		setSalesrep_id(r.getInt("crmacct_salesrep_id"));
		setUsr_username(r.getString("crmacct_usr_username"));
		setCreated(r.getTimeStamp("crmacct_created"));
		setLastupdated(r.getTimeStamp("crmacct_lastupdated"));
	}
	
	
	public ArrayList<XContact> fetchContacts()
	{
		contacts = XContact.fetchContacts(id);
		return contacts;
	}
	
	public ArrayList<XContact> getContacts()
	{
		if(contacts == null)
			contacts = XContact.fetchContacts(id);
		return contacts;
	}
	
	public XCustInfo fetchCustomerInfo()
	{
		customer = new XCustInfo(cust_id);
		return customer;	
	}
	
	public XCustInfo getCustomerInfo()
	{  
		if(customer == null)
			customer = new XCustInfo(cust_id);
		return customer;
	}
	
	public XVendInfo fetchVendorInfo()
	{
		vendor = new XVendInfo(vend_id);
		return vendor;
	}
	
	public XVendInfo getVendorInfo()
	{
		if(vendor == null)
			vendor = new XVendInfo(vend_id);
		return vendor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getCompetitor_id() {
		return competitor_id;
	}

	public void setCompetitor_id(int competitor_id) {
		this.competitor_id = competitor_id;
	}

	public int getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}

	public int getProspect_id() {
		return prospect_id;
	}

	public void setProspect_id(int prospect_id) {
		this.prospect_id = prospect_id;
	}

	public int getVend_id() {
		return vend_id;
	}

	public void setVend_id(int vend_id) {
		this.vend_id = vend_id;
	}

	public int getCntct_id_1() {
		return cntct_id_1;
	}

	public void setCntct_id_1(int cntct_id_1) {
		this.cntct_id_1 = cntct_id_1;
	}

	public int getCntct_id_2() {
		return cntct_id_2;
	}

	public void setCntct_id_2(int cntct_id_2) {
		this.cntct_id_2 = cntct_id_2;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getTaxauth_id() {
		return taxauth_id;
	}

	public void setTaxauth_id(int taxauth_id) {
		this.taxauth_id = taxauth_id;
	}

	public String getOwner_username() {
		return owner_username;
	}

	public void setOwner_username(String owner_username) {
		this.owner_username = owner_username;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getSalesrep_id() {
		return salesrep_id;
	}

	public void setSalesrep_id(int salesrep_id) {
		this.salesrep_id = salesrep_id;
	}

	public String getUsr_username() {
		return usr_username;
	}

	public void setUsr_username(String usr_username) {
		this.usr_username = usr_username;
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
