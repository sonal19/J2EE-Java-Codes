<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
</head>

<link rel="stylesheet" href="../static/css/layout.css">
<link rel="stylesheet" type="text/css"
	href="../static/css/imageMgmt.css"></link>
<script src="../static/js/imageMgmt.js"></script>
<!-- <script src="../static/js/combineHandler.js"></script> -->
<script src="../static/js/jquery-3.1.0.min.js"></script>

</head>
<body>
	<%@include file="../html/header.html"%>
	<%@include file="../html/logoutBar.html"%>
	<%@include file="../html/menubarUpload.html"%>
	<br class="clear" />
	<br class="clear" />
	<div class="wrapper col3">
		<div id="intro">
			<%@include file="../html/uploader.html"%>
		</div>
		<br class="clear" />
	</div>
	<br class="clear" />
	<br class="clear" />

	<%@include file="../html/footer.html"%>


</body>
</html>