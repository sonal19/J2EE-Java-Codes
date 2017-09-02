<%-- 
    Document   : newjsp
    Created on : 30 Jul, 2012, 3:09:29 AM
    Author     : arindam
--%>

<%@page contentType="text/html" import="java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>

  <%@page import="java.sql.*;" %>
        <%
          try {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
       Statement st=con.createStatement();

     String name = request.getParameter("id");

      //out.println(id);
     // String sql = "delete from item where item_id=" + id;
      int r= st.executeUpdate("delete from orderdetail where PRICE="+name+"");
            if (r!=0)
      out.println("<P><center><h1><font color=violet>ITEM DELETED.</font><h1></center></P>");
    else
     out.println("<P><h1><p>&nbsp;</p><font color=black><center><h2>Error deleting record.</h2></center></font><h1></P>");
    out.println("<a href=shoppingcart.jsp><h1><center>GO BACK TO PREVIOUS PAGE</center></a></h1>");
  }
catch (Exception e)
{
    System.out.println(e);
}
%>
<jsp:include page="footer.html"></jsp:include>
    </body>
</html>

