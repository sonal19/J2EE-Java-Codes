<%-- 
    Document   : dwnld
    Created on : Aug 16, 2012, 2:36:33 AM
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
    <body>
        <%@page import="java.sql.*"%>
  <%! int i1,i2,d2,d3; 
      String s,id;%>    
<%
    id=request.getParameter("link");
   
   try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from TT_RACKET  where FBAT_ID='"+id+"' ");
		while(rs.next())
                {
                   s=rs.getString(7);           
               
                }
                             }
   catch(Exception ex){}
   %>
      <%
      
  // fetch the file
  String filename = s;
  String filepath = "C:/Users/ACER/Desktop/TOM_AJAVA/JAVA _ PROJECT/E_SHOPPING/web/New Folder (3)/";
  response.setContentType(
    "APPLICATION/OCTET-STREAM");
  response.setHeader("Content-Disposition",
    "attachment; filename=\"" + filename + "\"");

  java.io.FileInputStream fileInputStream =new java.io.FileInputStream(filepath + filename);
  int i;
  while ((i=fileInputStream.read()) != -1) {
    out.write(i);
  }
  fileInputStream.close();
  out.close();
%>
    </body>
</html>
