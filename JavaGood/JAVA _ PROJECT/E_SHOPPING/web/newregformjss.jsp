<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
        <!--
function checkName(a){
if(a.value=="abc"||a.value=="xyz"||a.value=="abcxyz"||a.value=="xyzabc"||a.value==" "){
a.value="";
alert("Invalid Name");
return false;
}
return true;
}



function passValid(){
    var p1=document.cf.pass1.value;
    var p2=document.cf.pass2.value;
    if(p1!=p2){
        alert("Sorry, your confirmation password or prefer password is not same");
        return false;
    }
  return true;
}

function sexValid(){
    if (!document.cf.sex[0].checked && !document.cf.sex[1].checked){
    alert("Please Select Sex");
    return false;
    }
    return true;
}
//function chckbox(){
  //  if (!document.cf.check.checked){
    //alert("Please Read Terms and Conditions and then Accept it.");
    //return false;
    //}
    //return true;
//}

function emailValid(){
    var e=document.cf.email.value;
    var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	if(e.match(emailExp)){
        }else{
            alert("Please enter valid email id");
            return false;
        }
        return true;
}
function validate(frm) {
        if (frm.checkbox.checked==false)
    {
        alert("Please agree to our Terms and Conditions.");
        return false;
    }
}
    function checkField() {
          var num = document.cf.elements.length;
          var validFlag = true;
          for (var i=0; i<num; i++) {
              if(i==4){
               if(document.cf.age.value=="0"){

                   alert("Please enter your age");
                   validFlag=false;
               }
               if(document.cf.caq.value=="0"){

                   alert("Please enter your Security Question");
                   validFlag=false;
               }
              }else{

               if (document.cf.elements[i].value == null || document.cf.elements[i].value == "" || document.cf.elements[i].value=="0"){
                    validFlag = false;
                    alert("The " + document.cf.elements[i].name + " field is blank.")
                    break ;
               }
           }

          }
          return validFlag;
     }

function formValidate(){
    if(checkField()){
        if(passValid()){
            if(sexValid()){
                 if(passValid()){
                     if(validate(frm)){
                 }
                return true;
                }
            }
        }
    }
    return false;
}
//-->
</script>
    </head>

   <style type="text/css">
#my
{
width:400px;
height:960px;
background-image:url("images/i14.jpg");
-webkit-animation:tom 5s;
}

@-webkit-keyframes tom
{
from {background-image:url("images/i3.jpg");}
to {background-image:url("images/i4.jpg");}}
}



    </style>

    <body background="images/i16.jpg">
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
                        &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </blockquote></blockquote></blockquote></td>


<td><form  name="cf" action="captcha.jsp" method="get" onsubmit="return formValidate()">
                        <div id="my">
         <h1><font face="comic sans ms" color="white"><b>WELCOME TO REGISTER PAGE</b></h1>

          <font face="comic sans ms" color="white" size="4">
       



    <i><u>Simple form to register, just one step ahead!</u></i>

<br><br>
First Name:<input type=text name="FirstName" onchange="checkName(document.cf.first)" onkeydown="welcome.innerHTML='Welcome '+first.value"/>

<p>Last Name:<input type=text name="LastName" onchange="checkName(document.cf.last)"/>

<p>
Desired Login name:<input type="text" maxlength="10" size="30" name="dln">
    &nbsp;&nbsp;&nbsp;<font color="white">@teemkart.com</font><p><p>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%// String un=request.getParameter("dln");
 //out.println("<a href=availibility.jsp?uname="+un+">open</a>");
//if(un==null){}
//else
  // {
    //out.println("<a href=availibility.jsp?uname="+un+"><input type=submit value=check availability/></a>");
    //}
%>
<p>

<p>Sex:<input type="radio" name="sex" value="male"/>Male
<input type="radio" name="sex" value="female"/>Female

<p>Age:
        <select name="age">
            <option value="0">Age</option>
            <option>above 18</option>
            <option>above 30</option>
            <option>above 50</option>
            <option>above 60</option>
        </select>

<p> Email Address:<input type="text" name="email" onchange="emailValid()"/>

<p>Delivering Address:<input type="text" name="deliver" onchange="checkName(document.cf.deliver)"/>

<p>Prefer Password:<input type=password name="pass1"/>

<p>Confirm Password:<input type=password name="pass2"/>
<p><p>
    <i><u>If you forget Password below question will help you?</u></i>
<p><p>

Security question: <select name="caq">

<option value="0">Choose a Question <option>Mother's name? <option>Father's name? <option>Mobile number? <option>Best friend?  <option>Vehical number?

<option>Pet name?

</select><p><p>

&nbsp;&nbsp;<input type="text"value="Enter your own Answer" maxlength="50" size=50" name="answer"><p>


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

</select><p><p>

Location:
<select name="country">

<option>Australia <option>Japan <option>Germany <option>France  <option>India <option>Pakisthan <option>Canada <option>London

<option>South Africa  <option>Indonasia <option>Boston <option>Russia

</select><p><p><p><p>
    <textarea readonly cols="75" rows="25">

Terms of Services: Teemkart Terms of Service

Welcome to Teemkart

1. Your relationship with Teemkart

1.1 Your use of Teemkart products, software, services and web sites (referred to collectively as the “Services” in this
document and excluding any services provided to you by Teemkart under a separate written agreement) is subject
	to the terms of a legal agreement between you and Teemkart. “Teemkart” means Teemkart Inc.

1.2 Unless otherwise agreed in writing with Teemkart, your agreement with Teemkart will always include, at a minimum,
the terms and conditions set out in this document. These are referred to below as the “Universal Terms”.

1.3 Your agreement with Teemkart will also include the terms of any Legal Notices applicable to the Services,
in addition to the Universal Terms. All of these are referred to below as the “Additional Terms”.

1.4 The Universal Terms, together with the Additional Terms, form a legally binding agreement between you and
Teemkart in relation to your use of the Services. It is important that you take the time to read them carefully.

1.5 If there is any contradiction between what the Additional Terms say and what the Universal Terms say, then
the Additional Terms shall take precedence in relation to that Service.

2. Accepting the Terms

2.1 In order to use the Services, you must first agree to the Terms. You may not use the Services if you do
not accept the Terms.

</textarea>

<p><p>
<input type="checkbox" name="checkbox" id="checkbox" value="1">I accept the all Terms of Service<br><br>

<center>
<input type="submit" value="I accept. Create my Account" size=20">


</div>
</form> </td></tr></table>

<%@include file="footer.html" %>
    </body>
</html>
