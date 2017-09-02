
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;



public class regvalidate extends HttpServlet {


    @Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();


String s1=req.getParameter("f");
String s2=req.getParameter("l");
String s3=req.getParameter("dln");
String s4=req.getParameter("pass");
String s5=req.getParameter("cpass");

HttpSession session=req.getSession();

try{

//Cookie c1=new Cookie("tom","007");
//res.addCookie(c1);
//out.println(uname+pass);

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:tomdsn");
Statement st=con.createStatement();

//String s1="select * from login where uname='"+uname+"' and pass='" +pass+"'";
//out.println(s1);

/*ResultSet rs=st.executeQuery("select * from login where uname='"+uname+"' and pass='" +pass+"'");
if(rs.next())
{
     session.setAttribute("f","valid");
     context.setAttribute("name",uname);
      res.sendRedirect("loginsuccessful.jsp");
out.println("Going to go1");

//res.sendRedirect("go1");
//res.sendRedirect("gov3");
}
else {
    session.setAttribute("flag","invalid");

    context.setAttribute("name",uname);
   // Cookie c[]= new Cookie[1];
//c[0]=new Cookie("uname",uname);
//res.addCookie(c[0]);
    //out.println("<FORM METHOD=POST ACTION=>");
    //out.println("<input type=hidden name=unm value="+uname+">");
   res.sendRedirect("loginform.jsp");
   // out.println("YOU HAVE ENTERED WRONG PASSWORD");
   //out.println("<a href=wrongpass.jsp?uname="+uname+"><font color=white size=4>Forgot password</font>");
    //out.println("<a href=sendpass.jsp?uname="+uname+">gooo");

//out.println("Going to go2");
}*/
}
catch(Exception e)
{out.println(e);
}
}
}

