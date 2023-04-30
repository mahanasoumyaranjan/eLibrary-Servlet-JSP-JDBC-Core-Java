package elibrary;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session=request.getSession();
		if(AdminDao.validate(email, password)){
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			session.setAttribute("email",email);
			request.getRequestDispatcher("Admin2?").include(request, response);
		}else{
			out.println("<p style='color:red;font-size:20px;'>Error!!! Invalid credentials</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}
}
