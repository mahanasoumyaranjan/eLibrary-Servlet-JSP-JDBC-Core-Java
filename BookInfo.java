package elibrary;
public class BookInfo {
	private int bid, quantity, issued;
	private String bname;
	public BookInfo(){
		super();
	}
	public BookInfo(int bid, String baname, int quantity){
		super();
		this.bid = bid;
		this.bname = bname;
		this.quantity = quantity;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIssued() {
		return issued;
	}
	public void setIssued(int issued) {
		this.issued = issued;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
}
