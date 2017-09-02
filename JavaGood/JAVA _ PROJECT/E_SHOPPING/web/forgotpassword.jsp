
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style type="text/css">
#my1
{
width:350px;
height:265px;
background-image:url("images/i20.jpg");
-webkit-animation:tom 5s;
}

@-webkit-keyframes tom
{
from {background-image:url("images/i18.jpg");}
to {background-image:url("images/i17.jpg");}}
}

    </style>
    <body background="images/i16.jpg">

        <%!String s;%>
         <%
        // Cookie c[] = request.getCookies();
//if (c[0].getName().equals("uname"))
 //out.println(c[0].getValue());
   //      out.println("hi");
    s=(String)application.getAttribute("name");
        //application context=getServletConfig().getServletContext();
         //String s=session.getAttribute("name");
      // String uname=request.getParameter("uname");
         //out.println("<input type=hidden name=unm value="+uname+">");
//out.println("<input type=hidden name=uname value="+s+">");
//out.println(s);
%>

<%@include file="header.html" %>
         <table width="1330">
             <tr>
                 <td><blockquote><blockquote></blockquote> &nbsp;&nbsp;&nbsp;&nbsp;
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
                      <div id="my1">
         <h1><font face="comic sans ms" color="white"><b></b></h1>

         <form action="sendpass.jsp">
             <font face="comic sans ms" color="white" size="4">
                 <center><u>FORGOT PASSWORD</u></center><br><br>
                 <%out.println("HI <font face=comic sans ms color=yellow size=4>"+s+"</font> Plz Fill your Details");%><br><br>

                 Enter the Answer of your Security Question:  <br>
<input type="text" maxlength="30" size="30" name="frgt_answer" ><p>
Email_id:    <input type="email" maxlength="50"size="30"name="eid"><p>
Birthday:
<select name="day">
<option>1 <option>2 <option>3 <option>4 <option>5 <option>6 <option>7 <option>8 <option>9 <option>10

<option>11 <option>12 <option>13 <option>14 <option>15 <option>16 <option>17 <option>18 <option>19 <option>20

<option>21 <option>22 <option>23 <option>24 <option>25 <option>26 <option>27 <option>28 <option>29 <option>30
</select>

<select name="month">

<option>january <option>february <option>march <option>april  <option>may <option>june <option>july <option>august <option>september

<option>october <option>november <option>december

</select>

<select name="year">
    <option value="2012">2012</option>
<option value="2011">2011</option>
<option value="2010">2010</option>
<option value="2009">2009</option>
<option value="2008">2008</option>
<option value="2007">2007</option>
<option value="2006">2006</option>
<option value="2005">2005</option>
<option value="2004">2004</option>
<option value="2003">2003</option>
<option value="2002">2002</option>
<option value="2001">2001</option>
<option value="2000">2000</option>
<option value="1999">1999</option>
<option value="1998">1998</option>
<option value="1997">1997</option>
<option value="1996">1996</option>
<option value="1995">1995</option>
<option value="1994">1994</option>
<option value="1993">1993</option>
<option value="1992">1992</option>
<option value="1991">1991</option>
<option value="1990">1990</option>
<option value="1989">1989</option>
<option value="1988">1988</option>
<option value="1987">1987</option>
<option value="1986">1986</option>
<option value="1985">1985</option>
<option value="1984">1984</option>
<option value="1983">1983</option>
<option value="1982">1982</option>
<option value="1981">1981</option>
<option value="1980">1980</option>
<option value="1979">1979</option>
<option value="1978">1978</option>
<option value="1977">1977</option>
<option value="1976">1976</option>
<option value="1975">1975</option>
<option value="1974">1974</option>
<option value="1973">1973</option>
<option value="1972">1972</option>
<option value="1971">1971</option>
<option value="1970">1970</option>
<option value="1969">1969</option>
<option value="1968">1968</option>
<option value="1967">1967</option>
<option value="1966">1966</option>
<option value="1965">1965</option>
<option value="1964">1964</option>
<option value="1963">1963</option>
<option value="1962">1962</option>
<option value="1961">1961</option>
<option value="1960">1960</option>
<option value="1959">1959</option>
<option value="1958">1958</option>
<option value="1957">1957</option>
<option value="1956">1956</option>
<option value="1955">1955</option>
<option value="1954">1954</option>
<option value="1953">1953</option>
<option value="1952">1952</option>
<option value="1951">1951</option>
<option value="1950">1950</option>

</select>
<p><p><p>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<input type="submit"value="SUBMIT"size=20">
 </form>
   <% session.removeAttribute("flag"); %>

</body>
</html>




