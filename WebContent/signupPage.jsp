<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HNbank</title>
</head>
<style>
header, footer {
	padding: em;
	color: white;
	background-color: black;
	text-align: center;
}

.container {
	padding-bottom: 3em;
}

table {
	border-spacing: 20px;
	background-color: lightblue;
	padding-bottom: 1em;
	padding-top: 1em;
	border: 8px solid black;
}
</style>
<script type="text/javascript">
	function validation() {
		var firstName = document.getElementById("firstName").value;
		var email = document.getElementById("email").value;
		var gender = document.getElementById("gender").value;
		var birthday = document.getElementById("birthday").value;
		var password = document.getElementById("password").value;
		var rePassword = document.getElementById("rePassword").value;
		var comment1 = document.getElementById("comment1").value;
		var comment2 = document.getElementById("comment2").value;

		if (firstName == null || firstName.trim() == "") {
			alert("firstName can not be empty");

			return false;
		}

		if (email == null || email.trim() == "") {
			alert("Email can not be empty");

			return false;
		}

		if (gender == null || gender.trim() == "") {
			alert("Choose Gender");

			return false;
		}

		if (birthday == null || birthday.trim() == "") {
			alert("Choose Birthday");

			return false;
		}

		if (password == null || password.trim() == "") {
			alert("Password can not be empty");

			return false;
		}

		if (rePassword == null || rePassword.trim() == "") {
			alert("Re enter your password");

			return false;
		}
		
		if(password!=rePassword){
			alert("Password doesnot match!")
			
			return false;
		}
		
		if (comment1 == null || comment1.trim() == "") {
			alert("Please provide Comment 1");

			return false;
		}
		
		if (comment2 == null || comment2.trim() == "") {
			alert("Please provide Comment 2");

			return false;
		}
		
		

		return true;
	}
</script>

<body>


	<form action="registration" method="POST"
		onsubmit="return validation()" id="signup" name>
		<header>
		<h1>Sign Up</h1>
		</header>
		<div class="container">




			<table>
				<tr>
					<td><label> First Name: </label></td>
					<td><input type="text" id="firstName" name="firstName"
						placeholder="Enter First Name" id="firstName"></td>
				</tr>
				<tr>
					<td><label> Last Name: </label></td>
					<td><input type="text" id="lastName" name="lastName"
						placeholder="Enter Last Name"></td>
				</tr>
				<tr>

					<td><label> Email Id: </label></td>
					<td><input type="email" name="email"
						placeholder="Enter EmailId" id="email"></td>
				</tr>

				<tr>
					<td><label> Gender: </label></td>
					<td><select name="gender" id="gender">
							<option name="male">Male</option>
							<option name="female">Female</option>
							<option name="other">Other</option>
					</select></td>
				</tr>

				<tr>
					<td><label> Birthday: </label></td>
					<td><input type="date" name="birthday" id="birthday"></td>
				</tr>


				<tr>
					<td><label> Password: </label></td>
					<td><input type="password" name="password"
						placeholder="Enter password" id="password"></td>
				</tr>

				<tr>
					<td><label> Re enter Password: </label></td>
					<td><input type="password" name="rePassword"
						placeholder="Re enter password" id="rePassword"></td>
				</tr>


				<tr>
					<td><label> Comment 1: </label></td>
					<td><textarea id="comment1" name="comment1"
							placeholder="What to do you feel about Mom & Dad"> </textarea></td>
				</tr>
				<br>

				<tr>
					<td><label> Comment 2: </label></td>
					<td><textarea id="comment2" name="comment2"
							placeholder="What to do you feel about your siblings<tr>"> </textarea></td>
				</tr>


				<tr>
					<td><input type="submit" value="Sign up"></input></td>
				</tr>

				<c:if test="${error != null}">
					<tr>
						<td><div style="color: red">${error}</div></td>
					</tr>
				</c:if>


			</table>
		</div>

	</form>

	<footer>Copyright &copy; Rohi Analtical India</footer>
</body>
</html>