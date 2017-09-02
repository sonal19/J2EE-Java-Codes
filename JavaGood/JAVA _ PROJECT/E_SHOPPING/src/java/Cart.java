/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;


/**
 *
 * @author ACER
 */
public class Cart extends HttpServlet {

      @Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();

//double total_price=0;
String x1=req.getParameter("id1");
String x2=req.getParameter("id2");
        String x3=req.getParameter("id3");
        String x4=req.getParameter("id4");
        String x5=req.getParameter("id5");
        String x6=req.getParameter("id6");
        /**/

try{
/*
Statement st=con.createStatement();
int rs=st.executeUpdate("insert into orderdetail values('"+x1+"','"+x2+"','"+x2+"','"+x4+"','"+x5+"','"+x6+"')");*/

/*

//out.println(sql);
out.println(st.execute());
//out.println(x1+x2+x3+x4+x5+x6);
//ResultSetMetaData rsmd=rs.getMetaData();
//ResultSet rs=st.executeQuery("select * from orderdetail");
//while(rs.next())
//{
//total_price+=rs.get(6);
//2open the same page------res.sendRedirect("");
//        }*/

    int i1=Integer.parseInt(x1.trim());
int i2=Integer.parseInt(x2.trim());
int i3=Integer.parseInt(x3.trim());
int i4=Integer.parseInt(x4.trim());
     int i6=Integer.parseInt(x6.trim());

out.println("x1 sports id = "+(i1+1));
out.println("x2 product id= "+(i2+1));
out.println("x3 bat id= "+(i3+1));
out.println("x4  bat item id= "+(i4+1));
out.println("x5  name= "+x5);
out.println("x6 price= "+(i6+1));


       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
String sql="insert into orderdetail_s values(?,?,?,?,?,?)";
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
}

}
