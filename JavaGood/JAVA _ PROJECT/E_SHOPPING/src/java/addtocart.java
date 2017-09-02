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
public class addtocart extends HttpServlet {
   
      @Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();

ServletContext context=getServletConfig().getServletContext();
HttpSession session=req.getSession();
double total_price=0;
String x1=req.getParameter("d1");
String x2=req.getParameter("d2");
String x3=req.getParameter("d3");
String x4=req.getParameter("i1");
String x5=req.getParameter("s1");
String x6=req.getParameter("i1");
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:tomdsn");
Statement st=con.createStatement();
int i=st.executeUpdate("insert into orderdetail values('"+x1+"','"+x2+"',"
        + "'"+x3+"','"+x4+"','"+x5+"','"+x6+"')");

//ResultSetMetaData rsmd=rs.getMetaData();
ResultSet rs=st.executeQuery("select * from orderdetail");
while(rs.next())
{
total_price+=rs.getInt(6);
//2open the same page------res.sendRedirect("");
        }
    }
catch(Exception e)
{out.println(e);
}
}}
