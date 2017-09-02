<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <% 
Cookie userId = new Cookie("userId", request.getParameter("userId"));


// Set expiry date after 24 Hrs for the cookies.
userId.setMaxAge(60*60*24); 


// Add both the cookies in the response header.
response.addCookie( userId );

//session.setAttribute("userId", request.getParameter("userId"));
%> --%>

</head>


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
 <br class="clear" />
	<br class="clear" />
	
	<div>
		<button class="button4"><a href="../DownloadServlet">Download CSV</a></button>
	</div>
	

	