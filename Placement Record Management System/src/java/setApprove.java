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
import javax.mail.Session;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author DHRUVIT
 */
public class setApprove extends HttpServlet {

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
        Statement stmt,stmt1 = null;
        PreparedStatement pmt = null;
        ResultSet rs = null;
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        
        String userid = request.getParameter("userid");
        int approve = 1;
        int submit = 0;
        String activity = "TPO Approval";
        String status = "TPO Approved";
        
        String activity1 = "Upload resume";
        String status1 = "Yes";
        
        RequestDispatcher view = request.getRequestDispatcher("submit_record_calculate");
        
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
                
                con = DriverManager.getConnection(url1,user_id,user_pass);
                stmt1 = (Statement)con.createStatement();
                stmt = (Statement)con.createStatement();
                
                String query = "update studentdetails set Approve='"+approve+"',Submit='"+submit+"' where StudentId='"+userid+"'";
                pmt = con.prepareStatement(query);
                int n=pmt.executeUpdate();
                
                //make status update Activity:TPO Approval  and  Status:TPO Approved
                String query1 = "insert into activity_status_box values('"+userid+"','"+activity+"','"+status+"')";
                
                //make status update Activity:Upload resume  and  Status:Yes
                String query2 = "insert into activity_status_box values('"+userid+"','"+activity1+"','"+status1+"')";
                
                int q = stmt.executeUpdate(query2);
                int m = stmt1.executeUpdate(query1);
                
                if(n==1 && m==1 && q==1)
                {
                    String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Student Data Successfully Approved')</script></body></html>";
                    request.setAttribute("alert", ALERT);
            
                    view.forward(request, response);                    
                }
            
            }catch(Exception e)
            {
                out.println("Exception in setApprove::"+e);
            }
            out.println(userid);
            
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
