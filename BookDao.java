package elibrary;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class BookDao {
	public static List<BookInfo> getAllBooks(){
		List<BookInfo> list = new ArrayList<BookInfo>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps = conn.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				BookInfo b = new BookInfo();
				b.setBid(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setQuantity(rs.getInt(3));
				b.setIssued(rs.getInt(4));
				list.add(b);
			}
			conn.close();
		}catch(Exception ob2){
			ob2.printStackTrace();
		}
		return list;
	}
	public static int delete(int bid){
		int status = 0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps = conn.prepareStatement("delete from book where bid=?");
			ps.setInt(1, bid);
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception ob4){
			ob4.printStackTrace();
		}
		return status;
	}
	public static int save(BookInfo b){
		int status = 0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps = conn.prepareStatement("insert into book values(?,?,?,?)");
			ps.setInt(1, b.getBid());
			ps.setString(2, b.getBname());
			ps.setInt(3, b.getQuantity());
			ps.setInt(4, 0);
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception ob5){
			ob5.printStackTrace();
		}
		return status;
	}
	public static int getIssued(int bid){
		int issued = 0;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=conn.prepareStatement("select * from book where bid=?");
			ps.setInt(1, bid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				issued=rs.getInt("issued");
			}
			conn.close();
		}catch(Exception e){e.printStackTrace();}
		return issued;
	}
	public static boolean checkIssue(int bid){
		boolean status=false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=conn.prepareStatement("select * from book where bid=? and quantity>issued");
			ps.setInt(1, bid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			conn.close();
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
	//Update books these methods static
	public static int issueBook(IssueBookInfo bean){
		int bid=bean.getBid();
		boolean checkstatus=checkIssue(bid);
		System.out.println("Check status: "+checkstatus);
		if(checkstatus){
			int status=0;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement ps=conn.prepareStatement("insert into issuebook values(?,?,?,?,?,?)");
				ps.setInt(1,bean.getBid());
				ps.setInt(2, bean.getId());
				ps.setString(3,bean.getName());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(4, currentDate);
				ps.setString(5,"no");
				ps.setString(6, bean.getBname());
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=conn.prepareStatement("update book set issued=? where bid=?");
					ps2.setInt(1, getIssued(bid)+1);
					ps2.setInt(2, bid);
					status=ps2.executeUpdate();
				}
				conn.close();
			}catch(Exception e){e.printStackTrace();}
			return status;
		}else{
			return 0;
		}
	}
	public static int returnBook(int bid, int id){
		int status=0;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				PreparedStatement ps=conn.prepareStatement("update issuebook set returnstatus='yes' where bid=? and id=?");
				ps.setInt(1, bid);
				ps.setInt(2, id);
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=conn.prepareStatement("update book set issued=? where bid=?");
					ps2.setInt(1,getIssued(bid)-1);
					ps2.setInt(2, bid);
					status=ps2.executeUpdate();
				}
				conn.close();
			}catch(Exception e){e.printStackTrace();}
			return status;
	}
	public static List<IssueBookInfo> viewIssuedBooks(){
		List<IssueBookInfo> list=new ArrayList<IssueBookInfo>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=conn.prepareStatement("select * from issuebook order by issueddate desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				IssueBookInfo bean=new IssueBookInfo();
				bean.setBid(rs.getInt("bid"));
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setIssueddate(rs.getDate("issueddate"));
				bean.setReturnstatus(rs.getString("returnstatus"));
				bean.setBname(rs.getString("bname"));
				list.add(bean);
			}
			conn.close();
		}catch(Exception e){e.printStackTrace();}
		return list;
	}
}
