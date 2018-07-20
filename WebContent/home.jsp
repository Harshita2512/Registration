<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<style>
header, footer {
	padding: em;
	color: white;
	background-color: black;
	text-align: center;
}


header div {
display :inline-block;
padding-right: 30px;
padding-left: 30px;

}

.container {
	padding-bottom: 3em;
	padding-top: 3em;

}

table {
	border-spacing: 20px;
	background-color: lightblue;
	padding-bottom: 1em;
	padding-top: 1em;
	border:8px solid black;
}
</style>
<body>

	<header><h1>Home Page</h1>
	
			<div><label> First Name: </label> ${userInfo.firstName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label> Last Name: </label>${userInfo.lastName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label> Email Id: </label> ${userInfo.email}</div>
	
	
	</header>
	<div class="container">
	<table>
		
		
		<tr>
			<td><label > <u>What I think about mom & dad</u> </label></td> 
			<td> ${userInfo.comment1}</td>
		</tr>
		
		<tr>
			<td><label> <u>What I think about my sibling</u></label></td> 
			<td> ${userInfo.comment2}</td>
		</tr>
	</table>
	</div>
	<footer>Copyright &copy; Rohi Analtical India</footer>
</body>
</html>