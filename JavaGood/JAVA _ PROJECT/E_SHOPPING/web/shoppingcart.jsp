<%-- 
    Document   : shoppingcart
    Created on : Sep 4, 2012, 12:34:20 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <style type="text/css">
#tom
{
width:500px;
height:700px;
background-image:url("images/i26.jpg");
-webkit-animation:tom 5s;
}

@-webkit-keyframes tom
{
from {background-image:url("images/i23.jpg");}
to {background-image:url("images/i18.jpg");}}
}



    </style>
    </head>
    <body>
        <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
     

   
    <%
String s=(String)application.getAttribute("name");
%>
<table width="1330">
             <tr>
                 <td><jsp:include page="afterloginheader3.jsp"/>
                     <blockquote><blockquote></blockquote> &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </blockquote></blockquote></blockquote></td>


<td>     <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
    <br><br><br><br> <br><br><br><br>
        <div id="tom">
            <center><font face="comic sans ms" color="white" size="7"><u>SHOPPING CART</u></font></center>
            <br> <font face="comic sans ms" color="white" size="4">USERNAME:&nbsp;&nbsp;&nbsp;<font face="comic sans ms" color="#FF8C00" size="5"><%out.println(s);%></font></font>
            <br><br>
            <form method="post" action="loginsuccessful.jsp">
               
         
  <%@page import="java.sql.*;" %>
<% int rw=0;
int total=0;
int price=0;
   String name;
   int id;
      try {

       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
       Statement st=con.createStatement();
      String s2="select * from orderdetail";
      ResultSet rs=st.executeQuery(s2);
    //  out.println("<table border=1><center>");

      
           out.println("<table border=3 cellspacing=2 cellpadding=2 width=500>");
          out.println("<tr>");

          out.println("<th align=center><font color=yellow face=comic sans ms size=5><u>NAME OF ITEMS</u></th><th><font color=yellow face=comic sans ms size=5><u>PRICE</u></th></font>");

          
          %>
  
          <center> <font face="comic sans ms" color="white" size="4"> ITEMS IN YOUR CART : </font>
           <br> <br></center>
      
      <% while(rs.next())
            {// rs.getInt(1);
          rw=rs.getRow();
              name=rs.getString(5);
             price=rs.getInt(6);
             total+=price;
             
          out.println("<tr>");
         
            out.println("<td align=center><font color=#00FF00 face=comic sans ms size=4>"+name+"</td>");
                out.println("<td align=center><font color=#00FF00 face=comic sans ms size=4>"+price+"</td>");

             out.println("<td align=center><a href=delete.jsp?id="+price+"><img src=images/rmv.jpg></a></td></font>");
              

       out.println("</tr>");
       
      }
           out.println("</table>");

 //out.println("</table>");

 /*

while(rs.next())
{
    String name=rs.getString(5);
    out.print("<td>rs.getString(5)</td>");

         rw=rs.getRow();
          //out.println(rw);
         out.print("&nbsp;&nbsp;<a href=delete.jsp?name="+name+">Remove Item</a>");
         out.println("");


    }*/
           }
catch (Exception e)
{
    System.out.println(e);
}
%>
<br><font face="comic sans ms" color="white" size="4">TOTAL ITEMS IN YOUR CART IS:&nbsp;&nbsp;&nbsp;<font face="comic sans ms" color="#FF8C00" size="5"> <% out.println(rw);%></font></font>
      <br>
<br><br><font face="comic sans ms" color="white" size="4">TOTAL PRICE OF YOUR ITEMS:&nbsp;&nbsp;&nbsp;<font face="comic sans ms" color="#FF8C00" size="5"><% out.println(total);%></font></font>
<br><br>
<center><input type="submit" value="ADD MORE ITEMS" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </center>
    </form><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="checkout.jsp"> <button>CHECK OUT </button></a>
    </div>
</td></tr></table>
  <jsp:include page="footer.html"></jsp:include>
</body>
</html>