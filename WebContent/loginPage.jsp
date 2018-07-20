<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<style>

header, footer {
    padding: em;
    color: white;
    background-color: black;
    text-align: center;
}


.container{
	padding-bottom: 3em
}

table {
	border-spacing: 20px;
	background-color: lightblue;
	padding-bottom: 1em;
	padding-top: 1em;
	border:8px solid black;
}

</style>

<script type="text/javascript">
function validation(){
 var password =  document.getElementById("password").value;
 var email =  document.getElementById("email").value;

 
 if(email == null || email.trim() == ""){
	 alert("Email can not be empty");
	 
	 return false;
 }
 
 if(password == null || password.trim() == ""){
	 alert("Password can not be empty");
	 
	 return false;
 }
 
 return true;
}
</script>
<body>
	<form action="login" method="POST" onsubmit="return validation()">
		<header>
			<h1>Login</h1>
			</header>
	<div class="container">
	<table>
		<tr>
			<td><label> Email ID: </label></td> 
			<td><input type="text" name="email" id="email" 		
			placeholder="Enter User Id"></td>
		</tr>
		
		<tr>
			<td><label> Password: </label></td>
			<td><input type="password" name="password" id="password"
				placeholder="Enter password"></td>
		</tr>
		
		<tr>
			<td><label> <input type="checkbox" checked="checked"
			name="remember" style="margin-bottom: 15px"> Remember me
		</label>
	</td></tr>
		
			<tr>
				<td><input type="submit" value="Login"></input></td>
				<td><a href="signupPage.jsp">SignUp</a> <a href ="forgetPassword.jsp">Forget Password</a></td>
				
			</tr>
			
			<c:if test="${error != null}">
			<tr>
				<td><div style="color:red">${error}</div></td>
			</tr>
          </c:if>
          
          	<c:if test="${message != null}">
			<tr>
				<td><div style="color:green">${message}</div></td>
			</tr>
          </c:if>
			
		
	</table>

	</div>


	</form>

	

		<footer>Copyright &copy; Rohi Analtical India</footer>
</body>
</html>