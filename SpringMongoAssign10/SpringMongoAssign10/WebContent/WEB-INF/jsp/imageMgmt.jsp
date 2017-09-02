<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<%-- <% 
Cookie userId = new Cookie("userId", request.getParameter("userId"));


// Set expiry date after 24 Hrs for the cookies.
userId.setMaxAge(60*60*24); 


// Add both the cookies in the response header.
response.addCookie( userId );

//session.setAttribute("userId", request.getParameter("userId"));
%> --%>

</head>

<link rel="stylesheet" href="../static/css/layout.css">
<link rel="stylesheet" type="text/css"
	href="../static/css/imageMgmt.css"></link>
<script src="../static/js/imageMgmt.js"></script>
<!-- <script src="../static/js/combineHandler.js"></script> -->
<script src="../static/js/jquery-3.1.0.min.js"></script>

</head>

<%-- <body align="center" onload="call('<%=userId%>')"> --%>
<body>
	<%@include file="../html/header.html"%>
	
	<%@include file="../html/logoutBar.html"%>
	
	<%@include file="../html/menubarHome.html"%>
	
	
	<div class="wrapper col3">
		<div id="intro"></div>

		<br class="clear" />
	</div>
	<br class="clear" />
	<br class="clear" />

	<div id="imageDetails">

		<%-- <%
			// int elements=(Integer)session.getAttribute("AvailableData");
			long elements = DataManager.getTableDataCount(Integer.parseInt(userId));
			if (elements > 0) {
		%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<c:url value="../RetreiveImgDataServlet" var="myURL">
			<c:param name="userId" value="${param.userId}" />

		</c:url>
		<c:import url="${myURL}" />

		<%
			}
		%>
 --%>
	</div>

	<div>
		<button class="button4"><a href="../DownloadServlet">Download CSV</a></button>
	</div>
	

	<%@include file="../html/footer.html"%>


</body>
</html>
