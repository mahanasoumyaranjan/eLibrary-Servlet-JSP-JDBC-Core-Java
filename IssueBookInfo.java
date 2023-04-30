package elibrary;
import java.util.*;
import java.sql.Date;
public class IssueBookInfo {
	private int bid, id;
	private String name, returnstatus, bname;
	private Date issueddate;
	public IssueBookInfo(){
		
	}
	public IssueBookInfo(int bid,int id, String name, String bname){
		super();
		this.bid = bid;
		this.id = id;
		this.name = name;
		this.bname = bname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	public Date getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}
	public String getBname(){
		return bname;
	}
	public void setBname(String bname){
		this.bname = bname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
