<%-- 
    Document   : cartj
    Created on : Mar 26, 2012, 10:16:35 PM
    Author     : ravi
--%>
<%@page import="java.sql.*;"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <body>
     <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
   
        
        <%
          String x1=request.getParameter("id1");
        String x2=request.getParameter("id2");
        String x3=request.getParameter("id3");
        String x4=request.getParameter("id4");
        String x5=request.getParameter("id5");
       
       try{
      int i1=Integer.parseInt(x1.trim());
      int i2=Integer.parseInt(x2.trim());
      int i3=Integer.parseInt(x3.trim());
      int i5=Integer.parseInt(x5.trim());
     
/*
out.println("x1 sports id = "+(i1+1));
out.println("x2 product id= "+(i2+1));
out.println("x3 bat id= "+(i3+1));

out.println("x5  name= "+x4);
out.println("x6 price= "+(i5+1));
*/
       
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
String sql="insert into orderdetailp values(?,?,?,?,?)";
PreparedStatement st=con.prepareStatement(sql);
st.setInt(1,i1);
st.setInt(2,i2);
st.setInt(3,i3);
st.setString(4,x4);
st.setInt(5,i5);

st.execute();
}
catch(Exception e)
{out.println(e);
}
        
%>
    <center><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<form action="">
    <h1><font color="red">Item successfully added into a cart</font></h1><br>
    <input type="submit" value="------------Add more item-------------" >
</form>
</center>
    </body>
</html>  