
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style type="text/css">
#my
{
width:350px;
height:250px;
background-image:url("images/i14.jpg");
-webkit-animation:tom 5s;
}

@-webkit-keyframes tom
{
from {background-image:url("images/i3.jpg");}
to {background-image:url("images/i4.jpg");}}


    </style>
    <body background="images/i16.jpg">
         <%@include file="header.html" %>
         <table width="1330">
             <tr>
                 <td><blockquote><blockquote></blockquote> &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;
                    </blockquote></blockquote></blockquote></td>

                    <td>
                      <div id="my">

         <h1><font face="comic sans ms" color="white"><b>WELCOME TO LOGIN PAGE</b></h1>
        <%!String s;%>
         <%
        s=(String)session.getAttribute("flag");
        if(s==null)
            {}
       else{ if(s.equals("invalid"))
            out.println("<center><font color=red face=comic sans ms size=4><b>**Wrong username or password</b></font></center><br>");}
session.removeAttribute("flag");
         %>
         <form action="login">
          <font face="comic sans ms" color="white" size="4">
       Username:    <input type="text"value=""maxlength="20"size="30" name="uname"><p>
Password:   <input type="password"maxlength="20"size="30" name="pass"><p><p>

<input type="checkbox">Stay signed in <p><p><p><p>
&nbsp;&nbsp;&nbsp;

<input type="submit"value="Login..."size=60">

&nbsp;&nbsp;&nbsp;&nbsp;

<input type="reset"value="Reset..."size=60"><p><p><p>
</form>
<blockquote>
             <a href=forgotpassword.jsp>
         <font color="white" size="4">Forgot password</font></a></blockquote>
</div>
</td></tr></table>
         <%@include file="footer.html" %>
         </body>
</html>
