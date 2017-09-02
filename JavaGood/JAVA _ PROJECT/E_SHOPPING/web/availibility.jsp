<%-- 
    Document   : availibility
    Created on : Aug 13, 2012, 4:47:29 AM
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
        <%!String s;%>
<%

//s=(String)application.getAttribute("name");

String un=request.getParameter("un");
//String un1=request.getParameter("dln");
//ServletContext context=getServletConfig().getServletContext();
out.println(un);

try{
//Cookie c1=new Cookie("tom","007");
//res.addCookie(c1);
//out.println(uname+pass);
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
Statement st=con.createStatement();

//String s1="select * from login where uname='"+uname+"' and pass='" +pass+"'";
//out.println(s);

ResultSet rs=st.executeQuery("select * from register where uname='"+un+"'");

if(rs.next())
{
System.out.println("Im here....");
    session.setAttribute("av","avl");
//response.sendRedirect("register.jsp");
    out.println(un);
}
//<jsp:forward page="registerform.jsp"/>
//res.sendRedirect("gov3");

else {
    session.setAttribute("av","av2");
System.out.println("I m else");
//response.sendRedirect("register.jsp");
//<jsp:forward page="registerform.jsp"/>
    // out.println(rs.getString(3));
    //out.println(rs.getString(2));
out.println(un);
//res.sendRedirect("go2");
}
//jkhgjkhresponse.sendRedirect("registerform.jsp");
}
catch(Exception e)
{out.println(e);
}
%>
    </body>
</html>
