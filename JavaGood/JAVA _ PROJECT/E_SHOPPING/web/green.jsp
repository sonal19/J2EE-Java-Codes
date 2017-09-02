<html>

<body
   <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br>
<br><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
    <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
        
        <table width="1099" height="378" align="right"   ><tr><td>   
<img src="New Folder (3)/SeG_CSY_1_M_1_2x.jpg" width="300" height="400" align="left">
<b><br><br><font size="+3" color="white">&nbsp;&nbsp;Cosco Cricket Tennis Balls  (Pack of 6)</font>

<ul><font size="+2" color="white">
<li>Brand: Cosco </li>
<li>Sport: Cricket </li>
<li>Warranty: NA</li>
<li>Color: (Subject to availability)</li>
</ul>

<p>&nbsp;</p>&nbsp;&nbsp;
<font color="red" size="+3">Rs 325</font>
<br>&nbsp;&nbsp;
<%@page import="java.sql.*"%>
      <%! int i1,i2,d1,d2,d3;
           String s;%>
<%
   
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from  BALL  where CBALL_ID=3");
		while(rs.next())
              {
                  i1=rs.getInt(1);
                    s=rs.getString(3);
                  i2=rs.getInt(6);                    
                }
                
                 d1=(Integer)session.getAttribute("sport");
                d2=(Integer)session.getAttribute("cricket");
                d3=(Integer)session.getAttribute("ball");

%>
<form action="Cart.jsp">
    <input type="hidden" name="id1" value="<%out.println(d1);%>"/>
    <input type="hidden" name="id2" value="<%out.println(d2);%>"/>
    <input type="hidden" name="id3" value="<%out.println(d3);%>"/>
    <input type="hidden" name="id4" value="<%out.println(i1);%>"/>
    <input type="hidden" name="id5" value="<%out.println(s);%>"/>
    <input type="hidden" name="id6" value="<%out.println(i2);%>"/>
    
    <input type="Submit" value="Add more item(s) to cart"/>      
</form>
    <a href=dwnldcball.jsp?link=<%out.println(i1);%>><button>Download Image</button></a>
</b></td></tr></table>
<p>&nbsp;</p>

</b><br><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>

    <jsp:include page="footer.html"/>
    
</body>
</html>
 