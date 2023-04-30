package elibrary;
import java.util.*;
import java.sql.*;
public class AdminDao {
	public static boolean validate(String email, String password){
		boolean status = false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps = conn.prepareStatement("select * from admin where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			conn.close();
		}catch(Exception ob){
			ob.printStackTrace();
		}
		return status;
	}
	public static String printEmail(String email){
		boolean status = false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps = conn.prepareStatement("select email from admin where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return email;
	}
}
