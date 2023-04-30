package elibrary;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Issued Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		List<IssueBookInfo> list=BookDao.viewIssuedBooks();
		out.println("<table class='table table-bordered table-striped' border='1' width='100%'>");
		out.println("<tr><th>Book ID</th><th>User Name</th><th>Book Name</th><th>Issued Date</th><th>Return Status</th></tr>");
		for(IssueBookInfo bean:list){
			out.println("<tr><td>"+bean.getBid()+"</td><td>"+bean.getName()+"</td><td>"+bean.getBname()+"</td><td>"+bean.getIssueddate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.close();
	}
}
