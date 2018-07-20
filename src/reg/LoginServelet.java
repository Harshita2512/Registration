package reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServelet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JdbcConnection jdbc = new JdbcConnection();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		SignUp user = jdbc.getUserInfo(email, password);

		
		
		
		if (user != null) {
			req.setAttribute("userInfo", user);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
				
		}
		else {
			req.setAttribute("error", "Email Id or passwprd does not match");
			req.getRequestDispatcher("loginPage.jsp").forward(req, resp);
			
		}
	}
	

}
