<%-- 
    Document   : educational books
    Created on : Aug 14, 2012, 2:13:33 PM
    Author     : chandan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
    <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br>

<strong><font face="comis sans ms"color="red" size="+5"><center>EDUCATIONAL BOOKS</font></strong></center>
<br><br><br>
<table  width="1099" height="378" align="right" cellspacing="20"  >
  <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="head first java.jsp"><img src="images/head-first-java1.jpeg"width="151" height="200" align="left"></a>&nbsp;&nbsp;<b>&nbsp;&nbsp;<font color="white">HEAD FIRST JAVA<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;By: Kathy Sierra & Bert Bates</font>
              <br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="head first java.jsp"><button>View Details >></button></b></a>
</td>

<td >&nbsp;&nbsp;&nbsp;&nbsp;<a href="java complete reference.jsp"><img src="images/java-the-complete-reference1.jpeg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<b><font color="white">java: complete reference<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;By: Herbert Schildt</font>
	<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="java complete reference.jsp"><button>View Details >></button></b></a></td>
  </tr>
  <tr>
      <td ><a href="SCJP.jsp"><img src="images/scjp1.jpeg"  width="151" height="200" align="left"></a><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white">SCJP : Java 6 edition<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;By:Kathie sierra & Bert Bates</font> <br><br><br><br><br><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="SCJP.jsp"><button>View Details >></button></b></a>
      </td>


      <td><b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="interview in c programming.jsp"><img src="images/interview-questions-in-c-programming1.jpeg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white">INTERVIEW QUESTION IN C PROGRAMMING <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;By: Yashwant Kanetkar</font>
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="interview in c programming.jsp"><button>View Details >></button></a>
  </td>
  </b></tr>
</table>
<br><br><p>&nbsp;</p><p>&nbsp;</p><br><br><p>&nbsp;</p><p>&nbsp;</p><br><br><p>&nbsp;</p><p>&nbsp;</p><br><br><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p><p>&nbsp;</p>
<p>&nbsp;</p><p><p>&nbsp;</p>
<p>&nbsp;</p><p><p>&nbsp;</p>
<p>&nbsp;</p><p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;
<br><br><br>
<%@page import="java.sql.*"%>
  <%! int i1; %>
<%
try
        {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from BOOKS where BPRODUCT_NAME='Educational' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);
                }
                session.setAttribute("educational",i1);
                }
catch(Exception e)
        {}
%>
<jsp:include page="footer.html"/>
</body>
</html>