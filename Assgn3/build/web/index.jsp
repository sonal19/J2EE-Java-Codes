

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="cyan">
WELCOME TO TA ALLOCATION SYSTEM <br><br>
<form action="save">
  <fieldset>
    <legend>TA ALLOCATION SYSTEM:</legend>
  Name: <input type="text" name="name" placeholder="name" /><br><br>
Roll Number: <input type="number" name="rn" placeholder="Roll number" /><br><br>
Program:  <br>

  <input type="radio" name="pgr" value="ug" checked> UG<br>
  <input type="radio" name="pgr" value="pg"> PG<br>
  <input type="radio" name="pgr" value="phd"> PhD  

<br><br>
Preferences <br>
Preference1: <input type="text" name="pref1" placeholder="p1" />&nbsp;&nbsp;&nbsp; CGPA: <input type="number" max="10" name="cgpa1"/>   <br><br>
Preference2: <input type="text" name="pref2" placeholder="p2" />&nbsp;&nbsp;&nbsp;CGPA: <input type="number" max="10" name="cgpa2"/>  <br><br>
Preference3: <input type="text" name="pref3" placeholder="p3" />&nbsp;&nbsp;&nbsp;CGPA: <input type="number" max="10" name="cgpa3"/>  <br><br>
Preference4: <input type="text" name="pref4" placeholder="p4" />&nbsp;&nbsp;&nbsp;CGPA: <input type="number" max="10" name="cgpa4"/>  <br><br>
<input type="submit" name="Submit"/><br>
  </fieldset>
</form>

   <%!String s;%>
    <%
  
 try{ 
    
   Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/test","root","vishav12345");  
  
Statement st=con.createStatement();



String sql = "CREATE TABLE TA" +
                   " (name VARCHAR(255), " + 
        "roll INTEGER not NULL, "+            
        "prog VARCHAR(255), " + 
                   " pref1 VARCHAR(255), " + 
        "cgpa1 VARCHAR(255), " +
        " pref2 VARCHAR(255), " +
       "cgpa2 VARCHAR(255), " + 
        " pref3 VARCHAR(255), " + 
        "cgpa3 VARCHAR(255), " + 
        " pref4 VARCHAR(255), " + 
        "cgpa4 VARCHAR(255), " + 
                   " PRIMARY KEY ( roll ))"; 

      st.execute(sql);
      
  }
catch(Exception e){

}

%>
    
    </body>
</html>

