

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loginsuccs Page</title>
    </head>
    <body>
 <%@include file="afterloginheader.jsp" %>
    <%@include file="header.html" %>
    


    <style type="text/css">
#div1
{
width:330px;
height:50px;
background-image:url("images/i9.jpg");
/*-moz-box-shadow: 10px 10px 5px #888888;  Firefox 3.6 and earlier */
-webkit-box-shadow: 10px 10px 5px #FFFF00;

}

h1
{
text-shadow: 5px 5px 5px #FF0000;
}


#c
{
border:2px solid #a1a1a1;
padding:2px 4px;
background-image:url("images/ir.jpg");
width:1330px;
height:48px;
-webkit-border-radius:25px;
}
#r
{
width:100px;
height:100px;
background:url("images/emotions/6.jpg");
-webkit-transition:width 2s, height 2s, -webkit-transform 1s; /* Safari and Chrome */
}

#r:hover
{
width:250px;
height:250px;
-webkit-transform:rotate(450deg); /* Safari and Chrome */
}


</style>
    <table width="1330">
        <tr><td>  <%@include file="afterloginheader2.jsp" %>
                <blockquote><blockquote></blockquote> &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<blockquote>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </blockquote></blockquote></blockquote> </td>
<td align="left">
   

       <blockquote>
    <font face="Script MT"color="white" size=""><h1><i><b>WELCOME TO TEEMKART</b></i></h1></font>
<p><p><p><p><p><p>
<font color="white" size="5">....AN ENJOYMENT OF SHOPPING....</font><br><br>

<%
int n=0;
try{

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
Statement st=con.createStatement();

ResultSet rs=st.executeQuery("select * from orderdetail");

while(rs.next())
{
   rs.getString(2);
   n=rs.getRow();
    }
if(n==0)
{out.println("<font face=comic sans ms color=white size=5>YOUR CART IS EMPTY</font><br><br>");}
    else
{out.println("<font face=comic sans ms color=white size=5>YOUR CART CONTAINS <b>" +n+ "</b> ITEMS</font><br><br>");}
}
catch(Exception e)
{out.println(e);
}
%>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="images/ECART.jpg"width="100"height="100"><br><br>
<div id="r"><img src="images/emotions/6.jpg"width="150"height="150"></div>
    
    </blockquote>
</td></tr></table>
    <br><br><br><br>
    <div id="c">
        <pre>
<h1>   <a href="sport.jsp">SPORT</a>                            <a href="garments.jsp">GARMENTS</a>                            <a href="book.jsp">BOOKS</a>
</h1>   </pre> </div>
    <br><br>
  <center>
      <h1><font color="white"face="comic sans ms">...GRID VIEW...</font></h1><br>
      <img src="images/combine.jpg" usemap=ricktam height="115"width="615">

<map name="ricktam">

    <area  shape="rect" coords="0,0,205,115" href="sport.jsp">
<area shape="rect" coords="205,0,410,115" href="garments.jsp">
<area shape="rect" coords="410,0,615,115" href="book.jsp">

</map>
  </center>
<%@include file="footer.html" %>
</body>
</html>

