<%--
    Document   : upload
    Created on : Aug 22, 2012, 3:33:06 AM
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

<%@page import="com.oreilly.servlet.*,javax.servlet.*" %>
        <%
       //response.setContentType("multipart/form-data");
       //response.setContentType("text/html");
        MultipartRequest m=new MultipartRequest(request,"C://");
        out.println("success");
%>
    </body>
</html>
