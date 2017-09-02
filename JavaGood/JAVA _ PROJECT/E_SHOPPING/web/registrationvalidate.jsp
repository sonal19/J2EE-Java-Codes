<%-- 
    Document   : registrationvalidate
    Created on : Aug 10, 2012, 5:13:41 AM
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
<%

String s1=request.getParameter("f");
String s2=request.getParameter("l");
String s3=request.getParameter("dln");
String s4=request.getParameter("pass");
String s5=request.getParameter("cpass");

if(s1==null || s2==null || s3==null || s4==null || s5==null){
    if(s1==null)
    { session.setAttribute("run1", "ok1");}
if(s2==null)
    {session.setAttribute("run2", "ok2"); }
if(s3==null)
    { session.setAttribute("run3", "ok3");}
if(s4==null)
    {session.setAttribute("run4", "ok4");}
if(s5==null)
    { session.setAttribute("run5", "ok5");}

//<jsp:forward page="registerform.jsp"/>
response.sendRedirect("registerform.jsp");
}
else{
response.sendRedirect("registercomplete.jsp");
}
%>
    </body>
</html>
