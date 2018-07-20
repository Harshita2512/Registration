package reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = req.getParameter("email");
		JdbcConnection jdbc = new JdbcConnection();
		
			boolean userexist = jdbc.checkUserByEMail(email);
		if (userexist == false) {
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String gender = req.getParameter("gender");
			String birthday = req.getParameter("birthday");
			String password = req.getParameter("password");
			String comment1 = req.getParameter("comment1");
			String comment2 = req.getParameter("comment2");
			
			SignUp s = new SignUp ();
			s.setFirstName(firstName);
			s.setLastName(lastName);	
			s.setEmail(email);
			s.setGender(gender);
			s.setBirthday(birthday);
			s.setPassword(password);
			s.setComment1(comment1);
			s.setComment2(comment2);
			
			try {
				jdbc.RegisterUser(s);
				req.setAttribute("message", "Registration Successful!!! Please login.");
				req.getRequestDispatcher("loginPage.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("error", "There is some internal error. Please connect admistrator or re try the registration");
				req.getRequestDispatcher("signupPage.jsp").forward(req, resp);
				
			}
			
		}
		else {
			req.setAttribute("error", "User already exist, please use different email.");
			req.getRequestDispatcher("signupPage.jsp").forward(req, resp);
		}
		
		
		
		

	}
	

}
