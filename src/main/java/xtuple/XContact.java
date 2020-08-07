package xtuple;

import java.sql.Timestamp;
import java.util.ArrayList;

import helpers.ResultList;
import helpers.SQL;

public class XContact {

	private int id;
	private int crmacct_id;
	private int addr_id;
	private String first_name;
	private String last_name;
	private String honorific;
	private String initials;
	private boolean active;
	private String phone;
	private String phone2;
	private String fax;
	private String email;
	private String webaddr;
	private String notes;
	private String title;
	private String number;
	private String middle;
	private String suffix;
	private String owner_username;
	private String name;
	private Timestamp created;
	private Timestamp lastupdated;
	
	public XContact() {}
	
	public XContact(int cntct_id) 
	{
		ResultList r = SQL.executeQuery("SELECT * FROM cntct WHERE cntct_id="+cntct_id);
		
		setId(r.getInt("cntct_id"));
		setCrmacct_id(r.getInt("cntct_crmacct_id"));
		setAddr_id(r.getInt("cntct_addr_id"));
		setFirst_name(r.getString("cntct_first_name"));
		setLast_name(r.getString("cntct_last_name"));
		setHonorific(r.getString("cntct_honorific"));
		setInitials(r.getString("cntct_initials"));
		setActive(r.getBoolean("cntct_active"));
		setPhone(r.getString("cntct_phone"));
		setPhone2(r.getString("cntct_phone2"));
		setFax(r.getString("cntct_fax"));
		setEmail(r.getString("cntct_email"));
		setWebaddr(r.getString("cntct_webaddr"));
		setNotes(r.getString("cntct_notes"));
		setTitle(r.getString("cntct_title"));
		setNumber(r.getString("cntct_number"));
		setMiddle(r.getString("cntct_middle"));
		setSuffix(r.getString("cntct_suffix"));
		setOwner_username(r.getString("cntct_owner_username"));
		setName(r.getString("cntct_name"));
		setCreated(r.getTimeStamp("cntct_created"));
		setLastupdated(r.getTimeStamp("cntct_lastupdated"));
	}
	
	public static ArrayList<XContact> fetchContacts(int crmacct_id) 
	{
		ResultList r = SQL.executeQuery("SELECT * FROM cntct WHERE cntct_crmacct_id="+crmacct_id);
		
		if(r.first())
		{
			ArrayList<XContact> temp = new ArrayList<XContact>();
			do
			{
				XContact tempItem = new XContact();
				
				tempItem.setId(r.getInt("cntct_id"));
				tempItem.setCrmacct_id(r.getInt("cntct_crmacct_id"));
				tempItem.setAddr_id(r.getInt("cntct_addr_id"));
				tempItem.setFirst_name(r.getString("cntct_first_name"));
				tempItem.setLast_name(r.getString("cntct_last_name"));
				tempItem.setHonorific(r.getString("cntct_honorific"));
				tempItem.setInitials(r.getString("cntct_initials"));
				tempItem.setActive(r.getBoolean("cntct_active"));
				tempItem.setPhone(r.getString("cntct_phone"));
				tempItem.setPhone2(r.getString("cntct_phone2"));
				tempItem.setFax(r.getString("cntct_fax"));
				tempItem.setEmail(r.getString("cntct_email"));
				tempItem.setWebaddr(r.getString("cntct_webaddr"));
				tempItem.setNotes(r.getString("cntct_notes"));
				tempItem.setTitle(r.getString("cntct_title"));
				tempItem.setNumber(r.getString("cntct_number"));
				tempItem.setMiddle(r.getString("cntct_middle"));
				tempItem.setSuffix(r.getString("cntct_suffix"));
				tempItem.setOwner_username(r.getString("cntct_owner_username"));
				tempItem.setName(r.getString("cntct_name"));
				tempItem.setCreated(r.getTimeStamp("cntct_created"));
				tempItem.setLastupdated(r.getTimeStamp("cntct_lastupdated"));
			}
			while(r.next());
			return temp;
		}
		else
		{
			return new ArrayList<XContact>();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCrmacct_id() {
		return crmacct_id;
	}

	public void setCrmacct_id(int crmacct_id) {
		this.crmacct_id = crmacct_id;
	}

	public int getAddr_id() {
		return addr_id;
	}

	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getHonorific() {
		return honorific;
	}

	public void setHonorific(String honorific) {
		this.honorific = honorific;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebaddr() {
		return webaddr;
	}

	public void setWebaddr(String webaddr) {
		this.webaddr = webaddr;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMiddle() {
		return middle;
	}

	public void setMiddle(String middle) {
		this.middle = middle;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getOwner_username() {
		return owner_username;
	}

	public void setOwner_username(String owner_username) {
		this.owner_username = owner_username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
