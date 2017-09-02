/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author computer
 */
@WebServlet(urlPatterns = {"/save"})
public class saveData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           try{

//Cookie c1=new Cookie("tom","007");
//res.addCookie(c1);
//out.println(uname+pass);

//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//Connection con=DriverManager.getConnection("jdbc:odbc:vishwaDSN");
Class.forName("com.mysql.jdbc.Driver");  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/test","root","vishav12345");  
  
Statement st=con.createStatement();

    
      String name=request.getParameter("name");
      String roll=request.getParameter("rn");
      String pgr=request.getParameter("pgr");
      String pref1=request.getParameter("pref1");
      String pref2=request.getParameter("pref2");
      String pref3=request.getParameter("pref3");
      String pref4=request.getParameter("pref4");
      String cgpa1=request.getParameter("cgpa1");
      String cgpa2=request.getParameter("cgpa2");
      String cgpa3=request.getParameter("cgpa3");
      String cgpa4=request.getParameter("cgpa4");
      
      st.execute("insert into TA values('"+name+"','"+roll+"','"+pgr+"','"+pref1+"','"+cgpa1+"','"+pref2+"','"+cgpa2+"','"+pref3+"','"+cgpa3+"','"+pref4+"','"+cgpa4+"')"); // insert first row into the 

     response.sendRedirect("selectTA.jsp");
     
}
catch(Exception e)
{out.println(e);

}
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
