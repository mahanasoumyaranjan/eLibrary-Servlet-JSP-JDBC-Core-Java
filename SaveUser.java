package elibrary;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveUser")
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserInfo u = new UserInfo();
		u.setId(id);
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		int status = UserDao.save(u);
		if(status>0){
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Unable to signup, please try again");
		}
		out.close();
	}
}
