<%-- 
    Document   : tshirt1
    Created on : Aug 31, 2012, 3:49:15 PM
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

    <br><br><br><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
    <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>

        <table width="1099" height="378" align="right"   ><tr><td>
<img src="images/22.PNG" width="300" height="400" align="left">
<b><font size="+3" color="white">&nbsp;&nbsp;DETAILS</font>

    <ul ><font size="+2" color="white">

<li>BRAND: WRANGLER </li>
<li>Size: 80</li>
<li>Color: Dark blue,black</li>
</font>
</ul>

 <p>&nbsp;</p>&nbsp;&nbsp;
<font color="red" size="+3">Rs 500</font>
<br>
 <%@page import="java.sql.*"%>
 <%! int i1,i2,d1,d2;
     String s; %>
<%

   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from TSHIRT where BRAND_NAME='Wringler'");
		while(rs.next())
              {
                  i1=rs.getInt(1);
                   s=rs.getString(3);
                  i2=rs.getInt(6);
                }
                session.setAttribute("tshirt2",i1);
                 int d1=(Integer)session.getAttribute("garment");
                int d2=(Integer)session.getAttribute("tshirt");

%>
<form action="Cart.jsp">
    <input type="hidden" name="id1" value="<%out.println(d1);%>"/>
    <input type="hidden" name="id2" value="<%out.println(d2);%>"/>
    <input type="hidden" name="id3" value="<%out.println(1);%>"/>
      <input type="hidden" name="id4" value="<%out.println(i1);%>"/>
    <input type="hidden" name="id5" value="<%out.println(s);%>"/>
    <input type="hidden" name="id6" value="<%out.println(i2);%>"/>
    

<input type="Submit" value="Add more item(s) to cart"/>
</form>
    </p>

    <a href=dwnld.jsp?link=<%out.println(i1);%>><button>Download Image</button></a>

    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p></td>
  </tr>
</table>
<p>&nbsp;</p>

<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>

<jsp:include page="footer.html"></jsp:include>
</body>
</html>

