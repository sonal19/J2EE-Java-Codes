<html >

<body>
 <jsp:include page="afterloginheader.jsp"/>
    <jsp:include page="header.html"/>
    <jsp:include page="afterloginheader3.jsp"/>
    <br><br><br><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
    <p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
        
        <table width="1099" height="378" align="right"   ><tr><td>   
<img src="New Folder (3)/BAT/RBK.jpg" width="300" height="400" align="left">
<b><font size="+3" color="white">&nbsp;&nbsp;Reebok Legend English Willow Cricket Bat</font>

<ul><font size="+2" color="white">
<li>Brand: Reebk </li>
<li>Sport: Cricket </li>
<li>Warranty: Manufacturer's repair/replacement warranty against handle breakage</li>
<li>Color: (Subject to availability)</li>
<li>Size: SH</li></font>
</ul>

<p>&nbsp;</p>&nbsp;&nbsp;
<font color="red" size="+3">Rs 2099</font>
<br>
&nbsp;&nbsp;

<%@page import="java.sql.*"%>
  <%! int i1,i2,d1,d2,d3; 
      String s;%>    
<%
   try{
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 Connection con=DriverManager.getConnection("jdbc:odbc:mydata");		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from BAT where CBAT_NAME='Reebok Legend English Willow Cricket Bat'");
		while(rs.next())
              {
                  i1=rs.getInt(1); 
                   s=rs.getString(3);
                  i2=rs.getInt(6);
               
                }
                session.setAttribute("reebok",i1);
                 d1=(Integer)session.getAttribute("sport");
                 d2=(Integer)session.getAttribute("cricket");
                 d3=(Integer)session.getAttribute("bat");
                      }
catch(Exception ex){}

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
    <a href=dwnld.jsp?link=<%out.println(i1);%>><button>Download Image</button></a>
</td></tr></table>

</b><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>

<jsp:include page="footer.html"/>
 
</body>
</html>
 
