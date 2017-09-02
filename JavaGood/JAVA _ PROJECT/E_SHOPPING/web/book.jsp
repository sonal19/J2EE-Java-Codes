<%-- 
    Document   : book
    Created on : Aug 23, 2012, 8:21:46 PM
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
    <br><br><br><p>&nbsp;</p><br><p>&nbsp;</p><br>
<br><p>&nbsp;</p><p>&nbsp;</p><br><p>&nbsp;</p><br>


<table cellspacing="30">

  <tr>
    <th width="100" ></th>
    <td><font face="arial"color="red" size="6"><b>BOOKS CATEGORY</b></font></td>
  </tr><br>
  <tr>
  <th>   </th>
    <td><ul>
      <li><a href="prayer.jsp"><h2><b>PRAYER BOOKS</b></h2></a></li>
    </ul></td>

  </tr>
  <tr>
    <th>   </th><%----%>
    <td><ul>
      <li><a href="educational.jsp"><h2><b>EDUCATIONAL BOOKS</b></h2></a></li>
    </ul></td>

  </tr>

  <tr>
    <th>   </th><%----%>
    <td><ul>
      <li><a href="novels.jsp"><h2><b>NOVELS</b></h2></a></li>
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
		ResultSet rs=st.executeQuery("select * from PRODUCT_CATEGORY where CATEGORYID=3");
		while(rs.next())
              {
                  i1=rs.getInt(1);
                }
                session.setAttribute("books",i1);
                out.println(i1);
%> 
<jsp:include page="footer.html"></jsp:include>
</body>
</html>