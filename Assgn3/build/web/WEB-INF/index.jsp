<%-- 
    Document   : index
    Created on : Jun 3, 2016, 9:26:40 PM
    Author     : computer
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
         <%!String s;%>
    <%
  s=(String)session.getAttribute("out");
 try{ 
    
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:vishwaDSN");
		Statement st=con.createStatement();
		 String sql = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " + 
                   " last VARCHAR(255), " + 
                   " age INTEGER, " + 
                   " PRIMARY KEY ( id ))"; 

      st.execute(sql);
  }
catch(Exception e){}

%>
    </body>
</html>
