<%--
    Document   : afterloginheader2
    Created on : Aug 27, 2012, 1:27:54 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

<body>
<style type="text/css">

* { margin:0;
	padding:0;
}


.navbox {
	position: relative;
	float: left;
}

ul.nav {
	list-style: none;
	display: block;
	width: 150px;
	position: relative;
	top: 100px;
	left: 100px;
	padding: 60px 0 60px 0;
      /*  background: url(images/i8.jpg) no-repeat;
	-webkit-background-size: 72% 100%;*/
}

li {
	margin: 10px 0 0 0;
}

ul.nav li a {
	-webkit-transition: all 0.3s ease-out;
	background: #cbcbcb url(images/i5.jpg) no-repeat;
	color: #174867;
	padding: 7px 15px 7px 15px;
	-webkit-border-top-right-radius: 15px;
 	-webkit-border-bottom-right-radius: 15px;
	width: 100px;
	display: block;
	text-decoration: none;
	-webkit-box-shadow: 2px 2px 4px #888;
}

ul.nav li a:hover {
	background:url(images/i5.jpg) no-repeat;
	color: #67a5cd;
	padding: 3px 5px 3px 10px;
}

</style>

</head>

<body>

<div class="navbox">
<ul class="nav">
<li><a href="loginsuccessful.jsp"><img src="images/sm3.ico" height="20" width="20">HOME</a></li><br>
<li><a href=""><img src="images/sm1.ico" height="20" width="20">PROFILE</a></li><br>
<li> <a href="shoppingcart.jsp"><img src="images/sm4.ico" height="20" width="20">VIEW CART</a></li><br>
<li><a href="checkout.jsp"><img src="images/sm2.ico" height="20" width="20">CHECK OUT</a></li><br>
<li><a href="loginform.jsp"><img src="images/sm8.ico" height="20" width="20">LOGIN FORM</a></li><br>
<li><a href="newregformjss.jsp"><img src="images/sm5.ico" height="20" width="20">REGISTER FORM</a></li><br>
<li><a href="login.jsp"><img src="images/sm6.ico" height="20" width="20">LOGIN PAGE</a></li><br>
    <li><a href="sport.jsp"><img src="images/sm9.ico" height="20" width="20">SPORTS</a></li><br>
<li><a href="garments.jsp"><img src="images/sm11.ico" height="20" width="20">GARMENTS</a></li><br>
<li><a href="book.jsp"><img src="images/sm12.ico" height="20" width="20">BOOKS</a></li><br>
<li><a href="feedback.jsp"><img src="images/sm13.ico" height="20" width="20">FEEDBACK</a></li>
</ul>
</div>


    </body>

</html>
