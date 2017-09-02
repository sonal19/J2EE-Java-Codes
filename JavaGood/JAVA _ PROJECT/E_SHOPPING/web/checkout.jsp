<%-- 
    Document   : checkout
    Created on : Aug 7, 2012, 10:17:12 AM
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
    <style type="text/css">
#my
{
width:400px;
height:800px;
background-image:url("images/i14.jpg");
-webkit-animation:tom 5s;
}

@-webkit-keyframes tom
{
from {background-image:url("images/i3.jpg");}
to {background-image:url("images/i4.jpg");}}


    </style>
    
<%
int total=0;
int price=0;
      try {

       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
       Statement st=con.createStatement();
      String s2="select * from orderdetail";
      ResultSet rs=st.executeQuery(s2);
     while(rs.next())
            {// rs.getInt(1);
             price=rs.getInt(6);
             total+=price;

    }
           }
catch (Exception e)
{
    System.out.println(e);
}
%>
 <%
         String name="";
     String s=(String)application.getAttribute("name");
        // String s=(String)session.getAttribute("name");
      // out.println(s);
      try {

       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
       Statement st=con.createStatement();
      String s2="select * from REGISTER where UNAME='"+s+"'";
      ResultSet rs=st.executeQuery(s2);
    //  out.println("<table border=1><center>");

      while(rs.next())
            {// rs.getInt(1);
             name=rs.getString(5);
      }

           }
catch (Exception e)
{
    System.out.println(e);
}
%>

<body>
         <jsp:include page="afterloginheader.jsp"/>
         <%@include file="header.html" %>
         <%@ page import="java.sql.*;" %>
        


         <table width="1330">
             <tr>
                 <td> <jsp:include page="afterloginheader3.jsp"/>
                     
                     <blockquote><blockquote></blockquote> &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;
                    </blockquote></blockquote></blockquote></td>

                    <td>

<script type="text/javascript">
function mouseOver()
{
document.b1.src ="images/min.jpg";
}
function mouseOut()
{
document.b1.src ="images/mout.jpg";
}
</script>


                      <div id="my">
         <form action="feedback.jsp">
        <center><h1><font face="comic sans ms" color="white" size="7"><b><u>CHECKOUT PAGE</u></b></font></h1>

         
          <font face="comic sans ms" color="white" size="6">
              <b><u>Delivery Detail</u></b></font></center><br>
 <font face="comic sans ms" color="white" size="5">
<i><u>Customer Detail</u></i>
 </font>
<br><br>
<font face="comic sans ms" color="white" size="4">
Customer Address:   <input type="text" name="address" value="<%out.println(name);%>"><br><br>
Customer Mobile No:   <input type="text" name="mob"><br><br>
<font face="comic sans ms" color="white" size="5">
<i><u>Credit Card Detail</u></i>
</font>
<br><br>
<font face="comic sans ms" color="white" size="4">
Bank Name :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<select name="bank">

<option>SBI <option>ICICI <option>AXIS <option>PNB <option>HDFC<option>UBI <option>YES <option>RBI <option>SWISS
</select><br><br>
Credit Card No. :<input type="text" name="Cardno"><br><p>&nbsp;</p>
<br>
<font face="comic sans ms" color="white" size="4" >
    <center>
  TOTAL PRICE(actual):&nbsp;&nbsp;&nbsp;
  <% out.println("<font color=yellow face=comic sans ms size=5>"+total+"</font>"); %>
    </center>
</font><br><br>
<%!String v;%>
<%
v=(String)session.getAttribute("open");
if(total<5000)
    {
    if(v==null)
            {
    %>
<a href="" >
<img src="images/mout.jpg" name="b1" alt="tom" width="400" height="175" onmouseOver="mouseOver()" onmouseOut="mouseOut()" />
</a>
<%
}
}
else{
    %>
<a href="discount.jsp" >
<img src="images/mout.jpg"  width="400" height="175" />
</a>
<%
}
%>
<br><br>
<font face="comic sans ms" color="white" size="4" >
    <center>
  TOTAL PRICE YOU HAVE TO PAY(discounted price):&nbsp;&nbsp;&nbsp;
  <%! String id;%>
  <% if(v==null){out.println("<font color=yellow face=comic sans ms size=6><b>"+total+"(0% discount)</b></font>");}
else if(v.equals("visit")){
  id=request.getParameter("id");
  out.println("<font color=yellow face=comic sans ms size=6><b>"+id+"</b></font>");}
session.removeAttribute("open");
  %>
    </center>
</font>
<br><br>
<center><input type="image" name="submit" src="images/creditcard.jpg" width="100" height="50">
        </center>
         </font>
</form>
</div>
</td></tr></table>
         </body>
</html>