package reg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PasswordServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JdbcConnection jdbc = new JdbcConnection();
		String email = req.getParameter("email");
		SignUp su = jdbc.getUserInfo(email);
		
		if (su == null) {
			req.setAttribute("error", "Invalid Email!!!");
			req.getRequestDispatcher("forgetPassword.jsp").forward(req, resp);
		}
		else {
			SendEmail.sendEmail(email, su.getPassword());
			req.setAttribute("message", "Your Password has been sent to your email address");
			req.getRequestDispatcher("loginPage.jsp").forward(req, resp);
		}
		
	}

}
