package xtuple;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import helpers.DataTableRequest;
import helpers.ResultList;
import helpers.SQL;

public class XSalesOrder {
	
	private int id;
	private String number;
	private int cust_id;
	private String custponumber;
	private Date orderdate;
	private int warehous_id;
	private int shipto_id;
	private String shiptoname;
	private String shiptoaddress1;
	private String shiptoaddress2;
	private String shiptoaddress3;
	private String shiptoaddress4;
	private String shiptoaddress5;
	private int salesrep_id;
	private int terms_id;
	private String fob;
	private String shipvia;
	private String shiptocity;
	private String shiptostate;
	private String shiptozipcode;
	private double freight;
	private double misc;
	private boolean imported;
	private String ordercomments;
	private String shipcomments;
	private String shiptophone;
	private int shipchrg_id;
	private int shipform_id;
	private String billtoname;
	private String billtoaddress1;
	private String billtoaddress2;
	private String billtoaddress3;
	private String billtocity;
	private String billtostate;
	private String billtozipcode;
	private int misc_accnt_id;
	private String misc_descrip;
	private double commission;
	private Date miscdate;
	private char holdtype;
	private Date packdate;
	private int prj_id;
	private boolean wasquote;
	private Timestamp lastupdated;
	private boolean shipcomplete;
	private Timestamp created;
	private String creator;
	private String quote_number;
	private String billtocountry;
	private String shiptocountry;
	private int curr_id;
	private boolean calcfreight;
	private int shipto_cntct_id;
	private String shipto_cntct_honorific;
	private String shipto_cntct_first_name;
	private String shipto_cntct_middle;
	private String shipto_cntct_last_name;
	private String shipto_cntct_suffix;
	private String shipto_cntct_phone;
	private String shipto_cntct_title;
	private String shipto_cntct_fax;
	private String shipto_cntct_email;
	private int billto_cntct_id;
	private String billto_cntct_honorific;
	private String billto_cntct_first_name;
	private String billto_cntct_middle;
	private String billto_cntct_last_name;
	private String billto_cntct_suffix;
	private String billto_cntct_phone;
	private String billto_cntct_title;
	private String billto_cntct_fax;
	private String billto_cntct_email;
	private int taxzone_id;
	private int taxtype_id;
	private int ophead_id;
	private char status;
	private int saletype_id;
	private int shipzone_id;
	private int recurring_cohead_id;
	private ArrayList<XSalesOrderItem> lineitems = new ArrayList<XSalesOrderItem>();
	
	public XSalesOrder()
	{
		
	}
	
	public XSalesOrder(int cohead_id)
	{
		ResultList r = SQL.executeQuery("SELECT * FROM cohead WHERE cohead_id = "+cohead_id);
		
		setId(r.getInt("cohead_id"));
		setNumber(r.getString("cohead_number"));
		setCust_id(r.getInt("cohead_cust_id"));
		setCustponumber(r.getString("cohead_custponumber"));
		setOrderdate(r.getDate("cohead_orderdate"));
		setWarehous_id(r.getInt("cohead_warehous_id"));
		setShipto_id(r.getInt("cohead_shipto_id"));
		setShiptoname(r.getString("cohead_shiptoname"));
		setShiptoaddress1(r.getString("cohead_shiptoaddress1"));
		setShiptoaddress2(r.getString("cohead_shiptoaddress2"));
		setShiptoaddress3(r.getString("cohead_shiptoaddress3"));
		setShiptoaddress4(r.getString("cohead_shiptoaddress4"));
		setShiptoaddress5(r.getString("cohead_shiptoaddress5"));
		setSalesrep_id(r.getInt("cohead_salesrep_id"));
		setTerms_id(r.getInt("cohead_terms_id"));
		setFob(r.getString("cohead_fob"));
		setShipvia(r.getString("cohead_shipvia"));
		setShiptocity(r.getString("cohead_shiptocity"));
		setShiptostate(r.getString("cohead_shiptostate"));
		setShiptozipcode(r.getString("cohead_shiptozipcode"));
		setFreight(r.getDouble("cohead_freight"));
		setMisc(r.getDouble("cohead_misc"));
		setImported(r.getBoolean("cohead_imported"));
		setOrdercomments(r.getString("cohead_ordercomments"));
		setShipcomments(r.getString("cohead_shipcomments"));
		setShiptophone(r.getString("cohead_shiptophone"));
		setShipchrg_id(r.getInt("cohead_shipchrg_id"));
		setShipform_id(r.getInt("cohead_shipform_id"));
		setBilltoname(r.getString("cohead_billtoname"));
		setBilltoaddress1(r.getString("cohead_billtoaddress1"));
		setBilltoaddress2(r.getString("cohead_billtoaddress2"));
		setBilltoaddress3(r.getString("cohead_billtoaddress3"));
		setBilltocity(r.getString("cohead_billtocity"));
		setBilltostate(r.getString("cohead_billtostate"));
		setBilltozipcode(r.getString("cohead_billtozipcode"));
		setMisc_accnt_id(r.getInt("cohead_misc_accnt_id"));
		setMisc_descrip(r.getString("cohead_misc_descrip"));
		setCommission(r.getDouble("cohead_commission"));
		setMiscdate(r.getDate("cohead_miscdate"));
		setHoldtype(r.getChar("cohead_holdtype"));
		setPackdate(r.getDate("cohead_packdate"));
		setPrj_id(r.getInt("cohead_prj_id"));
		setWasquote(r.getBoolean("cohead_wasquote"));
		setLastupdated(r.getTimeStamp("cohead_lastupdated"));
		setShipcomplete(r.getBoolean("cohead_shipcomplete"));
		setCreated(r.getTimeStamp("cohead_created"));
		setCreator(r.getString("cohead_creator"));
		setQuote_number(r.getString("cohead_quote_number"));
		setBilltocountry(r.getString("cohead_billtocountry"));
		setShiptocountry(r.getString("cohead_shiptocountry"));
		setCurr_id(r.getInt("cohead_curr_id"));
		setCalcfreight(r.getBoolean("cohead_calcfreight"));
		setShipto_cntct_id(r.getInt("cohead_shipto_cntct_id"));
		setShipto_cntct_honorific(r.getString("cohead_shipto_cntct_honorific"));
		setShipto_cntct_first_name(r.getString("cohead_shipto_cntct_first_name"));
		setShipto_cntct_middle(r.getString("cohead_shipto_cntct_middle"));
		setShipto_cntct_last_name(r.getString("cohead_shipto_cntct_last_name"));
		setShipto_cntct_suffix(r.getString("cohead_shipto_cntct_suffix"));
		setShipto_cntct_phone(r.getString("cohead_shipto_cntct_phone"));
		setShipto_cntct_title(r.getString("cohead_shipto_cntct_title"));
		setShipto_cntct_fax(r.getString("cohead_shipto_cntct_fax"));
		setShipto_cntct_email(r.getString("cohead_shipto_cntct_email"));
		setBillto_cntct_id(r.getInt("cohead_billto_cntct_id"));
		setBillto_cntct_honorific(r.getString("cohead_billto_cntct_honorific"));
		setBillto_cntct_first_name(r.getString("cohead_billto_cntct_first_name"));
		setBillto_cntct_middle(r.getString("cohead_billto_cntct_middle"));
		setBillto_cntct_last_name(r.getString("cohead_billto_cntct_last_name"));
		setBillto_cntct_suffix(r.getString("cohead_billto_cntct_suffix"));
		setBillto_cntct_phone(r.getString("cohead_billto_cntct_phone"));
		setBillto_cntct_title(r.getString("cohead_billto_cntct_title"));
		setBillto_cntct_fax(r.getString("cohead_billto_cntct_fax"));
		setBillto_cntct_email(r.getString("cohead_billto_cntct_email"));
		setTaxzone_id(r.getInt("cohead_taxzone_id"));
		setTaxtype_id(r.getInt("cohead_taxtype_id"));
		setOphead_id(r.getInt("cohead_ophead_id"));
		setStatus(r.getChar("cohead_status"));
		setSaletype_id(r.getInt("cohead_saletype_id"));
		setShipzone_id(r.getInt("cohead_shipzone_id"));
		setRecurring_cohead_id(r.getInt("cohead_recurring_cohead_id"));
	}

	
	public XSalesOrder(String cohead_number)
	{
		ResultList r = SQL.executeQuery("SELECT * FROM cohead WHERE cohead_number = '"+cohead_number+"'");
		
		setId(r.getInt("cohead_id"));
		setNumber(r.getString("cohead_number"));
		setCust_id(r.getInt("cohead_cust_id"));
		setCustponumber(r.getString("cohead_custponumber"));
		setOrderdate(r.getDate("cohead_orderdate"));
		setWarehous_id(r.getInt("cohead_warehous_id"));
		setShipto_id(r.getInt("cohead_shipto_id"));
		setShiptoname(r.getString("cohead_shiptoname"));
		setShiptoaddress1(r.getString("cohead_shiptoaddress1"));
		setShiptoaddress2(r.getString("cohead_shiptoaddress2"));
		setShiptoaddress3(r.getString("cohead_shiptoaddress3"));
		setShiptoaddress4(r.getString("cohead_shiptoaddress4"));
		setShiptoaddress5(r.getString("cohead_shiptoaddress5"));
		setSalesrep_id(r.getInt("cohead_salesrep_id"));
		setTerms_id(r.getInt("cohead_terms_id"));
		setFob(r.getString("cohead_fob"));
		setShipvia(r.getString("cohead_shipvia"));
		setShiptocity(r.getString("cohead_shiptocity"));
		setShiptostate(r.getString("cohead_shiptostate"));
		setShiptozipcode(r.getString("cohead_shiptozipcode"));
		setFreight(r.getDouble("cohead_freight"));
		setMisc(r.getDouble("cohead_misc"));
		setImported(r.getBoolean("cohead_imported"));
		setOrdercomments(r.getString("cohead_ordercomments"));
		setShipcomments(r.getString("cohead_shipcomments"));
		setShiptophone(r.getString("cohead_shiptophone"));
		setShipchrg_id(r.getInt("cohead_shipchrg_id"));
		setShipform_id(r.getInt("cohead_shipform_id"));
		setBilltoname(r.getString("cohead_billtoname"));
		setBilltoaddress1(r.getString("cohead_billtoaddress1"));
		setBilltoaddress2(r.getString("cohead_billtoaddress2"));
		setBilltoaddress3(r.getString("cohead_billtoaddress3"));
		setBilltocity(r.getString("cohead_billtocity"));
		setBilltostate(r.getString("cohead_billtostate"));
		setBilltozipcode(r.getString("cohead_billtozipcode"));
		setMisc_accnt_id(r.getInt("cohead_misc_accnt_id"));
		setMisc_descrip(r.getString("cohead_misc_descrip"));
		setCommission(r.getDouble("cohead_commission"));
		setMiscdate(r.getDate("cohead_miscdate"));
		setHoldtype(r.getChar("cohead_holdtype"));
		setPackdate(r.getDate("cohead_packdate"));
		setPrj_id(r.getInt("cohead_prj_id"));
		setWasquote(r.getBoolean("cohead_wasquote"));
		setLastupdated(r.getTimeStamp("cohead_lastupdated"));
		setShipcomplete(r.getBoolean("cohead_shipcomplete"));
		setCreated(r.getTimeStamp("cohead_created"));
		setCreator(r.getString("cohead_creator"));
		setQuote_number(r.getString("cohead_quote_number"));
		setBilltocountry(r.getString("cohead_billtocountry"));
		setShiptocountry(r.getString("cohead_shiptocountry"));
		setCurr_id(r.getInt("cohead_curr_id"));
		setCalcfreight(r.getBoolean("cohead_calcfreight"));
		setShipto_cntct_id(r.getInt("cohead_shipto_cntct_id"));
		setShipto_cntct_honorific(r.getString("cohead_shipto_cntct_honorific"));
		setShipto_cntct_first_name(r.getString("cohead_shipto_cntct_first_name"));
		setShipto_cntct_middle(r.getString("cohead_shipto_cntct_middle"));
		setShipto_cntct_last_name(r.getString("cohead_shipto_cntct_last_name"));
		setShipto_cntct_suffix(r.getString("cohead_shipto_cntct_suffix"));
		setShipto_cntct_phone(r.getString("cohead_shipto_cntct_phone"));
		setShipto_cntct_title(r.getString("cohead_shipto_cntct_title"));
		setShipto_cntct_fax(r.getString("cohead_shipto_cntct_fax"));
		setShipto_cntct_email(r.getString("cohead_shipto_cntct_email"));
		setBillto_cntct_id(r.getInt("cohead_billto_cntct_id"));
		setBillto_cntct_honorific(r.getString("cohead_billto_cntct_honorific"));
		setBillto_cntct_first_name(r.getString("cohead_billto_cntct_first_name"));
		setBillto_cntct_middle(r.getString("cohead_billto_cntct_middle"));
		setBillto_cntct_last_name(r.getString("cohead_billto_cntct_last_name"));
		setBillto_cntct_suffix(r.getString("cohead_billto_cntct_suffix"));
		setBillto_cntct_phone(r.getString("cohead_billto_cntct_phone"));
		setBillto_cntct_title(r.getString("cohead_billto_cntct_title"));
		setBillto_cntct_fax(r.getString("cohead_billto_cntct_fax"));
		setBillto_cntct_email(r.getString("cohead_billto_cntct_email"));
		setTaxzone_id(r.getInt("cohead_taxzone_id"));
		setTaxtype_id(r.getInt("cohead_taxtype_id"));
		setOphead_id(r.getInt("cohead_ophead_id"));
		setStatus(r.getChar("cohead_status"));
		setSaletype_id(r.getInt("cohead_saletype_id"));
		setShipzone_id(r.getInt("cohead_shipzone_id"));
		setRecurring_cohead_id(r.getInt("cohead_recurring_cohead_id"));
	}

	public static ArrayList<XSalesOrder> getSalesOrder(DataTableRequest dr)
	{
		String sql = "SELECT * FROM cohead WHERE cohead_cust_id = "+dr.getSearch().get("cust_id");
		
		if(dr.getSearch().get("includeClosed") == null)
		{
			sql += " AND cohead_status = 'O' ";
		}
		
		sql += " AND cohead_number || cohead_custponumber || cohead_shiptoname LIKE '%"+ dr.getSearch().get("value") +"%'\n ORDER BY ";
		
		for(HashMap<String,String> order : dr.getOrder())
		{
			switch(Integer.parseInt(order.get("column")))
			{
			case 0:
				sql += "cohead_number "+ order.get("dir").toUpperCase() +", ";
				break;
			case 1:
				sql += "cohead_custponumber "+ order.get("dir").toUpperCase() +", ";
				break;
			case 4:
				sql += "cohead_orderdate "+ order.get("dir").toUpperCase() +", ";
				break;
			case 5:
				sql += "cohead_shiptoname "+ order.get("dir").toUpperCase() +", ";
				break;
			default:
				sql += "cohead_number "+ order.get("dir").toUpperCase() +", ";
				break;
			}
		}
		sql = sql.substring(0, sql.length()-2);
			
		sql+= " LIMIT "+dr.getLength() + " OFFSET " + dr.getStart();
		
		
		ResultList r = SQL.executeQuery(sql);
		ArrayList<XSalesOrder> result = new ArrayList<XSalesOrder>();
		
		if(r.first())
		{
			XSalesOrder temp;
			do
			{
				temp = new XSalesOrder();
				temp.setId(r.getInt("cohead_id"));
				temp.setNumber(r.getString("cohead_number"));
				temp.setCust_id(r.getInt("cohead_cust_id"));
				temp.setCustponumber(r.getString("cohead_custponumber"));
				temp.setOrderdate(r.getDate("cohead_orderdate"));
				temp.setWarehous_id(r.getInt("cohead_warehous_id"));
				temp.setShipto_id(r.getInt("cohead_shipto_id"));
				temp.setShiptoname(r.getString("cohead_shiptoname"));
				temp.setShiptoaddress1(r.getString("cohead_shiptoaddress1"));
				temp.setShiptoaddress2(r.getString("cohead_shiptoaddress2"));
				temp.setShiptoaddress3(r.getString("cohead_shiptoaddress3"));
				temp.setShiptoaddress4(r.getString("cohead_shiptoaddress4"));
				temp.setShiptoaddress5(r.getString("cohead_shiptoaddress5"));
				temp.setSalesrep_id(r.getInt("cohead_salesrep_id"));
				temp.setTerms_id(r.getInt("cohead_terms_id"));
				temp.setFob(r.getString("cohead_fob"));
				temp.setShipvia(r.getString("cohead_shipvia"));
				temp.setShiptocity(r.getString("cohead_shiptocity"));
				temp.setShiptostate(r.getString("cohead_shiptostate"));
				temp.setShiptozipcode(r.getString("cohead_shiptozipcode"));
				temp.setFreight(r.getDouble("cohead_freight"));
				temp.setMisc(r.getDouble("cohead_misc"));
				temp.setImported(r.getBoolean("cohead_imported"));
				temp.setOrdercomments(r.getString("cohead_ordercomments"));
				temp.setShipcomments(r.getString("cohead_shipcomments"));
				temp.setShiptophone(r.getString("cohead_shiptophone"));
				temp.setShipchrg_id(r.getInt("cohead_shipchrg_id"));
				temp.setShipform_id(r.getInt("cohead_shipform_id"));
				temp.setBilltoname(r.getString("cohead_billtoname"));
				temp.setBilltoaddress1(r.getString("cohead_billtoaddress1"));
				temp.setBilltoaddress2(r.getString("cohead_billtoaddress2"));
				temp.setBilltoaddress3(r.getString("cohead_billtoaddress3"));
				temp.setBilltocity(r.getString("cohead_billtocity"));
				temp.setBilltostate(r.getString("cohead_billtostate"));
				temp.setBilltozipcode(r.getString("cohead_billtozipcode"));
				temp.setMisc_accnt_id(r.getInt("cohead_misc_accnt_id"));
				temp.setMisc_descrip(r.getString("cohead_misc_descrip"));
				temp.setCommission(r.getDouble("cohead_commission"));
				temp.setMiscdate(r.getDate("cohead_miscdate"));
				temp.setHoldtype(r.getChar("cohead_holdtype"));
				temp.setPackdate(r.getDate("cohead_packdate"));
				temp.setPrj_id(r.getInt("cohead_prj_id"));
				temp.setWasquote(r.getBoolean("cohead_wasquote"));
				temp.setLastupdated(r.getTimeStamp("cohead_lastupdated"));
				temp.setShipcomplete(r.getBoolean("cohead_shipcomplete"));
				temp.setCreated(r.getTimeStamp("cohead_created"));
				temp.setCreator(r.getString("cohead_creator"));
				temp.setQuote_number(r.getString("cohead_quote_number"));
				temp.setBilltocountry(r.getString("cohead_billtocountry"));
				temp.setShiptocountry(r.getString("cohead_shiptocountry"));
				temp.setCurr_id(r.getInt("cohead_curr_id"));
				temp.setCalcfreight(r.getBoolean("cohead_calcfreight"));
				temp.setShipto_cntct_id(r.getInt("cohead_shipto_cntct_id"));
				temp.setShipto_cntct_honorific(r.getString("cohead_shipto_cntct_honorific"));
				temp.setShipto_cntct_first_name(r.getString("cohead_shipto_cntct_first_name"));
				temp.setShipto_cntct_middle(r.getString("cohead_shipto_cntct_middle"));
				temp.setShipto_cntct_last_name(r.getString("cohead_shipto_cntct_last_name"));
				temp.setShipto_cntct_suffix(r.getString("cohead_shipto_cntct_suffix"));
				temp.setShipto_cntct_phone(r.getString("cohead_shipto_cntct_phone"));
				temp.setShipto_cntct_title(r.getString("cohead_shipto_cntct_title"));
				temp.setShipto_cntct_fax(r.getString("cohead_shipto_cntct_fax"));
				temp.setShipto_cntct_email(r.getString("cohead_shipto_cntct_email"));
				temp.setBillto_cntct_id(r.getInt("cohead_billto_cntct_id"));
				temp.setBillto_cntct_honorific(r.getString("cohead_billto_cntct_honorific"));
				temp.setBillto_cntct_first_name(r.getString("cohead_billto_cntct_first_name"));
				temp.setBillto_cntct_middle(r.getString("cohead_billto_cntct_middle"));
				temp.setBillto_cntct_last_name(r.getString("cohead_billto_cntct_last_name"));
				temp.setBillto_cntct_suffix(r.getString("cohead_billto_cntct_suffix"));
				temp.setBillto_cntct_phone(r.getString("cohead_billto_cntct_phone"));
				temp.setBillto_cntct_title(r.getString("cohead_billto_cntct_title"));
				temp.setBillto_cntct_fax(r.getString("cohead_billto_cntct_fax"));
				temp.setBillto_cntct_email(r.getString("cohead_billto_cntct_email"));
				temp.setTaxzone_id(r.getInt("cohead_taxzone_id"));
				temp.setTaxtype_id(r.getInt("cohead_taxtype_id"));
				temp.setOphead_id(r.getInt("cohead_ophead_id"));
				temp.setStatus(r.getChar("cohead_status"));
				temp.setSaletype_id(r.getInt("cohead_saletype_id"));
				temp.setShipzone_id(r.getInt("cohead_shipzone_id"));
				temp.setRecurring_cohead_id(r.getInt("cohead_recurring_cohead_id"));
				result.add(temp);
			}
			while(r.next());
		}
		return result;	
		
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

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCustponumber() {
		return custponumber;
	}

	public void setCustponumber(String custponumber) {
		this.custponumber = custponumber;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date timestamp) {
		this.orderdate = timestamp;
	}

	public int getWarehous_id() {
		return warehous_id;
	}

	public void setWarehous_id(int warehous_id) {
		this.warehous_id = warehous_id;
	}

	public int getShipto_id() {
		return shipto_id;
	}

	public void setShipto_id(int shipto_id) {
		this.shipto_id = shipto_id;
	}

	public String getShiptoname() {
		return shiptoname;
	}

	public void setShiptoname(String shiptoname) {
		this.shiptoname = shiptoname;
	}

	public String getShiptoaddress1() {
		return shiptoaddress1;
	}

	public void setShiptoaddress1(String shiptoaddress1) {
		this.shiptoaddress1 = shiptoaddress1;
	}

	public String getShiptoaddress2() {
		return shiptoaddress2;
	}

	public void setShiptoaddress2(String shiptoaddress2) {
		this.shiptoaddress2 = shiptoaddress2;
	}

	public String getShiptoaddress3() {
		return shiptoaddress3;
	}

	public void setShiptoaddress3(String shiptoaddress3) {
		this.shiptoaddress3 = shiptoaddress3;
	}

	public String getShiptoaddress4() {
		return shiptoaddress4;
	}

	public void setShiptoaddress4(String shiptoaddress4) {
		this.shiptoaddress4 = shiptoaddress4;
	}

	public String getShiptoaddress5() {
		return shiptoaddress5;
	}

	public void setShiptoaddress5(String shiptoaddress5) {
		this.shiptoaddress5 = shiptoaddress5;
	}

	public int getSalesrep_id() {
		return salesrep_id;
	}

	public void setSalesrep_id(int salesrep_id) {
		this.salesrep_id = salesrep_id;
	}

	public int getTerms_id() {
		return terms_id;
	}

	public void setTerms_id(int terms_id) {
		this.terms_id = terms_id;
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

	public void setShipvia(String shipvia) {
		this.shipvia = shipvia;
	}

	public String getShiptocity() {
		return shiptocity;
	}

	public void setShiptocity(String shiptocity) {
		this.shiptocity = shiptocity;
	}

	public String getShiptostate() {
		return shiptostate;
	}

	public void setShiptostate(String shiptostate) {
		this.shiptostate = shiptostate;
	}

	public String getShiptozipcode() {
		return shiptozipcode;
	}

	public void setShiptozipcode(String shiptozipcode) {
		this.shiptozipcode = shiptozipcode;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public double getMisc() {
		return misc;
	}

	public void setMisc(double misc) {
		this.misc = misc;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public String getOrdercomments() {
		return ordercomments;
	}

	public void setOrdercomments(String ordercomments) {
		this.ordercomments = ordercomments;
	}

	public String getShipcomments() {
		return shipcomments;
	}

	public void setShipcomments(String shipcomments) {
		this.shipcomments = shipcomments;
	}

	public String getShiptophone() {
		return shiptophone;
	}

	public void setShiptophone(String shiptophone) {
		this.shiptophone = shiptophone;
	}

	public int getShipchrg_id() {
		return shipchrg_id;
	}

	public void setShipchrg_id(int shipchrg_id) {
		this.shipchrg_id = shipchrg_id;
	}

	public int getShipform_id() {
		return shipform_id;
	}

	public void setShipform_id(int shipform_id) {
		this.shipform_id = shipform_id;
	}

	public String getBilltoname() {
		return billtoname;
	}

	public void setBilltoname(String billtoname) {
		this.billtoname = billtoname;
	}

	public String getBilltoaddress1() {
		return billtoaddress1;
	}

	public void setBilltoaddress1(String billtoaddress1) {
		this.billtoaddress1 = billtoaddress1;
	}

	public String getBilltoaddress2() {
		return billtoaddress2;
	}

	public void setBilltoaddress2(String billtoaddress2) {
		this.billtoaddress2 = billtoaddress2;
	}

	public String getBilltoaddress3() {
		return billtoaddress3;
	}

	public void setBilltoaddress3(String billtoaddress3) {
		this.billtoaddress3 = billtoaddress3;
	}

	public String getBilltocity() {
		return billtocity;
	}

	public void setBilltocity(String billtocity) {
		this.billtocity = billtocity;
	}

	public String getBilltostate() {
		return billtostate;
	}

	public void setBilltostate(String billtostate) {
		this.billtostate = billtostate;
	}

	public String getBilltozipcode() {
		return billtozipcode;
	}

	public void setBilltozipcode(String billtozipcode) {
		this.billtozipcode = billtozipcode;
	}

	public int getMisc_accnt_id() {
		return misc_accnt_id;
	}

	public void setMisc_accnt_id(int misc_accnt_id) {
		this.misc_accnt_id = misc_accnt_id;
	}

	public String getMisc_descrip() {
		return misc_descrip;
	}

	public void setMisc_descrip(String misc_descrip) {
		this.misc_descrip = misc_descrip;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public Date getMiscdate() {
		return miscdate;
	}

	public void setMiscdate(Date miscdate) {
		this.miscdate = miscdate;
	}

	public char getHoldtype() {
		return holdtype;
	}

	public void setHoldtype(char holdtype) {
		this.holdtype = holdtype;
	}

	public Date getPackdate() {
		return packdate;
	}

	public void setPackdate(Date packdate) {
		this.packdate = packdate;
	}

	public int getPrj_id() {
		return prj_id;
	}

	public void setPrj_id(int prj_id) {
		this.prj_id = prj_id;
	}

	public boolean isWasquote() {
		return wasquote;
	}

	public void setWasquote(boolean wasquote) {
		this.wasquote = wasquote;
	}

	public Timestamp getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Timestamp lastupdated) {
		this.lastupdated = lastupdated;
	}

	public boolean isShipcomplete() {
		return shipcomplete;
	}

	public void setShipcomplete(boolean shipcomplete) {
		this.shipcomplete = shipcomplete;
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

	public String getQuote_number() {
		return quote_number;
	}

	public void setQuote_number(String quote_number) {
		this.quote_number = quote_number;
	}

	public String getBilltocountry() {
		return billtocountry;
	}

	public void setBilltocountry(String billtocountry) {
		this.billtocountry = billtocountry;
	}

	public String getShiptocountry() {
		return shiptocountry;
	}

	public void setShiptocountry(String shiptocountry) {
		this.shiptocountry = shiptocountry;
	}

	public int getCurr_id() {
		return curr_id;
	}

	public void setCurr_id(int curr_id) {
		this.curr_id = curr_id;
	}

	public boolean isCalcfreight() {
		return calcfreight;
	}

	public void setCalcfreight(boolean calcfreight) {
		this.calcfreight = calcfreight;
	}

	public int getShipto_cntct_id() {
		return shipto_cntct_id;
	}

	public void setShipto_cntct_id(int shipto_cntct_id) {
		this.shipto_cntct_id = shipto_cntct_id;
	}

	public String getShipto_cntct_honorific() {
		return shipto_cntct_honorific;
	}

	public void setShipto_cntct_honorific(String shipto_cntct_honorific) {
		this.shipto_cntct_honorific = shipto_cntct_honorific;
	}

	public String getShipto_cntct_first_name() {
		return shipto_cntct_first_name;
	}

	public void setShipto_cntct_first_name(String shipto_cntct_first_name) {
		this.shipto_cntct_first_name = shipto_cntct_first_name;
	}

	public String getShipto_cntct_middle() {
		return shipto_cntct_middle;
	}

	public void setShipto_cntct_middle(String shipto_cntct_middle) {
		this.shipto_cntct_middle = shipto_cntct_middle;
	}

	public String getShipto_cntct_last_name() {
		return shipto_cntct_last_name;
	}

	public void setShipto_cntct_last_name(String shipto_cntct_last_name) {
		this.shipto_cntct_last_name = shipto_cntct_last_name;
	}

	public String getShipto_cntct_suffix() {
		return shipto_cntct_suffix;
	}

	public void setShipto_cntct_suffix(String shipto_cntct_suffix) {
		this.shipto_cntct_suffix = shipto_cntct_suffix;
	}

	public String getShipto_cntct_phone() {
		return shipto_cntct_phone;
	}

	public void setShipto_cntct_phone(String shipto_cntct_phone) {
		this.shipto_cntct_phone = shipto_cntct_phone;
	}

	public String getShipto_cntct_title() {
		return shipto_cntct_title;
	}

	public void setShipto_cntct_title(String shipto_cntct_title) {
		this.shipto_cntct_title = shipto_cntct_title;
	}

	public String getShipto_cntct_fax() {
		return shipto_cntct_fax;
	}

	public void setShipto_cntct_fax(String shipto_cntct_fax) {
		this.shipto_cntct_fax = shipto_cntct_fax;
	}

	public String getShipto_cntct_email() {
		return shipto_cntct_email;
	}

	public void setShipto_cntct_email(String shipto_cntct_email) {
		this.shipto_cntct_email = shipto_cntct_email;
	}

	public int getBillto_cntct_id() {
		return billto_cntct_id;
	}

	public void setBillto_cntct_id(int billto_cntct_id) {
		this.billto_cntct_id = billto_cntct_id;
	}

	public String getBillto_cntct_honorific() {
		return billto_cntct_honorific;
	}

	public void setBillto_cntct_honorific(String billto_cntct_honorific) {
		this.billto_cntct_honorific = billto_cntct_honorific;
	}

	public String getBillto_cntct_first_name() {
		return billto_cntct_first_name;
	}

	public void setBillto_cntct_first_name(String billto_cntct_first_name) {
		this.billto_cntct_first_name = billto_cntct_first_name;
	}

	public String getBillto_cntct_middle() {
		return billto_cntct_middle;
	}

	public void setBillto_cntct_middle(String billto_cntct_middle) {
		this.billto_cntct_middle = billto_cntct_middle;
	}

	public String getBillto_cntct_last_name() {
		return billto_cntct_last_name;
	}

	public void setBillto_cntct_last_name(String billto_cntct_last_name) {
		this.billto_cntct_last_name = billto_cntct_last_name;
	}

	public String getBillto_cntct_suffix() {
		return billto_cntct_suffix;
	}

	public void setBillto_cntct_suffix(String billto_cntct_suffix) {
		this.billto_cntct_suffix = billto_cntct_suffix;
	}

	public String getBillto_cntct_phone() {
		return billto_cntct_phone;
	}

	public void setBillto_cntct_phone(String billto_cntct_phone) {
		this.billto_cntct_phone = billto_cntct_phone;
	}

	public String getBillto_cntct_title() {
		return billto_cntct_title;
	}

	public void setBillto_cntct_title(String billto_cntct_title) {
		this.billto_cntct_title = billto_cntct_title;
	}

	public String getBillto_cntct_fax() {
		return billto_cntct_fax;
	}

	public void setBillto_cntct_fax(String billto_cntct_fax) {
		this.billto_cntct_fax = billto_cntct_fax;
	}

	public String getBillto_cntct_email() {
		return billto_cntct_email;
	}

	public void setBillto_cntct_email(String billto_cntct_email) {
		this.billto_cntct_email = billto_cntct_email;
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

	public int getOphead_id() {
		return ophead_id;
	}

	public void setOphead_id(int ophead_id) {
		this.ophead_id = ophead_id;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public int getSaletype_id() {
		return saletype_id;
	}

	public void setSaletype_id(int saletype_id) {
		this.saletype_id = saletype_id;
	}

	public int getShipzone_id() {
		return shipzone_id;
	}

	public void setShipzone_id(int shipzone_id) {
		this.shipzone_id = shipzone_id;
	}

	public int getRecurring_cohead_id() {
		return recurring_cohead_id;
	}

	public void setRecurring_cohead_id(int recurring_cohead_id) {
		this.recurring_cohead_id = recurring_cohead_id;
	}

	public ArrayList<XSalesOrderItem> getLineitems() {
		return lineitems;
	}

	public void setLineitems(ArrayList<XSalesOrderItem> lineitems) {
		this.lineitems = lineitems;
	}
	
	
}
