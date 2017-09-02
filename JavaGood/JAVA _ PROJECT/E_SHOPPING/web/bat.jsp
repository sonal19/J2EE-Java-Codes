<html>
<body>
    <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br>

<p>&nbsp;</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<strong><font face="comis sans ms"color="red" size="+5"><center>Bats</strong></font></center>
<br><br><br><p>&nbsp;</p><p>&nbsp;</p>
<table width="1099" height="378" align="right" cellspacing="20"  >
  <tr>
     <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="v100.jsp"><img src="New Folder (3)/BAT/v100.jpg"width="151" height="200" align="left"></a>&nbsp;&nbsp;<b>&nbsp;&nbsp;<font color="white">V 100 Slazenger<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cricket Bat
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="v100.jsp"><button>View Details >></button></b></a>
</td>
	
	<td >&nbsp;&nbsp;&nbsp;&nbsp;<a href="puma.jsp"><img src="New Folder (3)/BAT/PUMA.jpg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white"><b>Puma Calibre Blast<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;Cricket Bat
	<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="puma.jsp"><button>View Details >></button></b></a></td>  
  </tr>
  <tr>
  <td ><a href="reebok.jsp"><img src="New Folder (3)/BAT/RBK.jpg"  width="151" height="200" align="left"></a><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white">Reebok Legend English Willow<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;Cricket Bat<br><br><br><br><br><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="reebok.jsp"><button>View Details >></button></b></a>
      </td>
    
   
<td><b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="adidas.jsp"><img src="New Folder (3)/BAT/ADIDAS.jpg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white">Adidas Incurza Elite <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cricket Bat
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="adidas.jsp"><button>View Details >></button></a>
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

<jsp:include page="footer.html"/>
<%@page import="java.sql.*"%>
  <%! int i1; %>    
<%
   
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from CRICKET where CITEM_NAME='Bat' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);   
                }
                session.setAttribute("bat",i1);
%> 
</body>
</html>
   