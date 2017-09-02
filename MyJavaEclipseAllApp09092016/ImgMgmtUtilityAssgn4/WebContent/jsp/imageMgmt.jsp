<%@page import="com.nagarro.imageutility.services.DataManager"%>
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

<link rel="stylesheet" type="text/css" href="../static/css/Design.css"></link>

<link rel="stylesheet" type="text/css"
	href="../static/css/imageMgmt.css"></link>
<!-- <script src="../static/js/imageMgmt.js"></script> -->
<script src="../static/js/combineHandler.js"></script>
<script src="../static/js/jquery-3.1.0.min.js"></script>
<%
	String userId = request.getParameter("userId");
	String fullName = DataManager.getFullName(Integer.parseInt(userId));
%>
</head>

<body align="center" onload="call('<%=userId%>')">

	<%@include file="../html/header.html"%>

	<main>
	<div class="innertube">
		<legend>Image Uploader</legend>
		<fieldset>
			<div id="dropbox" align="center">
				Drag and drop a file here... <br /> Or <br /> Click here<br /> <br />

				<div class="image-upload">

					<label for="file-input"> <img
						src="../static/images/add.png" />
					</label><input id="file-input" type="file"
						onchange="getFileData(this,'<%=userId%>')"
						accept=".jpg, .png, .jpeg, .gif, .bmp, .tif, .tiff|images/*" />
				</div>
				<br />
				<div id="status"></div>
				<div id="myProgress">
					<div id="myBar">
						<div id="label"></div>
					</div>
				</div>
			</div>
		</fieldset>

	</div>

	<div id="imageDetails">

		<%
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

	</div>
	</main>

	<jsp:include page="leftBlock.jsp">
		<jsp:param name="name" value="<%=fullName%>" />
	</jsp:include>
	<%@include file="../jsp/rightBlock.jsp"%>

	<%@include file="../html/footer.html"%>


</body>
</html>
