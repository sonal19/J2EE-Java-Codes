<%-- 
    Document   : t-shirt
    Created on : Aug 31, 2012, 2:40:07 PM
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

<strong><font face="comis sans ms"color="red" size="+5"><center>T-SHIRT</font></strong></center>
<br><br><br>
<table  width="1099" height="378" align="right" cellspacing="20"  >
  <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="tshirt1.jsp"><img src="images/a.PNG"width="151" height="200" align="left"></a>&nbsp;&nbsp;<b>&nbsp;&nbsp;<font color="white">WRANGLER<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;size:30"</font>
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="tshirt1.jsp"><button>View Details >></button></b></a>
</td>

<td >&nbsp;&nbsp;&nbsp;&nbsp;<a href="tshirt2.jsp"><img src="images/b.PNG"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<b><font color="white">LEVI'S<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;size: 32"</font>
	<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="tshirt2.jsp"><button>View Details >></button></b></a></td>
  </tr>
  <tr>
      <td ><a href="tshirt3.jsp"><img src="images/c.PNG"  width="151" height="200" align="left"></a><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white">REEBOK<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;SIZE: 30"</font> <br><br><br><br><br><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="tshirt3.jsp"><button>View Details >></button></b></a>
      </td>


      <td><b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="tshirt4.jsp"><img src="images/d.PNG"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white">PUMA <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SIZE: 34"</font>
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="tshirt4.jsp"><button>View Details >></button></a>
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
		ResultSet rs=st.executeQuery("select * from GARMENTS where GPRODUCT_NAME='T-Shirts'");
		while(rs.next())
              {
                  i1=rs.getInt(1);
                }
                session.setAttribute("tshirt",i1);
%>
<jsp:include page="footer.html"></jsp:include>
</body>
</html>