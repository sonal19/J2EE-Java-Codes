

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!String s;%>
    <%
  s=(String)session.getAttribute("out");
 try{ 
    if(s==null)
            {}
       else{ if(s.equals("sout"))
           out.println("<font face=comic sans ms color=yellow size=4><h1>SUCCESSFULLY LOG OUT.....</h1>");
    }
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
		Statement st=con.createStatement();
		int i=st.executeUpdate("delete from orderdetail");
  }
catch(Exception e){}
session.removeAttribute("out");
%>
 <%@include file="header.html" %>
 <table width="1300"><tr><td></td>
         <td align="right">
 <form action="login.jsp">
     <font color="white" face="comic sans ms" size="5">

         WANT TO BUY SOMETHING........
         PLEASE CLICK -------
     </font>
     <input type="image" name="submit" src="images/basket.jpg"width="80"height="50">
 </form></td></tr></table>
 <%@include file="footer.html" %>
 <%@page import="java.sql.*"%>
      </body>
</html>

