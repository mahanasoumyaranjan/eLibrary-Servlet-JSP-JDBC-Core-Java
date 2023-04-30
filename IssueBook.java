package elibrary;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int bid = Integer.parseInt(request.getParameter("bid"));
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String bname = request.getParameter("bname");
		IssueBookInfo b = new IssueBookInfo(bid ,id,name, bname);
		int status = BookDao.issueBook(b);
		if(status>0){
			out.println("Book Issued successfully");
		}else{
			out.println("Unable to issued book");
		}
		request.getRequestDispatcher("ViewBook.jsp").include(request, response);
		out.close();
	}
}
