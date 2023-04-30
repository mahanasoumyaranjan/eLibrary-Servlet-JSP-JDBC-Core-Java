package elibrary;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Return Book</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container'>");
		int bid = Integer.parseInt(request.getParameter("bid"));
		int id = Integer.parseInt(request.getParameter("id"));
		int i=BookDao.returnBook(bid, id);
		if(i>0){
			out.println("<h3>Book returned successfully</h3>");
		}else{
			out.println("<h3>Sorry, unable to return book.</h3>");
		}
		out.println("</div>");
		out.close();
	}
}
