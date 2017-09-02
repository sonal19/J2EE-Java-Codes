<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>



<link rel="stylesheet" type="text/css" href="../static/css/Design.css"></link>
</head>
<script src="../static/js/imageMgmt.js"></script>
<body id="animate-area" align="center">
	<header id="header">
	<div class="innertube">
		<p>
		<h1>
			<font color="black" face="Comic Sans MS">WELCOME</font>
		</h1>
		</p>
	</div>
	</header>

	<main>
	<div class="innertube">
		<form name="form1" action="../LoginServlet" method="post"
			onsubmit="return validateForm()">
			<fieldset>
				<legend>Login Page</legend>
				<table align="center">
					
					<tr>
						<td>Username<font color="red">*</font></td>
						<td><input id="uname" type="text" name="username" /></td>
						<td></td>
					</tr>
					<tr>
						
						<td>Password<font color="red">*</font></td>
						<td><input type="password" name="password" /></td>
					</tr>
					
					<tr>
						<td></td>
						<td><font color="red" size="1" align="left">
								*mandatory fields</font></td>
					</tr>

					<tr>
						<td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Login"></input><input
							type="reset" value="Reset"></input></td>
					</tr>
				</table>
			</fieldset>

		</form>

	</div>
	</main>

	<nav id="left">
	<div class="innertube">
		<div class="blink">
			<font face="Comic Sans MS" size="3" color="yellow">Sign In and
				Sign Up</font>
		</div>
		<br></br>
		<ul>
			<li><form action="/login">
					<input type="submit" value="Login" />
				</form> <br></br></li>
			<li><form action="/register">
					<input type="submit" value="Register" />
				</form></li>
			<li><a href="#">Link 3</a></li>
			<li><a href="#">Link 4</a></li>
			<li><a href="#">Link 5</a></li>
		</ul>
		<h1>Heading</h1>
		<ul>
			<li><a href="#">Link 1</a></li>
			<li><a href="#">Link 2</a></li>
			<li><a href="#">Link 3</a></li>
			<li><a href="#">Link 4</a></li>
			<li><a href="#">Link 5</a></li>
		</ul>

	</div>
	</nav>
	<div id="right">
		<div class="innertube">
			<p>Go Back</p>
		</div>
	</div>

	<footer id="footer">
	<div class="innertube">
		<p>@Copyright</p>
	</div>
	</footer>


</body>
</html>