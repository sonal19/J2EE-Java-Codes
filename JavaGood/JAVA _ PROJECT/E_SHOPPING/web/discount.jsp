<%-- 
    Document   : discount
    Created on : Sep 4, 2012, 4:14:48 AM
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

 <%@ page import="java.sql.*;" %>
<%
int total=0;
double tot=0;
int price=0;
      try {

       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
       Statement st=con.createStatement();
      String s2="select * from orderdetail";
      ResultSet rs=st.executeQuery(s2);
     while(rs.next())
            {// rs.getInt(1);
             price=rs.getInt(6);
             total+=price;

    }
      tot=total;
           }
catch (Exception e)
{
    System.out.println(e);
}
session.setAttribute("open","visit");

if(total>5000)
    {
    tot=tot-(0.2*tot);
        out.println("<br><br><br><center><font color=white face=comic sans ms size=7>CONGRATULATION!!! YOU GET 20% DISCOUNT...<br><br>GO BACK TO PREVIOUS PAGE TO GET THE DISCOUNTED PRICE</font>");
out.println("<br><br><a href=checkout.jsp?id="+tot+"><button>GO BACK TO PREVIOUS PAGE</button></a></center>");

}
else if(total>10000)
        {
    tot=tot-(0.4*tot);
    out.println("<br><br><br><center><font color=white face=comic sans ms size=7>CONGRATULATION!!! YOU GET 40% DISCOUNT...<br><br>GO BACK TO PREVIOUS PAGE TO GET THE DISCOUNTED PRICE</font>");
out.println("<br><br><a href=checkout.jsp?id="+tot+"><button>GO BACK TO PREVIOUS PAGE</button></a></center>");

}
%>
  </body>
</html>