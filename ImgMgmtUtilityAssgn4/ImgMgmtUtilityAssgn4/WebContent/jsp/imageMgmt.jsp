<%@page import="com.nagarro.imageutility.services.DataManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>

<link rel="stylesheet" type="text/css" href="../static/css/Design.css"></link>

<link rel="stylesheet" type="text/css" href="../static/css/imageMgmt.css"></link>
<script src="../static/js/imageMgmt.js"></script>

</head>
<script src="../static/js/validation.js"></script>
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
		<legend>Image Uploader</legend>
		<fieldset>
			<div id="dropbox" align="center">
				Drag and drop a file here... <br /> Or <br /> Click here<br /> <br />

				<div class="image-upload">
					<label for="file-input"> <img src="../static/images/add.png" />
					</label> <input id="file-input" type="file" onchange="getFileData(this)" />
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
	
	<table border="1"  cellspacing="10" cellspadding="10"  >
	<tr>
	
	<th>Sn. No.</th>
	<th>Name</th>
	<th>Size</th>
	<th>Preview</th>
	<th>Actions</th>
	
	</tr>
	
	<%-- <%@page import="java.util.*"%>
	<%@page import="com.nagarro.imageutility.models.ImageDetail" %>
	<%
	int index=0;
	List<ImageDetail> dataItem=new ArrayList<ImageDetail>(15);
	dataItem.addAll(DataManager.getImageDetails());
							while(index<dataItem.size()){
								
							
	%>
	<tr>
	<th>
	<img src="../RetreiveImageServlet" width="100" height="100"/>
	<% dataItem.get(index).getName();%>
	</th>
	</tr>
	<%
	index++;} %> --%>
	
	
</table>
<%
// int elements=(Integer)session.getAttribute("AvailableData");
int elements=DataManager.getTableDataCount();
if(elements>0){ 
	
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:import url="../getData" />

<%} %>
	
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
