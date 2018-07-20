package reg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





public class JdbcConnection {

	Connection con;
	public Statement getDatabaseConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/reg","root","password");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();
			return stmt;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;  
	}

	public void RegisterUser (SignUp su) throws Exception {

		try{  
			Statement stmt = getDatabaseConnection();
			String query = "insert into Signup (firstName, lastName, email, gender, birthday, password, comment1, comment2) values ('" + su.getFirstName() +"','"+su.getLastName() +"', '"+su.getEmail() +"', '"+su.getGender() +"', '"+su.getBirthday() +"','"+su.getPassword() + "','"+su.getComment1() + "','"+su.getComment2() + "')";

			int rs=stmt.executeUpdate(query); 
			con.close();

		}catch(Exception e) {
			throw e;
		}
	}

	public boolean checkUserByEMail (String email)  {

		try{  
			Statement stmt = getDatabaseConnection();
			ResultSet rs = stmt.executeQuery("select * from signup where email = '"+email+"'");
			if (rs.next()) {

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public SignUp getUserInfo (String email, String password)  {

		try{  
			Statement stmt = getDatabaseConnection();
			ResultSet rs = stmt.executeQuery("select * from signup where email = '"+email+"'"+ "and password = '"+password+"'");
			if (rs.next()) {
				
				SignUp info = new SignUp();
				info.setFirstName(rs.getString(1));
				info.setLastName(rs.getString(2));
				info.setEmail(rs.getString(3));
				info.setGender(rs.getString(4));
				info.setBirthday(rs.getString(5));
				info.setPassword(rs.getString(6));
				info.setComment1(rs.getString(7));
				info.setComment2(rs.getString(8));
				
				return info;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public SignUp getUserInfo (String email)  {

		try{  
			Statement stmt = getDatabaseConnection();
			ResultSet rs = stmt.executeQuery("select * from signup where email = '"+email+"'");
			if (rs.next()) {
				
				SignUp info = new SignUp();
				info.setFirstName(rs.getString(1));
				info.setLastName(rs.getString(2));
				info.setEmail(rs.getString(3));
				info.setGender(rs.getString(4));
				info.setBirthday(rs.getString(5));
				info.setPassword(rs.getString(6));
				info.setComment1(rs.getString(7));
				info.setComment2(rs.getString(8));
				
				return info;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	

}
