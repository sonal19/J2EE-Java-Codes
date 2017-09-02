<%-- 
    Document   : holy bible
    Created on : Aug 14, 2012, 12:43:53 AM
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
<img src="images/holy-bible2.jpeg" width="300" height="400" align="left">
<b><font size="+3" color="white">&nbsp;&nbsp;HOLY BIBLE</font>

    <ul ><font size="+2" color="white">

<li>&nbsp;&nbsp;&nbsp;By:Harper Collins Publisher </li>
<li>BOOK: Prayer book </li>
<li>Warranty: Manufacturer's repair/replacement warranty </li>
<li>paperback</li>
<li>pages:250</li>
</font>
</ul>

 <p>&nbsp;</p>&nbsp;&nbsp;
<font color="red" size="+3">Rs 973</font>
<br>


<%@page import="java.sql.*"%>
  <%! int i1,d1,d2,i2;
    String s;%>
<%
try
        {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from PRAYER where PBOOK_NAME='HOLY BIBLE'");
		while(rs.next())
                    {
                  i1=rs.getInt(1);
                   s=rs.getString(3);
                  i2=rs.getInt(6);

                     }
                session.setAttribute("holy bible",i1);

                  d1=(Integer)session.getAttribute("books");
                d2=(Integer)session.getAttribute("prayer");
          }
            
catch(Exception e)
        {}
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
    <a href=dwnld.jsp?link=<%out.println(i1);%>><button>Download Image</button></a>
</b></td></tr></table>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
    <jsp:include page="footer.html"/>

</body>
</html>
