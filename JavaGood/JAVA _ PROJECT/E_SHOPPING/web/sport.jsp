
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
    <td><font face="arial"color="red" size="6"><b>Sports Item</b></font></td>
  </tr><br>
  <tr>
  <th>   </th>
    <td><ul>
      <li><a href="cricket.jsp"><h2><b>Cricket</b></h2></a></li>
    </ul></td>
 
  </tr>
  <tr>
    <th>   </th><%----%>
    <td><ul>
      <li><a href="tennis.jsp"><h2><b>Table Tennis</b></h2></a></li>
    </ul></td>
 
  </tr>
</table>


<p>&nbsp;</p><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br>
<p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><p>&nbsp;</p><br><jsp:include page="footer.html"/>
<%@page import="java.sql.*"%>
  <%! int i1; %>    
<%
   try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from PRODUCT_CATEGORY where CATEGORYTYPE='Sport' ");
		while(rs.next())
              {
                  i1=rs.getInt(1);   
                }
                session.setAttribute("sport",i1);
                               }
   catch(Exception ex){}
%>
</body>
</html>
 