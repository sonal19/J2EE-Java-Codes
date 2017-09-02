<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up/Login Form</title>
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="../static/css/normalize.css">


<link rel="stylesheet" href="../static/css/style.css">

<link rel="stylesheet" type="text/css" href="../static/css/Design.css"></link>
</head>
<script src="../static/js/imageMgmt.js"></script>

<script>
							<%-- 	function edValueKeyPress() {
									<%Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ImageMgmtUtility", "root",
					"tom");

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
	} --%>
</script>



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
		<div class="form">

			<ul class="tab-group">
				<li class="tab active"><a href="#login">Log In</a></li>
				<li class="tab"><a href="#signup">Sign Up</a></li>
			</ul>

			<div class="tab-content">
				<div id="login">
					<h1>Welcome Back!</h1>

					<form action="../LoginServlet" method="post">

						<div class="field-wrap">
							<label> UserName<span class="req">*</span>
							</label> <input id="uname" type="text" name="username" />
						</div>

						<div class="field-wrap">
							<label> Password<span class="req">*</span>
							</label> <input type="password" name="password" required autocomplete="off" />
						</div>

						<p class="forgot">
							<a href="#forget">Forgot Password?</a>
						</p>

						<button class="button button-block" />
						Log In
						</button>

					</form>

				</div>
				<div id="signup">
					<h1>Sign Up for Free</h1>

					<form action="../RegisterServlet" method="post">

						<div class="top-row">
							<div class="field-wrap">
								<label> Full Name<span class="req">*</span>
								</label> <input type="text" name="fullname"  />
							</div>
							<div class="field-wrap">
								<label> Email Address<span class="req">*</span>
								</label> <input type="email" name="email" />
							</div>

						</div>

						<div class="field-wrap">
							<label> User Name<span class="req">*</span>
							</label> <input type="text" name="username" required autocomplete="off" />
						</div>

						<div class="field-wrap">
							<label> Set A Password<span class="req">*</span>
							</label> <input type="password" name="password" required autocomplete="off" />
						</div>

						<button type="submit" class="button button-block" />
						Register
						</button>

					</form>

				</div>

			</div>
			<!-- tab-content -->

			<div id="forget">
				<br /> <br />
				<h1>Don't Remember your Password!</h1>
				<form action="../MailerServlet" method="post">

					<div class="field-wrap">
						<label> Email Address<span class="req">*</span>
						</label> <input type="email" name="emailId" required autocomplete="off" />
					</div>
					<button class="button button-block" />
					Mail Me My Password
					</button>
				</form>

			</div>

		</div>
		<!-- /form -->

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

	<script	src="../static/js/jquery-3.1.0.min.js"></script>

	<script src="../static/js/userEventMgmt.js"></script>
</body>
</html>