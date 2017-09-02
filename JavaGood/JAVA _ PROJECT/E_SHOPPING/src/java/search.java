import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;



public class search extends HttpServlet {


    @Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
//int i;
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<html><body  background =images/i3.jpg>");
//out.println("<form method=post>");

String txt=req.getParameter("SEARCH");

String s="select sname,slink from search where sname like '%"+txt+"%'";
ServletContext context=getServletConfig().getServletContext();
try{
//out.println(txt+s);
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:mydata");
Statement st=con.createStatement();
//http://localhost:8085/E_SHOPPING/index.jsp
//if(txt.startsWith("select"))
//{
String s1;
       s1=(String)context.getAttribute("f1");

//out.println(s1);
ResultSet rs=st.executeQuery(s);

out.println("<center>");

 if(s1==null)
            {
  out.println("<center><h1><font color=red><u><u><b>PLEASE LOGIN ....<BR><br> AFTER LOGIN YOU CAN SEARCH....<br><BR>"
          + "SORRY FOR THIS....<br><br><br>GO BACK....<br></u></u></b></font></h1></center>");
 out.println("<a href=javascript:history.go(-1)><button>--GO BACK--</button></a></center> ");

 }
       else{ if(s1.equals("valid1"))
 {
  out.println("<center>");
out.println("<h1><font color=red><u><u><b>WELCOME SEARCH TOOL</u></u></b></font></h1></center>");

     out.println("<table border=3 cellspacing=2 cellpadding=2>");

while(rs.next())
{

out.println("<tr>");
out.println("<td>");
out.println("<font color=yellow face=comic sans ms size=5><b>"+rs.getString(1)+"</b></font>");
out.println("</td>");
out.println("<td>");
out.println("<a href="+rs.getString(2)+"><img src=images/sopen.jpg height=30 width=100></a>");
out.println("</td>");
out.println("</tr>");
//out.println("<input type=hidden name=id value=" + id + ">");
}
out.println("</table>");
     }
        }
}
catch(Exception e)
{out.println(e);
 }
}

}
