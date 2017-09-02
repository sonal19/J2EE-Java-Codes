/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author ACER
 */
public class SendMail extends HttpServlet {
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

       String eid=request.getParameter("id2");
       String ans=request.getParameter("id1");
           String to=eid;//change accordingly

//Get the session object
  Properties props = new Properties();
  props.put("mail.smtp.host", "smtp.gmail.com");
  props.put("mail.smtp.socketFactory.port", "465");
  props.put("mail.smtp.socketFactory.class",
        	"javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.port", "465");

  Session session = Session.getDefaultInstance(props,
   new javax.mail.Authenticator() {
            @Override
   protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication("tom19912009@gmail.com","9958291861");//change accordingly
   }
  });

//compose message
  try {
   MimeMessage message = new MimeMessage(session);
   message.setFrom(new InternetAddress("tom19912009@gmail.com"));//change accordingly
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
   message.setSubject("Password");
   message.setText("HI YOUR PASSWORD IS---- "+ans+"----PLEASE LOGIN AGAIN AND ENJOY SHOPPING");

   //send message
   Transport.send(message);

   out.println("message sent successfully");
   out.println("<a href=loginform.jsp>GO BACK</a>");


  } catch (MessagingException e) {throw new RuntimeException(e);}
        }
    } 

   


