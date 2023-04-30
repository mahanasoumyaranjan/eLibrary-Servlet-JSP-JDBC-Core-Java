package elibrary;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/User2")
public class User2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("index/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		out.println("<html><head>");
		out.println("<title>eLibrary User</title>");
		out.println("<link rel='icon' href='data:image/jpeg;base64,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'>");
		out.println("<style>");
		out.println("ul{list-style-type:square;}");
		out.println(".button{background-color:smokywhite; border:none; color:white; padding: 15px 32px; display:inline-block; font-size:16px; margin:4px 2px; cursor:pointer;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body style='background-color:blue;'>");
		out.println("<center><h1 style='color:black; font-size:30px;'>Welcome "+name+" to eLibrary</h1></center>");
		out.println("<br>");
		out.println("<br>");
		out.println("<ul style='text-align:center; font-size:30px;'>");
		out.println("<li><button class='button'><a href='ViewBook.jsp' style='text-decoration:none;' target='_blank'>View Books</a></button></li>");
		out.println("<li><button class='button'><a href='index.html' style='text-decoration:none;'>Go back Home</a></button></li>");
		out.println("<li><button class='button'><a href='LogoutUser' style='text-decoration:none;'>Logout</a></button></li>");
		out.println("</ul>");
		out.println("</body></html>");
	}
}
