/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import foo.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.mail.Session;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author DHRUVIT
 */
public class sendMessage extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String url1 = "jdbc:mysql://localhost/prms";
        String user_id="root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt,stmt1,stmt2 = null;
        PreparedStatement pmt = null;
        ResultSet rs,rs2 = null;
        
         //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        
        
        foo.Approver approve = (Approver)session.getAttribute("approver"); 
        
        //get userid of student
        String st_userid = request.getParameter("userid");
        
        //get userid of approver
        String ap_userid = approve.getUserid();
        
        //get Message subject
        String subject = request.getParameter("subject");
        
        //get Message
        String msg = request.getParameter("message");
        
        //gate Current Date form System
        Calendar cal = new GregorianCalendar();
        String mm = Integer.toString(cal.get(Calendar.MONTH));
        String dd = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String yyyy = Integer.toString(cal.get(Calendar.YEAR));
        
        String date = dd+"/"+mm+"/"+yyyy;
        
        String from = null;
        
        int read = 0;
        
        RequestDispatcher view = request.getRequestDispatcher("sendMessageToStudent.jsp");
        try {
            
            out.println("Msg::"+msg);
            out.println("Date::"+date+st_userid+ap_userid);
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
            
                con = DriverManager.getConnection(url1,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                stmt2 = (Statement)con.createStatement();
                
                rs2 = stmt2.executeQuery("select count(*) from MessageBox");
                int no =0;
                while(rs2.next())
                {
                    no = rs2.getInt(1);
                }
                int next = no+1;
                String query = "select user_type from login_table where userid='"+ap_userid+"'";
                rs = stmt.executeQuery(query);
                while(rs.next())
                {
                    from = rs.getString("user_type");
                }
                
                String query1 = "insert into MessageBox values('"+next+"','"+st_userid+"','"+subject+"','"+msg+"','"+from+"','"+date+"','"+read+"')";
                int n = stmt1.executeUpdate(query1);
                
                if(n==1)
                {
                    String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Message Sent Successfully')</script></body></html>";
                    request.setAttribute("alert", ALERT);
            
                    view.forward(request, response);
                }
                
            }catch(Exception e)
            {
                out.println("Exception in sendMessage ::" +e);
            }
        } finally {            
            out.close();
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
