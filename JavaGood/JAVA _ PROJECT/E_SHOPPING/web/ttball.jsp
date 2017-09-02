<html >
<body>
   <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br><br><p>&nbsp;</p>
<strong><font color="red" size="+5"><center>T.T Balls</strong></font></center>
<br><br><br><p>&nbsp;</p><p>&nbsp;</p>
<table width="1099" height="378" align="right"  cellspacing="20" >
  <tr>
     <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="stigaball.jsp"><img src="New Folder (3)/stigaball.jpg"width="151" height="200" align="left"></a>&nbsp;&nbsp;<b>&nbsp;&nbsp;<font color="white">Stiga ACM-1000 <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Table Tennis Balls
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="stigaball.jsp"><button>View Details >></button></b></a></td>
	
	<td >&nbsp;&nbsp;&nbsp;&nbsp;<a href="cup.jsp"><img src="New Folder (3)/cup.jpg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white"><b>Stiga Cup <br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;Table Tennis Balls
	<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="cup.jsp"><button>View Details >></button></b></a></td>  
  </tr>
  <tr>
  <td ><a href="joola.jsp"><img src="New Folder (3)/Freewill_5401_M_1_2x.jpg"  width="151" height="200" align="left"></a><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="white">Joola Rossi Champ Blister <br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;Table Tennis Balls<br><br><br><br><br><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="joola.jsp"><button>View Details >></button></b></a></td>
    
   
<td><b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="cosco.jsp"><img src="New Folder (3)/cosco.jpg"width="151" height="200"  align="left"></a>&nbsp;&nbsp;<font color="white">Cosco Stiga Competition  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Table Tennis Balls
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="cosco.jsp"><button>View Details >></button></a></td>
  </b></tr>
</table>
<br><br><p>&nbsp;</p><p>&nbsp;</p><br><br><p>&nbsp;</p><p>&nbsp;</p><br><br><p>&nbsp;</p><p>&nbsp;</p>
<br><br><p>&nbsp;</p><p>&nbsp;</p><br><br>
<p>&nbsp;</p><p><p>&nbsp;</p>
<p>&nbsp;</p><p><p>&nbsp;</p>
<p>&nbsp;</p><p><p>&nbsp;</p>
<p>&nbsp;</p><p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;
<br><br><br>
<jsp:include page="footer.html"/>
</body>
</html>

<%@page import="java.sql.*"%>
  <%! int i1; %>    
<%
   try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from TABLE_TENNIS where FITEM_NAME='T.T BALL' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);   
                }
                session.setAttribute("ttball",i1);}
   catch(Exception ex){}
%> 