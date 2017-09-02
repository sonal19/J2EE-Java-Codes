<%-- 
    Document   : query
    Created on : Sep 3, 2012, 6:44:25 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="images/i17.jpg">
        <%@page import="java.sql.*"%>
        <%
        String x1=request.getParameter("name");
String x2=request.getParameter("eid");
String x3=request.getParameter("no");
String x4=request.getParameter("SEARCH");
//out.println(x1+x2+x3+x4);
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
Statement st=con.createStatement();
int i=st.executeUpdate("insert into QUERY values('"+x1+"','"+x2+"','"+x3+"','"+x4+"')");
if(i!=0)
    {
out.println("<br><br><br><center><font color=white face=comic sans ms size=7>YOUR QUERY IS SUCCESSFULLY SUBMITTED<br><br>GO BACK TO PREVIOUS PAGE</font>");
out.println("<br><br><a href=javascript:history.go(-1)><button>GO BACK TO PREVIOUS PAGE</button></a></center>");
}
}
catch(Exception e)
        {out.println(e);}
%>

    </body>
</html>
