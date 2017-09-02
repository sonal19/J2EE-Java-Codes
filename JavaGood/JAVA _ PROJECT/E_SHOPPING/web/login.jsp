<%-- 
    Document   : login
    Created on : Jul 26, 2012, 7:05:00 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>

    <%@include file="header.html" %>
       

    <style type="text/css">
#div1
{
width:330px;
height:130px;
background-image:url("images/i9.jpg");
/*-moz-box-shadow: 10px 10px 5px #888888;  Firefox 3.6 and earlier */
-webkit-box-shadow: 10px 10px 5px #FFFF00;

}

h1
{
text-shadow: 5px 5px 5px #FF0000;
}


#z
{
height:115px;
width:615px;
background-image:url("images/combine.jpg");
-webkit-animation:myfirst 20s;
}

@-webkit-keyframes myfirst 
{
0%   {background-image:url("images/combine.jpg");}
25% {background-image:url("images/sport.jpg");}
50% {background-image:url("images/garments.jpg");}
75% {background-image:url("images/books.jpg");}
100% {background-image:url("images/combine.jpg");}
}

</style>
    <table width="1330">
        <tr><td><blockquote><blockquote></blockquote> &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </blockquote></blockquote></blockquote> </td>
<td align="left">

<blockquote>
    <div id="div1">
        <font face="Script MT"color="white" size="4"><h1><i><b>JOIN NOW IT'S FREE</b></i></h1></font>
<p><p><p><p><p><p>
<font color="FF3300" size="5">IF YOU ARE A MEMBER....
<a href="loginform.jsp">
<input type="image" name="submit" src="images/signup.jpg"width="50"height="20"></a>

<p><p><p><p>

FOR A NEW MEMBER PLZ....</font>
<a href="newregformjss.jsp">
<input type="image" name="submit" src="images/reg.jpg"width="70"height="22"></a>
    </div>
    </blockquote>
</td></tr></table>
    <br><br>

  <center><div id="z"></div></center>
<%@include file="footer.html" %>
</body>
</html>
