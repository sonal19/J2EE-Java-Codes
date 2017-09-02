<%-- 
    Document   : prayer books
    Created on : Aug 13, 2012, 1:37:50 PM
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

<strong><font face="comis sans ms"color="red" size="+5"><center>PRAYER BOOKS</font></strong></center>
<br><br><br>
<table  width="1099" height="378" align="right" cellspacing="20"  >
  <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="bhagwat geeta.jsp"><img src="images/bhagwat geeta1.jpeg"width="151" height="200" align="left"></a>&nbsp;&nbsp;<b>&nbsp;&nbsp;<font color="white">BHAGWAT GEETA<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;By Sant Dnyaneshwar</font>
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="bhagwat geeta.jsp"><button>View Details >></button></b></a>
</td>

<td >&nbsp;&nbsp;&nbsp;&nbsp;<a href="the quran.jsp"><img src="images/the-holy-quran1.jpeg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<b><font color="white">HOLY QURAN<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;By: Abdullah Yusuf Ali</font>
	<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="the quran.jsp"><button>View Details >></button></b></a></td>
  </tr>
  <tr>
      <td ><a href="valmiki ramayan.jsp"><img src="images/valmiki-s-ramayana1.jpeg"  width="151" height="200" align="left"></a><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white">VALMIKI'S RAMAYAN<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;By Suba Rao</font> <br><br><br><br><br><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="valmiki ramayan.jsp"><button>View Details >></button></b></a>
      </td>


      <td><b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="holy bible.jsp"><img src="images/holy-bible1.jpeg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white">HOLY BIBLE <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;By: Harper Collins Publisher</font>
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="holy bible.jsp"><button>View Details >></button></a>
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
		ResultSet rs=st.executeQuery("select * from BOOKS where BPRODUCT_NAME ='Prayer' ");
		while(rs.next())
                {
                  i1=rs.getInt(1);
                }
                session.setAttribute("prayer",i1);
         }
catch(Exception e)
        {}

%>
<jsp:include page="footer.html"></jsp:include>
</body>
</html>