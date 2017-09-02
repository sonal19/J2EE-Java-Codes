<%-- 
    Document   : sendpass
    Created on : Jul 26, 2012, 7:42:36 PM
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
    <style type="text/css">
#r
{
width:100px;
height:100px;
background:url("images/emotions/5.jpg");
-webkit-transition:width 2s, height 2s, -webkit-transform 1s; /* Safari and Chrome */
}

#r:hover
{
width:200px;
height:200px;
-webkit-transform:rotate(360deg); /* Safari and Chrome */
}
</style>
    <body>
        <%@include file="header.html" %>
         <table width="1330">
             <tr>
                 <td><blockquote><blockquote></blockquote> &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;
                    </blockquote></blockquote></blockquote></td>

                    <td>
  
<%!String s;%>
<%

s=(String)application.getAttribute("name");

String frgt_answer=request.getParameter("frgt_answer");
String eid=request.getParameter("eid");
//ServletContext context=getServletConfig().getServletContext();
String ans;

try{
//Cookie c1=new Cookie("tom","007");
//res.addCookie(c1);
//out.println(uname+pass);

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
Statement st=con.createStatement();

//String s1="select * from login where uname='"+uname+"' and pass='" +pass+"'";
//out.println(s);

ResultSet rs=st.executeQuery("select * from register where uname='"+s+"' and frgt_answer='"+frgt_answer+"'");
//out.println(eid);
if(rs.next())
{

   // out.println(rs.getString(3));
   ans=rs.getString(2);
   %>
<font face="comic sans ms" color="white" size="5"><center><b>WANT TO SEND YOUR PASSWORD TO YOUR EMAIL_ID ?
               </b></center></font> <br><br>
   <%
  out.println("<center><a href=SendMail?id1="+ans+"&id2="+eid+"><button>YES</button></a>");
  out.println("<a href=loginform.jsp><button>NO</button></a></center>");
   //context.setAttribute("my",s);
//res.sendRedirect("go1");
//res.sendRedirect("gov3");
}
else {
//out.println("Going to go2");
%>

<center><font face="comic sans ms" color=white size=5><b>...SORRY SOMETHING IS WRONG...<br>PLZ TRY AGAIN</b>
        </font><br>
        <div id="r"> <img src="images/emotions/4.jpg"width="100 hetght=100"></div></center>

               <%  //out.println(rs.getString(2));
//res.sendRedirect("go2");
}
}
catch(Exception e)
{out.println(e);
}
%>
<br><br><font face="comic sans ms" color="White" size="5"><center>PLEASE LOGIN AGAIN TO CONTINUE..</center></font>

<br>
<center>
<a href="login.jsp"><input type="submit"value="Login"size=20"></a></center>

<%@include file="footer.html" %>
    </body>
</html>
