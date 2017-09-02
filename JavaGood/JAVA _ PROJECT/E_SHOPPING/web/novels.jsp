<%-- 
    Document   : novels
    Created on : Aug 13, 2012, 1:38:22 PM
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

<strong><font face="comis sans ms"color="red" size="+5"><center>NOVEL'S</font></strong></center>
<br><br><br>
<table  width="1099" height="378" align="right" cellspacing="20"  >
  <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="wings of fire.jsp"><img src="images/wings-of-fire1.jpeg"width="151" height="200" align="left"></a>&nbsp;&nbsp;<b>&nbsp;&nbsp;<font color="white">WINGS OF FIRE(An Autobiography)<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;By: Abdul kalam Azad with Arun Tiwary</font>
              <br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="wings of fire.jsp"><button>View Details >></button></b></a>
</td>

<td >&nbsp;&nbsp;&nbsp;&nbsp;<a href="white tiger.jsp"><img src="images/the-white-tiger1.jpeg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<b><font color="white">THE WHITE TIGER<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;By: Arvind Adiga</font>
	<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="white tiger.jsp"><button>View Details >></button></b></a></td>
  </tr>
  <tr>
      <td ><a href="she broke up.jsp"><img src="images/she-broke-up-i-didn-t-i-just-kissed-someone-else1.jpeg"  width="151" height="200" align="left"></a><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white">SHE 3ROKE UP I DIDN'T...<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;By:Durjoy Dutta</font> <br><br><br><br><br><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="SCJP.jsp"><button>View Details >></button></b></a>
      </td>


      <td><b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="i too had a love story.jsp"><img src="images/i-too-had-a-love-story1.jpeg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white">I TOO HAD A LOVE STORIES <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;By: Ravinder Singh</font>
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="i too had a love story.jsp"><button>View Details >></button></a>
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
		ResultSet rs=st.executeQuery("select * from BOOKS where BPRODUCT_NAME='novels' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);
                }
                session.setAttribute("novels",i1);
                out.println(i1);
                }
catch(Exception e)
        {}
%>
<jsp:include page="footer.html"></jsp:include>
</body>
</html>