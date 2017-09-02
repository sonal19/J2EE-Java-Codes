<%-- 
    Document   : cart
    Created on : Sep 4, 2012, 12:31:32 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>

        <%@page import="java.sql.*;" %>
        <%
        String x1=request.getParameter("id1");
String x2=request.getParameter("id2");
        String x3=request.getParameter("id3");
        String x4=request.getParameter("id4");
        String x5=request.getParameter("id5");
        String x6=request.getParameter("id6");
        /**/

try{
    int i1=Integer.parseInt(x1.trim());
int i2=Integer.parseInt(x2.trim());
int i3=Integer.parseInt(x3.trim());
int i4=Integer.parseInt(x4.trim());
     int i6=Integer.parseInt(x6.trim());

       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
String sql="insert into orderdetail values(?,?,?,?,?,?)";
PreparedStatement st=con.prepareStatement(sql);
st.setInt(1,i1);
st.setInt(2,i2);
st.setInt(3,i3);
st.setInt(4,i4);
st.setString(5,x5);
st.setInt(6,i6);
out.println(st.execute());
}
catch(Exception e)
{out.println(e);
}

        %>
         <center><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
   <h1><font color="white"><u>ITEM IS SUCCESSFULLY ADDED INTO THE CART</u></font></h1><br>
   <a href=javascript:history.go(-1)><button>--ADD MORE ITEMS--</button></a>
<br><br>
    <a href="shoppingcart.jsp"><button>VIEW CART</button></a>

           <jsp:include page="footer.html"/>
    </body>
</html>
