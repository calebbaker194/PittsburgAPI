package objects;

import java.sql.Date;

public class CustInvoice {

	public int getAropen_id() {
		return aropen_id;
	}
	public void setAropen_id(int aropen_id) {
		this.aropen_id = aropen_id;
	}
	public String getDocnumber() {
		return docnumber;
	}
	public void setDocnumber(String docnumber) {
		this.docnumber = docnumber;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public Date getDocdate() {
		return docdate;
	}
	public void setDocdate(Date docdate) {
		this.docdate = docdate;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getPaid() {
		return paid;
	}
	public void setPaid(Double paid) {
		this.paid = paid;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	private int aropen_id;
	private String docnumber;
	private boolean open;
	private Date docdate;
	private Date duedate;
	private Double amount;
	private Double paid;
	private Double balance;
}
