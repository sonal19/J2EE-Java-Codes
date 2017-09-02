
<html >
<body>
     <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br>
<br><p>&nbsp;</p>
<br><p>&nbsp;</p><br><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p>

<table cellspacing="30">
 
  <tr>
    <th width="100" ></th>
    <td><font face="arial"color="red" size="6"><b>Cricket</b></font></td>
  </tr><br>
  <tr>
  <th>   </th>
    <td><ul>
      <li><a href="bat.jsp"><h2><b>Bats</b></h2></a></li>
    </ul></td>
 
  </tr>
  <tr>
    <th>   </th><%----%>
    <td><ul>
      <li><a href="ball.jsp"><h2><b>Balls</b></h2></a></li>
    </ul></td>
 
  </tr>
</table>


<br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p>
<br><br><br>
<br><p>&nbsp;</p>
<jsp:include page="footer.html"/>
<%@page import="java.sql.*"%>
 <%! int i1;%>    
<%
   
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from SPORTS_TABLE where SPRODUCT_NAME='Cricket' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);   
                }
                session.setAttribute("cricket",i1);
%>    
</body>
</html>
 