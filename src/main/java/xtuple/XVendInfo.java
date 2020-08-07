package xtuple;

import java.sql.Timestamp;

import helpers.ResultList;
import helpers.SQL;

public class XVendInfo {
	
	private int id;
	private String name;
	private Timestamp lastpurchdate;
	private boolean active;
	private boolean po;
	private String comments;
	private String pocomments;
	private String number;
	private boolean is1099;
	private boolean exported;
	private char fobsource;
	private String fob;
	private int terms_id;
	private String shipvia;
	private int vendtype_id;
	private boolean qualified;
	private String ediemail;
	private String ediemailbody;
	private String edisubject;
	private String edifilename;
	private String accntnum;
	private boolean emailpodelivery;
	private boolean restrictpurch;
	private String edicc;
	private int curr_id;
	private int cntct1_id;
	private int cntct2_id;
	private int addr_id;
	private boolean match;
	private boolean ach_enabled;
	private String ach_accnttype;
	private boolean ach_use_vendinfo;
	private String ach_indiv_number;
	private String ach_indiv_name;
	private boolean ediemailhtml;
	private int taxzone_id;
	private int accnt_id;
	private int expcat_id;
	private int tax_id;
	private Timestamp created;
	private Timestamp lastupdated;
	private int taxtype_id;
	private int potype_id;
	
	public XVendInfo() {}
	
	public XVendInfo(int vend_id) 
	{
		ResultList r = SQL.executeQuery("SELECT * FROM vendinfo WHERE vend_id = "+vend_id);
		
		setId(r.getInt("vend_id"));
		setName(r.getString("vend_name"));
		setLastpurchdate(r.getTimeStamp("vend_lastpurchdate"));
		setActive(r.getBoolean("vend_active"));
		setPo(r.getBoolean("vend_po"));
		setComments(r.getString("vend_comments"));
		setPocomments(r.getString("vend_pocomments"));
		setNumber(r.getString("vend_number"));
		setIs1099(r.getBoolean("vend_1099"));
		setExported(r.getBoolean("vend_exported"));
		setFobsource(r.getChar("vend_fobsource"));
		setFob(r.getString("vend_fob"));
		setTerms_id(r.getInt("vend_terms_id"));
		setShipvia(r.getString("vend_shipvia"));
		setVendtype_id(r.getInt("vend_vendtype_id"));
		setQualified(r.getBoolean("vend_qualified"));
		setEdiemail(r.getString("vend_ediemail"));
		setEdiemailbody(r.getString("vend_ediemailbody"));
		setEdisubject(r.getString("vend_edisubject"));
		setEdifilename(r.getString("vend_edifilename"));
		setAccntnum(r.getString("vend_accntnum"));
		setEmailpodelivery(r.getBoolean("vend_emailpodelivery"));
		setRestrictpurch(r.getBoolean("vend_restrictpurch"));
		setEdicc(r.getString("vend_edicc"));
		setCurr_id(r.getInt("vend_curr_id"));
		setCntct1_id(r.getInt("vend_cntct1_id"));
		setCntct2_id(r.getInt("vend_cntct2_id"));
		setAddr_id(r.getInt("vend_addr_id"));
		setMatch(r.getBoolean("vend_match"));
		setAch_enabled(r.getBoolean("vend_ach_enabled"));
		setAch_accnttype(r.getString("vend_ach_accnttype"));
		setAch_use_vendinfo(r.getBoolean("vend_ach_use_vendinfo"));
		setAch_indiv_number(r.getString("vend_ach_indiv_number"));
		setAch_indiv_name(r.getString("vend_ach_indiv_name"));
		setEdiemailhtml(r.getBoolean("vend_ediemailhtml"));
		setTaxzone_id(r.getInt("vend_taxzone_id"));
		setAccnt_id(r.getInt("vend_accnt_id"));
		setExpcat_id(r.getInt("vend_expcat_id"));
		setTax_id(r.getInt("vend_tax_id"));
		setCreated(r.getTimeStamp("vend_created"));
		setLastupdated(r.getTimeStamp("vend_lastupdated"));
		setTaxtype_id(r.getInt("vend_taxtype_id"));
		setPotype_id(r.getInt("vend_potype_id"));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLastpurchdate() {
		return lastpurchdate;
	}

	public void setLastpurchdate(Timestamp lastpurchdate) {
		this.lastpurchdate = lastpurchdate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isPo() {
		return po;
	}

	public void setPo(boolean po) {
		this.po = po;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPocomments() {
		return pocomments;
	}

	public void setPocomments(String pocomments) {
		this.pocomments = pocomments;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isIs1099() {
		return is1099;
	}

	public void setIs1099(boolean is1099) {
		this.is1099 = is1099;
	}

	public boolean isExported() {
		return exported;
	}

	public void setExported(boolean exported) {
		this.exported = exported;
	}

	public char getFobsource() {
		return fobsource;
	}

	public void setFobsource(char fobsource) {
		this.fobsource = fobsource;
	}

	public String getFob() {
		return fob;
	}

	public void setFob(String fob) {
		this.fob = fob;
	}

	public int getTerms_id() {
		return terms_id;
	}

	public void setTerms_id(int terms_id) {
		this.terms_id = terms_id;
	}

	public String getShipvia() {
		return shipvia;
	}

	public void setShipvia(String shipvia) {
		this.shipvia = shipvia;
	}

	public int getVendtype_id() {
		return vendtype_id;
	}

	public void setVendtype_id(int vendtype_id) {
		this.vendtype_id = vendtype_id;
	}

	public boolean isQualified() {
		return qualified;
	}

	public void setQualified(boolean qualified) {
		this.qualified = qualified;
	}

	public String getEdiemail() {
		return ediemail;
	}

	public void setEdiemail(String ediemail) {
		this.ediemail = ediemail;
	}

	public String getEdiemailbody() {
		return ediemailbody;
	}

	public void setEdiemailbody(String ediemailbody) {
		this.ediemailbody = ediemailbody;
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

	public String getAccntnum() {
		return accntnum;
	}

	public void setAccntnum(String accntnum) {
		this.accntnum = accntnum;
	}

	public boolean isEmailpodelivery() {
		return emailpodelivery;
	}

	public void setEmailpodelivery(boolean emailpodelivery) {
		this.emailpodelivery = emailpodelivery;
	}

	public boolean isRestrictpurch() {
		return restrictpurch;
	}

	public void setRestrictpurch(boolean restrictpurch) {
		this.restrictpurch = restrictpurch;
	}

	public String getEdicc() {
		return edicc;
	}

	public void setEdicc(String edicc) {
		this.edicc = edicc;
	}

	public int getCurr_id() {
		return curr_id;
	}

	public void setCurr_id(int curr_id) {
		this.curr_id = curr_id;
	}

	public int getCntct1_id() {
		return cntct1_id;
	}

	public void setCntct1_id(int cntct1_id) {
		this.cntct1_id = cntct1_id;
	}

	public int getCntct2_id() {
		return cntct2_id;
	}

	public void setCntct2_id(int cntct2_id) {
		this.cntct2_id = cntct2_id;
	}

	public int getAddr_id() {
		return addr_id;
	}

	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}

	public boolean isMatch() {
		return match;
	}

	public void setMatch(boolean match) {
		this.match = match;
	}

	public boolean isAch_enabled() {
		return ach_enabled;
	}

	public void setAch_enabled(boolean ach_enabled) {
		this.ach_enabled = ach_enabled;
	}

	public String getAch_accnttype() {
		return ach_accnttype;
	}

	public void setAch_accnttype(String ach_accnttype) {
		this.ach_accnttype = ach_accnttype;
	}

	public boolean isAch_use_vendinfo() {
		return ach_use_vendinfo;
	}

	public void setAch_use_vendinfo(boolean ach_use_vendinfo) {
		this.ach_use_vendinfo = ach_use_vendinfo;
	}

	public String getAch_indiv_number() {
		return ach_indiv_number;
	}

	public void setAch_indiv_number(String ach_indiv_number) {
		this.ach_indiv_number = ach_indiv_number;
	}

	public String getAch_indiv_name() {
		return ach_indiv_name;
	}

	public void setAch_indiv_name(String ach_indiv_name) {
		this.ach_indiv_name = ach_indiv_name;
	}

	public boolean isEdiemailhtml() {
		return ediemailhtml;
	}

	public void setEdiemailhtml(boolean ediemailhtml) {
		this.ediemailhtml = ediemailhtml;
	}

	public int getTaxzone_id() {
		return taxzone_id;
	}

	public void setTaxzone_id(int taxzone_id) {
		this.taxzone_id = taxzone_id;
	}

	public int getAccnt_id() {
		return accnt_id;
	}

	public void setAccnt_id(int accnt_id) {
		this.accnt_id = accnt_id;
	}

	public int getExpcat_id() {
		return expcat_id;
	}

	public void setExpcat_id(int expcat_id) {
		this.expcat_id = expcat_id;
	}

	public int getTax_id() {
		return tax_id;
	}

	public void setTax_id(int tax_id) {
		this.tax_id = tax_id;
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

	public int getTaxtype_id() {
		return taxtype_id;
	}

	public void setTaxtype_id(int taxtype_id) {
		this.taxtype_id = taxtype_id;
	}

	public int getPotype_id() {
		return potype_id;
	}

	public void setPotype_id(int potype_id) {
		this.potype_id = potype_id;
	}
	
}
