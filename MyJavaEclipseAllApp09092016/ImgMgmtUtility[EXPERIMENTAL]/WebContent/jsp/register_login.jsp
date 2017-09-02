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

<body align="center">

	<%@include file="../html/header.html"%>

	<main>
	<div class="innertube">
		<div class="form">

			<ul class="tab-group">
				<li class="tab active"><a href="#login">Log In</a></li>
				<li class="tab"><a href="#signup">Sign Up</a></li>
			</ul>

			<div class="tab-content">

				<%@include file="../html/login.html"%>
				<%@include file="../html/register.html"%>

			</div>
			<!-- tab-content -->

			<%@include file="../html/forgetPassword.html"%>

		</div>
		<!-- /form -->

	</div>
	</main>

	<%@include file="../jsp/leftBlock.jsp"%>
	<%@include file="../jsp/rightBlock.jsp"%>

	<%@include file="../html/footer.html"%>

	<script src="../static/js/jquery-3.1.0.min.js"></script>

	<script src="../static/js/userEventMgmt.js"></script>
</body>
</html>