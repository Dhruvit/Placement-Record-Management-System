/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.*;


import java.util.ArrayList;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author DHRUVIT
 */
public class EmailServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ArrayList userid = new ArrayList();
    String login = null;
    String password = null;
    public void init()
    {
        userid = (ArrayList)getServletContext().getAttribute("emailidlist");
        login = (String)getServletContext().getInitParameter("login");
        password = (String)getServletContext().getInitParameter("password");
    }
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        
        //String from = request.getParameter("from");
        //String[] to = null;
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        
        RequestDispatcher view = request.getRequestDispatcher("studentRecord.jsp");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        
        try{
            
            Properties props = new Properties();
            props.setProperty("mail.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.starttls.enable", "true");
            
            Authenticator auth = new SMTPAuthenticator(login, password);
           
            
            Session session = Session.getInstance(props,auth);
            
            MimeMessage msg = new MimeMessage(session);
            msg.setText(message);
            msg.setSubject(subject);
            msg.setFrom(new InternetAddress(login));
            
            
            InternetAddress[] toAddresses = new InternetAddress[userid.size()];
            for(int i=0;i<userid.size();i++)
            {
                String str = (String)userid.get(i);
                System.out.println("Email:;"+str);
                toAddresses[i] = new InternetAddress(str);
            }
            msg.addRecipients(Message.RecipientType.TO,toAddresses);
            Transport.send(msg);
            System.out.println("sent successfully");
            
        } catch(Exception ex){
            System.out.println("MessagingException in EmailServlet::"+ex);
            
            String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Sent not successfully. Plz Check email id')</script></body></html>";
            request.setAttribute("alert", ALERT);
            
            view.forward(request, response);
        }
            
            try{
               
                String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Sent successfully')</script></body></html>";
                request.setAttribute("alert", ALERT);
                view.forward(request, response);
                
            }finally{out.close();}
           
            
        }
      
   
    
    
    private class SMTPAuthenticator extends Authenticator {

        private PasswordAuthentication authentication;

        public SMTPAuthenticator(String login, String password) {
            authentication = new PasswordAuthentication(login, password);
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return authentication;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
