package elibrary;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("name");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		BookInfo b = new BookInfo();
		b.setBid(bid);
		b.setBname(bname);
		b.setQuantity(quantity);
		int status = BookDao.save(b);
		if(status>0){
			out.println("Book added successfully");
			out.println("<br><a href='ViewBook'>View Books</a>");
			request.getRequestDispatcher("ViewBook").include(request, response);
		}else{
			out.println("Unable to add book");
		}
	}
}
