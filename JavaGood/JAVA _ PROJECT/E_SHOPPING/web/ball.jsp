<html>
<body>
     <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br>
<p>&nbsp;</p><p>&nbsp;</p>    
<p>&nbsp;</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<strong><center><font face="comic sans ms" color="red" size="+5" align="center">Balls</strong></font></center>
    <br><br><br><p>&nbsp;</p><p>&nbsp;</p>

<table width="1099" height="378" align="right"  cellspacing="20" >
  <tr>
     <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="red.jsp"></a><a href=""><img src="New Folder (3)/SeG_Combo_20_M_1_2x.jpg"width="151" height="200" align="left"></a><br>&nbsp;&nbsp;<b>&nbsp;&nbsp;<font color="white">Cosco Cricket Tennis Tuff <br>&nbsp;&nbsp;&nbsp;&nbsp;Balls (pack of 1 dozen)
<br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="red.jsp"><button>View Details >></button></b></a></td>
	
	<td >&nbsp;&nbsp;&nbsp;&nbsp;<a href="club.jsp"><img src="New Folder (3)/101925_Hansraj_HRM_M_1_2X.jpg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<b><font color="white">HRM Cricket Ball Club Leather <br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;Cricket Ball
	<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="club.jsp"><button>View Details >></button></b></a></td>  
  </tr>
  <tr>
  <td ><a href="green.jsp"><img src="New Folder (3)/SeG_CSY_1_M_1_2x.jpg"  width="151" height="200" align="left"></a><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white">Cosco Cricket Tennis Balls (light weight)<br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; (Pack of 6)<br><br><br><br><br><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="green.jsp"><button>View Details >></button></b></a></td>
    
   
<td><b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="leather.jsp"><img src="New Folder (3)/101926_Hansraj_HRM_M_1_2X.jpg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white">HRM Cricket Ball Practice Soft <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cricket Ball
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="leather.jsp"><button>View Details >></button></a></td>
  </b></tr>
</table>
<p>&nbsp;</p><p><p>&nbsp;</p><p>&nbsp;</p><p><p>&nbsp;</p><p>&nbsp;</p><p><p>&nbsp;</p><p>&nbsp;</p><p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p><p><p>&nbsp;</p><p>&nbsp;</p><p><p>&nbsp;</p><p>&nbsp;</p><p><p>&nbsp;</p>
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
		ResultSet rs=st.executeQuery("select * from CRICKET where CITEM_NAME='Ball' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);   
                }
                session.setAttribute("ball",i1);
                out.println(i1);
%> 
</body>
</html>

   