<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav id="left">
	<div class="innertube">
		<div class="blink">
			<font face="Comic Sans MS" size="3" color="yellow">Useful
				Links</font>
		</div>
		<br />
		<ul>
			<li><a href="http://facebook.com">Facebook</a></li>
			<li><a href="http://twitter.com">Twitter</a></li>

		</ul>
		<%
			String userName = "";
			if (request.getParameter("name") != null) {
				userName = request.getParameter("name");
		%>
		<h3>
			<font size="3" color="yellow">WELCOME</font> <br />
			<br />
			<%=userName%></h3>
		<%
			}
		%>


	</div>
	</nav>
</body>
</html>