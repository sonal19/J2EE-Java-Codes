<html>

<body>
 <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br><br><p>&nbsp;</p><br><p>&nbsp;</p><br>
<br><p>&nbsp;</p><p>&nbsp;</p><br><p>&nbsp;</p><br>


<table cellspacing="30">

  <tr>
    <th width="100" ></th>
    <td><font face="arial"color="red" size="6"><b>GARMENTS</b></font></td>
  </tr><br>
  <tr>
  <th>   </th>
    <td><ul>
      <li><a href="jeans.jsp"><h2><b>JEANS</b></h2></a></li>
    </ul></td>

  </tr>
  <tr>
    <th>   </th><%----%>
    <td><ul>
      <li><a href="t-shirt.jsp"><h2><b>T-SHIRTS</b></h2></a></li>
    </ul></td>

  </tr>

 
</table>


<p>&nbsp;</p><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br>
<p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br>
<%@page import="java.sql.*"%>
 <%! int i1; %>
<%
   
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from PRODUCT_CATEGORY where CATEGORYTYPE='Garment'");
		while(rs.next())
              {
                  i1=rs.getInt(1);   
                }
                session.setAttribute("garment",i1);
                
%>

<jsp:include page="footer.html"></jsp:include>
</body>
</html>