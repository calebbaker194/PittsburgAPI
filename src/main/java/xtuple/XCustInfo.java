package xtuple;

import java.sql.Timestamp;

import helpers.ResultList;
import helpers.SQL;

public class XCustInfo {
	
	private int id;
	private boolean active;
	private int custtype_id;
	private int salesrep_id;
	private double commprcnt;
	private String name;
	private int creditlmt;
	private String creditrating;
	private boolean financecharge;
	private boolean backorder;
	private boolean partialship;
	private int terms_id;
	private double discntprcnt;
	private char balmethod;
	private boolean ffshipto;
	private int shipform_id;
	private String shipvia;
	private boolean blanketpos;
	private int shipchrg_id;
	private char creditstatus;
	private String comments;
	private boolean ffbillto;
	private boolean usespos;
	private String number;
	private Timestamp dateadded;
	private boolean exported;
	private boolean emaildelivery;
	private String ediemail;
	private String edisubject;
	private String edifilename;
	private String ediemailbody;
	private boolean autoupdatestatus;
	private boolean autoholdorders;
	private String edicc;
	private int ediprofile_id;
	private int preferred_warehous_id;
	private int curr_id;
	private int creditlmt_curr_id;
	private int cntct_id;
	private int corrcntct_id;
	private boolean soemaildelivery;
	private String soediemail;
	private String soedisubject;
	private String soedifilename;
	private String soediemailbody;
	private String soedicc;
	private int soediprofile_id;
	private int gracedays;
	private boolean ediemailhtml;
	private boolean soediemailhtml;
	private int taxzone_id;
	private String statementcycle;
	private Timestamp created;
	private Timestamp lastupdated;
	
	public XCustInfo() {}
	
	public XCustInfo(int cust_id)
	{
		ResultList r = SQL.executeQuery("SELECT * FROM custinfo WHERE cust_id = "+cust_id);
		
		setId(r.getInt("cust_id"));
		setActive(r.getBoolean("cust_active"));
		setCusttype_id(r.getInt("cust_custtype_id"));
		setSalesrep_id(r.getInt("cust_salesrep_id"));
		setCommprcnt(r.getDouble("cust_commprcnt"));
		setName(r.getString("cust_name"));
		setCreditlmt(r.getInt("cust_creditlmt"));
		setCreditrating(r.getString("cust_creditrating"));
		setFinancecharge(r.getBoolean("cust_financecharge"));
		setBackorder(r.getBoolean("cust_backorder"));
		setPartialship(r.getBoolean("cust_partialship"));
		setTerms_id(r.getInt("cust_terms_id"));
		setDiscntprcnt(r.getDouble("cust_discntprcnt"));
		setBalmethod(r.getChar("cust_balmethod"));
		setFfshipto(r.getBoolean("cust_ffshipto"));
		setShipform_id(r.getInt("cust_shipform_id"));
		setShipvia(r.getString("cust_shipvia"));
		setBlanketpos(r.getBoolean("cust_blanketpos"));
		setShipchrg_id(r.getInt("cust_shipchrg_id"));
		setCreditstatus(r.getChar("cust_creditstatus"));
		setComments(r.getString("cust_comments"));
		setFfbillto(r.getBoolean("cust_ffbillto"));
		setUsespos(r.getBoolean("cust_usespos"));
		setNumber(r.getString("cust_number"));
		setDateadded(r.getTimeStamp("cust_dateadded"));
		setExported(r.getBoolean("cust_exported"));
		setEmaildelivery(r.getBoolean("cust_emaildelivery"));
		setEdiemail(r.getString("cust_ediemail"));
		setEdisubject(r.getString("cust_edisubject"));
		setEdifilename(r.getString("cust_edifilename"));
		setEdiemailbody(r.getString("cust_ediemailbody"));
		setAutoupdatestatus(r.getBoolean("cust_autoupdatestatus"));
		setAutoholdorders(r.getBoolean("cust_autoholdorders"));
		setEdicc(r.getString("cust_edicc"));
		setEdiprofile_id(r.getInt("cust_ediprofile_id"));
		setPreferred_warehous_id(r.getInt("cust_preferred_warehous_id"));
		setCurr_id(r.getInt("cust_curr_id"));
		setCreditlmt_curr_id(r.getInt("cust_creditlmt_curr_id"));
		setCntct_id(r.getInt("cust_cntct_id"));
		setCorrcntct_id(r.getInt("cust_corrcntct_id"));
		setSoemaildelivery(r.getBoolean("cust_soemaildelivery"));
		setSoediemail(r.getString("cust_soediemail"));
		setSoedisubject(r.getString("cust_soedisubject"));
		setSoedifilename(r.getString("cust_soedifilename"));
		setSoediemailbody(r.getString("cust_soediemailbody"));
		setSoedicc(r.getString("cust_soedicc"));
		setSoediprofile_id(r.getInt("cust_soediprofile_id"));
		setGracedays(r.getInt("cust_gracedays"));
		setEdiemailhtml(r.getBoolean("cust_ediemailhtml"));
		setSoediemailhtml(r.getBoolean("cust_soediemailhtml"));
		setTaxzone_id(r.getInt("cust_taxzone_id"));
		setStatementcycle(r.getString("cust_statementcycle"));
		setCreated(r.getTimeStamp("cust_created"));
		setLastupdated(r.getTimeStamp("cust_lastupdated"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCusttype_id() {
		return custtype_id;
	}

	public void setCusttype_id(int custtype_id) {
		this.custtype_id = custtype_id;
	}

	public int getSalesrep_id() {
		return salesrep_id;
	}

	public void setSalesrep_id(int salesrep_id) {
		this.salesrep_id = salesrep_id;
	}

	public double getCommprcnt() {
		return commprcnt;
	}

	public void setCommprcnt(double commprcnt) {
		this.commprcnt = commprcnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreditlmt() {
		return creditlmt;
	}

	public void setCreditlmt(int creditlmt) {
		this.creditlmt = creditlmt;
	}

	public String getCreditrating() {
		return creditrating;
	}

	public void setCreditrating(String creditrating) {
		this.creditrating = creditrating;
	}

	public boolean isFinancecharge() {
		return financecharge;
	}

	public void setFinancecharge(boolean financecharge) {
		this.financecharge = financecharge;
	}

	public boolean isBackorder() {
		return backorder;
	}

	public void setBackorder(boolean backorder) {
		this.backorder = backorder;
	}

	public boolean isPartialship() {
		return partialship;
	}

	public void setPartialship(boolean partialship) {
		this.partialship = partialship;
	}

	public int getTerms_id() {
		return terms_id;
	}

	public void setTerms_id(int terms_id) {
		this.terms_id = terms_id;
	}

	public double getDiscntprcnt() {
		return discntprcnt;
	}

	public void setDiscntprcnt(double discntprcnt) {
		this.discntprcnt = discntprcnt;
	}

	public char getBalmethod() {
		return balmethod;
	}

	public void setBalmethod(char balmethod) {
		this.balmethod = balmethod;
	}

	public boolean isFfshipto() {
		return ffshipto;
	}

	public void setFfshipto(boolean ffshipto) {
		this.ffshipto = ffshipto;
	}

	public int getShipform_id() {
		return shipform_id;
	}

	public void setShipform_id(int shipform_id) {
		this.shipform_id = shipform_id;
	}

	public String getShipvia() {
		return shipvia;
	}

	public void setShipvia(String shipvia) {
		this.shipvia = shipvia;
	}

	public boolean isBlanketpos() {
		return blanketpos;
	}

	public void setBlanketpos(boolean blanketpos) {
		this.blanketpos = blanketpos;
	}

	public int getShipchrg_id() {
		return shipchrg_id;
	}

	public void setShipchrg_id(int shipchrg_id) {
		this.shipchrg_id = shipchrg_id;
	}

	public char getCreditstatus() {
		return creditstatus;
	}

	public void setCreditstatus(char creditstatus) {
		this.creditstatus = creditstatus;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public boolean isFfbillto() {
		return ffbillto;
	}

	public void setFfbillto(boolean ffbillto) {
		this.ffbillto = ffbillto;
	}

	public boolean isUsespos() {
		return usespos;
	}

	public void setUsespos(boolean usespos) {
		this.usespos = usespos;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Timestamp getDateadded() {
		return dateadded;
	}

	public void setDateadded(Timestamp dateadded) {
		this.dateadded = dateadded;
	}

	public boolean isExported() {
		return exported;
	}

	public void setExported(boolean exported) {
		this.exported = exported;
	}

	public boolean isEmaildelivery() {
		return emaildelivery;
	}

	public void setEmaildelivery(boolean emaildelivery) {
		this.emaildelivery = emaildelivery;
	}

	public String getEdiemail() {
		return ediemail;
	}

	public void setEdiemail(String ediemail) {
		this.ediemail = ediemail;
	}

	public String getEdisubject() {
		return edisubject;
	}

	public void setEdisubject(String edisubject) {
		this.edisubject = edisubject;
	}

	public String getEdifilename() {
		return edifilename;
	}

	public void setEdifilename(String edifilename) {
		this.edifilename = edifilename;
	}

	public String getEdiemailbody() {
		return ediemailbody;
	}

	public void setEdiemailbody(String ediemailbody) {
		this.ediemailbody = ediemailbody;
	}

	public boolean isAutoupdatestatus() {
		return autoupdatestatus;
	}

	public void setAutoupdatestatus(boolean autoupdatestatus) {
		this.autoupdatestatus = autoupdatestatus;
	}

	public boolean isAutoholdorders() {
		return autoholdorders;
	}

	public void setAutoholdorders(boolean autoholdorders) {
		this.autoholdorders = autoholdorders;
	}

	public String getEdicc() {
		return edicc;
	}

	public void setEdicc(String edicc) {
		this.edicc = edicc;
	}

	public int getEdiprofile_id() {
		return ediprofile_id;
	}

	public void setEdiprofile_id(int ediprofile_id) {
		this.ediprofile_id = ediprofile_id;
	}

	public int getPreferred_warehous_id() {
		return preferred_warehous_id;
	}

	public void setPreferred_warehous_id(int preferred_warehous_id) {
		this.preferred_warehous_id = preferred_warehous_id;
	}

	public int getCurr_id() {
		return curr_id;
	}

	public void setCurr_id(int curr_id) {
		this.curr_id = curr_id;
	}

	public int getCreditlmt_curr_id() {
		return creditlmt_curr_id;
	}

	public void setCreditlmt_curr_id(int creditlmt_curr_id) {
		this.creditlmt_curr_id = creditlmt_curr_id;
	}

	public int getCntct_id() {
		return cntct_id;
	}

	public void setCntct_id(int cntct_id) {
		this.cntct_id = cntct_id;
	}

	public int getCorrcntct_id() {
		return corrcntct_id;
	}

	public void setCorrcntct_id(int corrcntct_id) {
		this.corrcntct_id = corrcntct_id;
	}

	public boolean isSoemaildelivery() {
		return soemaildelivery;
	}

	public void setSoemaildelivery(boolean soemaildelivery) {
		this.soemaildelivery = soemaildelivery;
	}

	public String getSoediemail() {
		return soediemail;
	}

	public void setSoediemail(String soediemail) {
		this.soediemail = soediemail;
	}

	public String getSoedisubject() {
		return soedisubject;
	}

	public void setSoedisubject(String soedisubject) {
		this.soedisubject = soedisubject;
	}

	public String getSoedifilename() {
		return soedifilename;
	}

	public void setSoedifilename(String soedifilename) {
		this.soedifilename = soedifilename;
	}

	public String getSoediemailbody() {
		return soediemailbody;
	}

	public void setSoediemailbody(String soediemailbody) {
		this.soediemailbody = soediemailbody;
	}

	public String getSoedicc() {
		return soedicc;
	}

	public void setSoedicc(String soedicc) {
		this.soedicc = soedicc;
	}

	public int getSoediprofile_id() {
		return soediprofile_id;
	}

	public void setSoediprofile_id(int soediprofile_id) {
		this.soediprofile_id = soediprofile_id;
	}

	public int getGracedays() {
		return gracedays;
	}

	public void setGracedays(int gracedays) {
		this.gracedays = gracedays;
	}

	public boolean isEdiemailhtml() {
		return ediemailhtml;
	}

	public void setEdiemailhtml(boolean ediemailhtml) {
		this.ediemailhtml = ediemailhtml;
	}

	public boolean isSoediemailhtml() {
		return soediemailhtml;
	}

	public void setSoediemailhtml(boolean soediemailhtml) {
		this.soediemailhtml = soediemailhtml;
	}

	public int getTaxzone_id() {
		return taxzone_id;
	}

	public void setTaxzone_id(int taxzone_id) {
		this.taxzone_id = taxzone_id;
	}

	public String getStatementcycle() {
		return statementcycle;
	}

	public void setStatementcycle(String statementcycle) {
		this.statementcycle = statementcycle;
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
