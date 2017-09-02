<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:importAttribute name="javascripts" />
<tiles:importAttribute name="stylesheets" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!-- stylesheets -->
<c:forEach var="css" items="${stylesheets}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
<!-- end stylesheets -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>

<!-- scripts -->
<c:forEach var="script" items="${javascripts}">
	<script src="<c:url value="${script}"/>"></script>
</c:forEach>
<!-- end scripts -->

</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="logout" />
	<tiles:insertAttribute name="menu" />
	<div class="wrapper col3">
		<div id="intro">
			<tiles:insertAttribute name="body" />
		</div>
		<br class="clear" />
	</div>
	<br class="clear" />
	<br class="clear" />

	<div id="imageDetails"></div>

	<tiles:insertAttribute name="footer" />


</body>
</html>