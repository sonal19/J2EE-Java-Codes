<html>
<body>
     <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br>
<p>&nbsp;</p>&nbsp;&nbsp;&nbsp;&nbsp;
<strong><font color="red" size="+5"><center>T.T Rackets</center></font></strong>
<br><br><br><p>&nbsp;</p><p>&nbsp;</p>
<table width="1099" height="378" align="right"  cellspacing="20" >
  <tr>
     <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="butterfly.jsp"><img src="New Folder (3)/Butterfly.jpg"width="151" height="200" align="left"></a>&nbsp;&nbsp;<b>&nbsp;&nbsp;
             <font color="white">  Butterfly ACM-1000 <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Table Tennis Blade
<br><br><br><br><br><br><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="butterfly.jsp"><button>View Details >></button></b></a></td>
	
	<td >&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="racket2.jsp"><img src="New Folder (3)/racket2.jpg"width="151" height="200"  align="left"></a>
            &nbsp;&nbsp;<b><font color="white">Joola Smash Recreational <br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;Table Tennis Racket
	<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="racket2.jsp"><button>View Details >></button></b></a></td>  
  </tr>
  <tr>
  <td ><a href="stiga.jsp"><img src="New Folder (3)/stiga.jpg"  width="151" height="200" align="left"></a>
      <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <font color="white"> Stiga® Sandy <br>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;Table Tennis Racket<br><br><br><br><br><br><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="stiga.jsp"><button>View Details >></button></b></a></td>
    
   
<td><b>&nbsp;&nbsp;&nbsp;&nbsp;<a href="racket3.jsp"><img src="New Folder (3)/racket3.jpg"width="151" height="200"  align="left"></a>
        &nbsp;&nbsp;<font color="white">JOOLA USA Python  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Table Tennis Paddle
<br><br><br><br><br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="racket3.jsp"><button>View Details >></button></a></td>
  </b></tr>
</table>

<br><br><p>&nbsp;</p><p>&nbsp;</p><br><br><p>&nbsp;</p><p>&nbsp;</p><br><br><p>&nbsp;</p><p>&nbsp;</p><br><br><p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p>
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
   
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from TABLE_TENNIS where FITEM_NAME='T.T Racket' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);   
                }
                session.setAttribute("racket",i1);
                

%> 