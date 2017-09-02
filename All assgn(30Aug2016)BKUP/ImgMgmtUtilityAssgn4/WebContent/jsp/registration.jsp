<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

<script>
								function edValueKeyPress() {
									<%Class.forName("com.mysql.jdbc.Driver");

				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ImageMgmtUtility", "root","tom");

			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from registration_details");%>
									var edValue = document
											.getElementById("uname");
									var s = edValue.value;
									<%while (resultset.next()) {%>
									<%String r = resultset.getString(5);%>
									
									if(s==="<%=r%>") {
									alert("Matched username");

								}
						<%}%>
							}
						</script>

</head>

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
		<form name="form1" action="../RegisterServlet" method="post"
			onsubmit="return validateForm()">
			<fieldset>
				<legend>Registration Page</legend>
				<table align="center">
					<tr>
						<td>Full Name<font color="red">*</font></td>
						<td><input type="text" name="fullname" /></td>
					</tr>
					<tr>
						<td>Email<font color="red">*</font></td>
						<td><input type="email" name="email" /></td>
					</tr>
					<tr>
						<td>Username<font color="red">*</font></td>
						<td><input id="uname" type="text" name="username"
							onKeyPress="edValueKeyPress()" onKeyUp="edValueKeyPress()" /></td>
						<td></td>
					</tr>
					<tr>
						<td>Date Of Birth</td>
						<td><input type="date" name="dob" /></td>
					</tr>
					<tr>
						<td>Password<font color="red">*</font></td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>Confirm Password<font color="red">*</font></td>
						<td><input type="password" name="conpassword" /></td>
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
						<td><input type="submit" value="Register"></input><input
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