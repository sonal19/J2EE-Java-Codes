<%-- 
    Document   : jeans
    Created on : Aug 31, 2012, 2:39:39 PM
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

<strong><font face="comis sans ms"color="red" size="+5"><center>JEANS</font></strong></center>
<br><br><br>
<table  width="1099" height="378" align="right" cellspacing="20"  >
  <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="jeans1.jsp"><img src="images/1.PNG"width="151" height="200" align="left"></a>&nbsp;&nbsp;<b>&nbsp;&nbsp;<font color="white">FLYING MACHINE<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;size:30"</font>
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="jeans1.jsp"><button>View Details >></button></b></a>
</td>

<td >&nbsp;&nbsp;&nbsp;&nbsp;<a href="jeans2.jsp"><img src="images/2.PNG"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<b><font color="white">FLYING MACHINE<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;size: 32"</font>
	<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="jeans2.jsp"><button>View Details >></button></b></a></td>
  </tr>
  <tr>
      <td ><a href="jeans3.jsp"><img src="images/3.PNG"  width="151" height="200" align="left"></a><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white">LEVI'S<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;SIZE: 30"</font> <br><br><br><br><br><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="jeans3.jsp"><button>View Details >></button></b></a>
      </td>


      <td><b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="jeans4.jsp"><img src="images/4.PNG"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white">LEVI'S <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SIZE: 34"</font>
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="jeans4.jsp"><button>View Details >></button></a>
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

   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from GARMENTS where GPRODUCT_NAME='Jeans' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);
                }
                session.setAttribute("jean",i1);
%>    
<jsp:include page="footer.html"></jsp:include>
</body>
</html>
