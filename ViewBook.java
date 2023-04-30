package elibrary;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>Book Table</title>");
		out.println("<style>");
		out.println(".styled-table{border-collapse:collapse; margin:25px 0; font-size:0.9em; font-family:sans-serif; min-width:400px; box-shadow:0 0 20px rgba(0, 0, 0, 0.15);}");
		out.println(".styled-table thread tr{background-color:#009879; color:#ffffff; text-align:left;}");
		out.println(".styled-table th, .styled-table td{padding:12px 15px;}");
		out.println(".styled-table tbody tr{border-bottom:1px solid #dddddd} .styled-table tbody tr:nth-of-type(even){background-color:#f3f3f3;} .styled-table tbody tr:last-of-type{border-bottom:2px solid #009879}");
		out.println(".styled-table tbody tr.active-ro{font-weight:bold; color:#009879;}");
		out.println("td{text-align:center;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		List<BookInfo> list = BookDao.getAllBooks();
		out.println("<table border='1' width='100%' class='styled-table'>");
		out.println("<thead><tr><th>BID</th><th>BNAME</th><th>QUANTITY</th><th>Issued</th><th>DELETE</th></tr></thead>");
		for(BookInfo b:list){
			out.println("<tbody><tr><td>"+b.getBid()+"</td><td>"+b.getBname()+"</td><td>"+b.getQuantity()+"</td><td>"+b.getIssued()+"</td><td><a href='DeleteBook?bid="+b.getBid()+"'>Delete</a></td></tr></tbody>");
		}
		out.println("</table>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("<a href='addbook.html' style='text-align:center; font-size:20px; text-decoration:none;'>ADD BOOK</a>");
		out.println("</body></html>");
	}
}
