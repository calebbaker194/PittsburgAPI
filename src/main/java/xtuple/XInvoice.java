package xtuple;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import helpers.DataTableRequest;
import helpers.Mapper;
import helpers.ResultList;
import helpers.SQL;
import objects.CustInvoice;

public class XInvoice {
	
	
	
	private int invchead_id;
	private int invchead_cust_id;
	private int invchead_shipto_id;
	private String invchead_ordernumber;
	private Date invchead_orderdate;
	private boolean invchead_posted;
	private boolean invchead_printed;
	private String invchead_invcnumber;
	private Date invchead_invcdate;
	private Date invchead_shipdate;
	private String invchead_ponumber;
	private String invchead_shipvia;
	private String invchead_fob;
	private String invchead_billto_name;
	private String invchead_billto_address1;
	private String invchead_billto_address2;
	private String invchead_billto_address3;
	private String invchead_billto_city;
	private String invchead_billto_state;
	private String invchead_billto_zipcode;
	private String invchead_billto_phone;
	private String invchead_shipto_name;
	private String invchead_shipto_address1;
	private String invchead_shipto_address2;
	private String invchead_shipto_address3;
	private String invchead_shipto_city;
	private String invchead_shipto_state;
	private String invchead_shipto_zipcode;
	private String invchead_shipto_phone;
	private int invchead_salesrep_id;
	private double invchead_commission;
	private int invchead_terms_id;
	private double invchead_freight;
	private double invchead_misc_amount;
	private String invchead_misc_descrip;
	private int invchead_misc_accnt_id;
	private double invchead_payment;
	private String invchead_paymentref;
	private String invchead_notes;
	private String invchead_billto_country;
	private String invchead_shipto_country;
	private int invchead_prj_id;
	private int invchead_curr_id;
	private Date invchead_gldistdate;
	private boolean invchead_recurring;
	private int invchead_recurring_interval;
	private String invchead_recurring_type;
	private Date invchead_recurring_until;
	private int invchead_recurring_invchead_id;
	private int invchead_shipchrg_id;
	private int invchead_taxzone_id;
	private boolean invchead_void;
	private int invchead_saletype_id;
	private int invchead_shipzone_id;
	private double invchead_total;
	private double invchead_paid;
	private Date invchead_duedate;
	private Timestamp invchead_created;
	private Timestamp invchead_lastupdated;
	@JsonIgnoreProperties(value = { "obj_uuid" })
	
	public XInvoice()
	{
		
	}

	public static ArrayList<CustInvoice> getOpenInvoices(int cust_id)
	{
		String sql = "SELECT aropen_id, \r\n" + 
				"       docnumber, open,\r\n" + 
				"       docdate, duedate, amount, balance\r\n" + 
				"  FROM (\r\n" + 
				"    SELECT aropen_id,\r\n" + 
				"           aropen_docnumber AS docnumber,\r\n" + 
				"           aropen_open AS open,\r\n" + 
				"           aropen_docdate AS docdate,\r\n" + 
				"           aropen_duedate AS duedate,\r\n" + 
				"           aropen_amount AS amount,\r\n" + 
				"           (aropen_amount - aropen_paid) AS balance\r\n" + 
				"     FROM aropen\r\n" + 
				"    WHERE ( (aropen_cust_id="+cust_id+")\r\n" + 
				"   	AND aropen_doctype = 'I')\r\n" + 
				"	AND aropen_open\r\n" + 
				"  ) AS data\r\n" + 
				"  ORDER BY docdate DESC";
		
		ResultList r = SQL.executeQuery(sql);
		
		ArrayList<CustInvoice> result = new ArrayList<CustInvoice>();
		
		if(r.first())
		{
			do
			{
				HashMap<String, Object> row = r.getRow();
				CustInvoice temp = Mapper.OM.convertValue(row, CustInvoice.class);
				result.add(temp);
			}
			while(r.next());
		}
		
		return result;	
	}
	
	public static ArrayList<XInvoice> getInvoices(DataTableRequest dr)
	{
		String sql = "SELECT *, "
				+ " invoiceTotal(invchead_id) AS invchead_total, "
				+ " (SELECT SUM(arapply_applied) FROM arapply WHERE ((arapply_target_doctype='I') AND (arapply_target_docnumber = invchead_invcnumber))) AS invchead_paid, "
				+ " determineduedate(invchead_terms_id,invchead_invcdate) AS invchead_duedate "
				+ " FROM invchead WHERE invchead_cust_id = "+dr.getSearch().get("cust_id");
		
		sql += " AND invchead_invcnumber || invchead_ordernumber || invchead_ponumber LIKE '%"+ dr.getSearch().get("value") +"%'\n ORDER BY ";
		
		for(HashMap<String,String> order : dr.getOrder())
		{
			switch(Integer.parseInt(order.get("column")))
			{
			case 1:
				sql += "invchead_invcnumber "+ order.get("dir").toUpperCase() +", ";
				break;
			default:
				sql += "invchead_invcnumber "+ order.get("dir").toUpperCase() +", ";
				break;
			}
		}
		sql = sql.substring(0, sql.length()-2);
			
		sql+= " LIMIT "+dr.getLength() + " OFFSET " + dr.getStart();
		
		
		ResultList r = SQL.executeQuery(sql);
		
		ArrayList<XInvoice> result = new ArrayList<XInvoice>();
		
		if(r.first())
		{
			do
			{
				HashMap<String, Object> row = r.getRow();
				XInvoice temp = Mapper.OM.convertValue(row, XInvoice.class);
				result.add(temp);
			}
			while(r.next());
		}
		
		return result;	
		
	}
	
	@JsonIgnore
	public String getObj_uuid() {
    return null;
	}
	@JsonProperty
	public void setObj_uuid(String uuid) {
    
	}
	
	public int getInvchead_id() {
		return invchead_id;
	}
	public void setInvchead_id(int invchead_id) {
		this.invchead_id = invchead_id;
	}
	public int getInvchead_cust_id() {
		return invchead_cust_id;
	}
	public void setInvchead_cust_id(int invchead_cust_id) {
		this.invchead_cust_id = invchead_cust_id;
	}
	public int getInvchead_shipto_id() {
		return invchead_shipto_id;
	}
	public void setInvchead_shipto_id(int invchead_shipto_id) {
		this.invchead_shipto_id = invchead_shipto_id;
	}
	public String getInvchead_ordernumber() {
		return invchead_ordernumber;
	}
	public void setInvchead_ordernumber(String invchead_ordernumber) {
		this.invchead_ordernumber = invchead_ordernumber;
	}
	public Date getInvchead_orderdate() {
		return invchead_orderdate;
	}
	public void setInvchead_orderdate(Date invchead_orderdate) {
		this.invchead_orderdate = invchead_orderdate;
	}
	public boolean isInvchead_posted() {
		return invchead_posted;
	}
	public void setInvchead_posted(boolean invchead_posted) {
		this.invchead_posted = invchead_posted;
	}
	public boolean isInvchead_printed() {
		return invchead_printed;
	}
	public void setInvchead_printed(boolean invchead_printed) {
		this.invchead_printed = invchead_printed;
	}
	public String getInvchead_invcnumber() {
		return invchead_invcnumber;
	}
	public void setInvchead_invcnumber(String invchead_invcnumber) {
		this.invchead_invcnumber = invchead_invcnumber;
	}
	public Date getInvchead_invcdate() {
		return invchead_invcdate;
	}
	public void setInvchead_invcdate(Date invchead_invcdate) {
		this.invchead_invcdate = invchead_invcdate;
	}
	public Date getInvchead_shipdate() {
		return invchead_shipdate;
	}
	public void setInvchead_shipdate(Date invchead_shipdate) {
		this.invchead_shipdate = invchead_shipdate;
	}
	public String getInvchead_ponumber() {
		return invchead_ponumber;
	}
	public void setInvchead_ponumber(String invchead_ponumber) {
		this.invchead_ponumber = invchead_ponumber;
	}
	public String getInvchead_shipvia() {
		return invchead_shipvia;
	}
	public void setInvchead_shipvia(String invchead_shipvia) {
		this.invchead_shipvia = invchead_shipvia;
	}
	public String getInvchead_fob() {
		return invchead_fob;
	}
	public void setInvchead_fob(String invchead_fob) {
		this.invchead_fob = invchead_fob;
	}
	public String getInvchead_billto_name() {
		return invchead_billto_name;
	}
	public void setInvchead_billto_name(String invchead_billto_name) {
		this.invchead_billto_name = invchead_billto_name;
	}
	public String getInvchead_billto_address1() {
		return invchead_billto_address1;
	}
	public void setInvchead_billto_address1(String invchead_billto_address1) {
		this.invchead_billto_address1 = invchead_billto_address1;
	}
	public String getInvchead_billto_address2() {
		return invchead_billto_address2;
	}
	public void setInvchead_billto_address2(String invchead_billto_address2) {
		this.invchead_billto_address2 = invchead_billto_address2;
	}
	public String getInvchead_billto_address3() {
		return invchead_billto_address3;
	}
	public void setInvchead_billto_address3(String invchead_billto_address3) {
		this.invchead_billto_address3 = invchead_billto_address3;
	}
	public String getInvchead_billto_city() {
		return invchead_billto_city;
	}
	public void setInvchead_billto_city(String invchead_billto_city) {
		this.invchead_billto_city = invchead_billto_city;
	}
	public String getInvchead_billto_state() {
		return invchead_billto_state;
	}
	public void setInvchead_billto_state(String invchead_billto_state) {
		this.invchead_billto_state = invchead_billto_state;
	}
	public String getInvchead_billto_zipcode() {
		return invchead_billto_zipcode;
	}
	public void setInvchead_billto_zipcode(String invchead_billto_zipcode) {
		this.invchead_billto_zipcode = invchead_billto_zipcode;
	}
	public String getInvchead_billto_phone() {
		return invchead_billto_phone;
	}
	public void setInvchead_billto_phone(String invchead_billto_phone) {
		this.invchead_billto_phone = invchead_billto_phone;
	}
	public String getInvchead_shipto_name() {
		return invchead_shipto_name;
	}
	public void setInvchead_shipto_name(String invchead_shipto_name) {
		this.invchead_shipto_name = invchead_shipto_name;
	}
	public String getInvchead_shipto_address1() {
		return invchead_shipto_address1;
	}
	public void setInvchead_shipto_address1(String invchead_shipto_address1) {
		this.invchead_shipto_address1 = invchead_shipto_address1;
	}
	public String getInvchead_shipto_address2() {
		return invchead_shipto_address2;
	}
	public void setInvchead_shipto_address2(String invchead_shipto_address2) {
		this.invchead_shipto_address2 = invchead_shipto_address2;
	}
	public String getInvchead_shipto_address3() {
		return invchead_shipto_address3;
	}
	public void setInvchead_shipto_address3(String invchead_shipto_address3) {
		this.invchead_shipto_address3 = invchead_shipto_address3;
	}
	public String getInvchead_shipto_city() {
		return invchead_shipto_city;
	}
	public void setInvchead_shipto_city(String invchead_shipto_city) {
		this.invchead_shipto_city = invchead_shipto_city;
	}
	public String getInvchead_shipto_state() {
		return invchead_shipto_state;
	}
	public void setInvchead_shipto_state(String invchead_shipto_state) {
		this.invchead_shipto_state = invchead_shipto_state;
	}
	public String getInvchead_shipto_zipcode() {
		return invchead_shipto_zipcode;
	}
	public void setInvchead_shipto_zipcode(String invchead_shipto_zipcode) {
		this.invchead_shipto_zipcode = invchead_shipto_zipcode;
	}
	public String getInvchead_shipto_phone() {
		return invchead_shipto_phone;
	}
	public void setInvchead_shipto_phone(String invchead_shipto_phone) {
		this.invchead_shipto_phone = invchead_shipto_phone;
	}
	public int getInvchead_salesrep_id() {
		return invchead_salesrep_id;
	}
	public void setInvchead_salesrep_id(int invchead_salesrep_id) {
		this.invchead_salesrep_id = invchead_salesrep_id;
	}
	public double getInvchead_commission() {
		return invchead_commission;
	}
	public void setInvchead_commission(double invchead_commission) {
		this.invchead_commission = invchead_commission;
	}
	public int getInvchead_terms_id() {
		return invchead_terms_id;
	}
	public void setInvchead_terms_id(int invchead_terms_id) {
		this.invchead_terms_id = invchead_terms_id;
	}
	public double getInvchead_freight() {
		return invchead_freight;
	}
	public void setInvchead_freight(double invchead_freight) {
		this.invchead_freight = invchead_freight;
	}
	public double getInvchead_misc_amount() {
		return invchead_misc_amount;
	}
	public void setInvchead_misc_amount(double invchead_misc_amount) {
		this.invchead_misc_amount = invchead_misc_amount;
	}
	public String getInvchead_misc_descrip() {
		return invchead_misc_descrip;
	}
	public void setInvchead_misc_descrip(String invchead_misc_descrip) {
		this.invchead_misc_descrip = invchead_misc_descrip;
	}
	public int getInvchead_misc_accnt_id() {
		return invchead_misc_accnt_id;
	}
	public void setInvchead_misc_accnt_id(int invchead_misc_accnt_id) {
		this.invchead_misc_accnt_id = invchead_misc_accnt_id;
	}
	public double getInvchead_payment() {
		return invchead_payment;
	}
	public void setInvchead_payment(double invchead_payment) {
		this.invchead_payment = invchead_payment;
	}
	public String getInvchead_paymentref() {
		return invchead_paymentref;
	}
	public void setInvchead_paymentref(String invchead_paymentref) {
		this.invchead_paymentref = invchead_paymentref;
	}
	public String getInvchead_notes() {
		return invchead_notes;
	}
	public void setInvchead_notes(String invchead_notes) {
		this.invchead_notes = invchead_notes;
	}
	public String getInvchead_billto_country() {
		return invchead_billto_country;
	}
	public void setInvchead_billto_country(String invchead_billto_country) {
		this.invchead_billto_country = invchead_billto_country;
	}
	public String getInvchead_shipto_country() {
		return invchead_shipto_country;
	}
	public void setInvchead_shipto_country(String invchead_shipto_country) {
		this.invchead_shipto_country = invchead_shipto_country;
	}
	public int getInvchead_prj_id() {
		return invchead_prj_id;
	}
	public void setInvchead_prj_id(int invchead_prj_id) {
		this.invchead_prj_id = invchead_prj_id;
	}
	public int getInvchead_curr_id() {
		return invchead_curr_id;
	}
	public void setInvchead_curr_id(int invchead_curr_id) {
		this.invchead_curr_id = invchead_curr_id;
	}
	public Date getInvchead_gldistdate() {
		return invchead_gldistdate;
	}
	public void setInvchead_gldistdate(Date invchead_gldistdate) {
		this.invchead_gldistdate = invchead_gldistdate;
	}
	public boolean isInvchead_recurring() {
		return invchead_recurring;
	}
	public void setInvchead_recurring(boolean invchead_recurring) {
		this.invchead_recurring = invchead_recurring;
	}
	public int getInvchead_recurring_interval() {
		return invchead_recurring_interval;
	}
	public void setInvchead_recurring_interval(int invchead_recurring_interval) {
		this.invchead_recurring_interval = invchead_recurring_interval;
	}
	public String getInvchead_recurring_type() {
		return invchead_recurring_type;
	}
	public void setInvchead_recurring_type(String invchead_recurring_type) {
		this.invchead_recurring_type = invchead_recurring_type;
	}
	public Date getInvchead_recurring_until() {
		return invchead_recurring_until;
	}
	public void setInvchead_recurring_until(Date invchead_recurring_until) {
		this.invchead_recurring_until = invchead_recurring_until;
	}
	public int getInvchead_recurring_invchead_id() {
		return invchead_recurring_invchead_id;
	}
	public void setInvchead_recurring_invchead_id(int invchead_recurring_invchead_id) {
		this.invchead_recurring_invchead_id = invchead_recurring_invchead_id;
	}
	public int getInvchead_shipchrg_id() {
		return invchead_shipchrg_id;
	}
	public void setInvchead_shipchrg_id(int invchead_shipchrg_id) {
		this.invchead_shipchrg_id = invchead_shipchrg_id;
	}
	public int getInvchead_taxzone_id() {
		return invchead_taxzone_id;
	}
	public void setInvchead_taxzone_id(int invchead_taxzone_id) {
		this.invchead_taxzone_id = invchead_taxzone_id;
	}
	public boolean isInvchead_void() {
		return invchead_void;
	}
	public void setInvchead_void(boolean invchead_void) {
		this.invchead_void = invchead_void;
	}
	public int getInvchead_saletype_id() {
		return invchead_saletype_id;
	}
	public void setInvchead_saletype_id(int invchead_saletype_id) {
		this.invchead_saletype_id = invchead_saletype_id;
	}
	public int getInvchead_shipzone_id() {
		return invchead_shipzone_id;
	}
	public void setInvchead_shipzone_id(int invchead_shipzone_id) {
		this.invchead_shipzone_id = invchead_shipzone_id;
	}
	public Timestamp getInvchead_created() {
		return invchead_created;
	}
	public void setInvchead_created(Timestamp invchead_created) {
		this.invchead_created = invchead_created;
	}
	public Timestamp getInvchead_lastupdated() {
		return invchead_lastupdated;
	}
	public void setInvchead_lastupdated(Timestamp invchead_lastupdated) {
		this.invchead_lastupdated = invchead_lastupdated;
	}

	public double getInvchead_total() {
		return invchead_total;
	}

	public void setInvchead_total(double invchead_total) {
		this.invchead_total = invchead_total;
	}

	public double getInvchead_paid() {
		return invchead_paid;
	}

	public void setInvchead_paid(double invchead_paid) {
		this.invchead_paid = invchead_paid;
	}

	public Date getInvchead_duedate() {
		return invchead_duedate;
	}

	public void setInvchead_duedate(Date invchead_duedate) {
		this.invchead_duedate = invchead_duedate;
	}
}
