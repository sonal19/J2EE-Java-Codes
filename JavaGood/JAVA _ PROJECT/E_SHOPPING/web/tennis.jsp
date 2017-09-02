
<html>

<body>
   <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br>
<br><p>&nbsp;</p>
<br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p>
<table cellspacing="30">
 
  <tr>
    <th width="100" ></th>
    <td><font face="arial"color="red" size="6"><b>Table Tennis</b></font></td>
  </tr><br>
  <tr>
  <th>   </th>
    <td><ul>
      <li><a href="racket.jsp"><h2><b>T.T Rackets</b></h2></a></li>
    </ul></td>
 
  </tr>
  <tr>
    <th>   </th><%----%>
    <td><ul>
      <li><a href="ttball.jsp"><h2><b>T.T Balls</b></h2></a></li>
    </ul></td>
 
  </tr>
</table>
<br><p>&nbsp;</p><br><p>&nbsp;</p>
<br><p>&nbsp;</p>
<br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p>
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
		ResultSet rs=st.executeQuery("select * from SPORTS_TABLE where SPRODUCT_NAME='Table Tennis' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);   
                }
                session.setAttribute("tennis",i1);
                               }
   catch(Exception ex){}
%> 