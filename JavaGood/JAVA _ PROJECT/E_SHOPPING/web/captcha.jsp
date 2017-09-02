<%-- 
    Document   : captcha
    Created on : Aug 28, 2012, 1:33:35 AM
    Author     : ACER
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="header.html" %>
         <table width="1330">
        <tr><td>
                <blockquote><blockquote></blockquote> &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         &nbsp;&nbsp;&nbsp;&nbsp;
                    </blockquote></blockquote></blockquote> </td>
<td align="left">


       
     <form method="post" >
     <font color="white" face="comic sans ms" size="5">

         <b> ... VALIDATION!!! ARE YOU HUMAN ??...</b>
     </font>


         <br> <br><br> <img src="http://localhost:8085/E_SHOPPING/captcha_servlet">



<br><br>

<font color="white" face="comic sans ms" size="4">Enter Captcha: <input type="text" name="code">>>>>></font>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="image" name="submit" src="images/captcha.jpg" width="60"height="40">
 </form>
<%
System.out.println("Hello............");
String fn=request.getParameter("FirstName");
String ln=request.getParameter("LastName");
String uname=request.getParameter("dln");
String email=request.getParameter("email");
String addr=request.getParameter("deliver");
String pass=request.getParameter("pass1");
String ans=request.getParameter("answer");
  String captcha = (String) session.getAttribute("captcha");
  String code = (String) request.getParameter("code");
int i=0;
//out.println(code);
//if (captcha != null && code != null) {
    
    if (captcha == null && code == null) {
 try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
Statement st=con.createStatement();
String sql="insert into REGISTER values('"+fn+"','"+ln+"','"+uname+"','"+email+"','"+addr+"','"+pass+"','"+ans+"')";

  captcha="";
code="";
    if (captcha.equals(code)) {
i=st.executeUpdate(sql);
      // out.println(fn+ln+uname+email+addr+pass+ans);
    out.println("<br><br><font color=yellow face comic sans ms size=4> <b>"
            + "YES YOU ARE CORRECT !!! TO GO FORWARD PLEASE---->"
            + "<a href=registercomplete.jsp><button>>>>CLICK ME<<<</button></a>");

     //response.sendRedirect("registercomplete.jsp");
  // RequestDispatcher rd=request.getRequestDispatcher("registercomplete.jsp");
    //rd.forward(request, response);

    }
	// out.print("<p class='alert'>Correct</p>");
     else {
     out.println("<br><br><font color=yellow face comic sans ms size=4><b>"
             + " SORRY !!! TO GO BACK TO REGISTER AGIAIN PLEASE---->"
            + "<a href=newregformjss.jsp><button>>>>CLICK ME<<<</button></a>"
            + "<br><BR> OR PLEASE TYPE THE WORDS PROPERLY AND THEN TRY AGAIN");
       // response.sendRedirect("newregformjss.jsp");
      //  out.println("sorry");
        // out.print("<p class='alert'>Incorrect</p>");
    
  }}

  catch(Exception e)
{out.println(e);
}
}
%>
</td></tr></table>
<%@include file="footer.html" %>
    </body>
</html>
