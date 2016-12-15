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
public class status_record_calculate extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "jdbc:mysql://localhost/prms";
        String user_id="root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt,stmt1 = null;
        PreparedStatement pmt = null;
        ResultSet rs,rs1 = null;
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        foo.Student student = (Student)session.getAttribute("student");
        
        //get userid
        String userid = student.getUserid();
        
        RequestDispatcher view = request.getRequestDispatcher("student_status.jsp");
        
        java.util.List StatusRecord = new java.util.ArrayList();
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
            
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                
                String query = "select * from activity_status_box where StudentId='"+userid+"'";
                
                rs = stmt.executeQuery(query);
                while(rs.next())
                {
                    String[] record = {rs.getString("Activity"),rs.getString("Status")};
                    StatusRecord.add(record);
                
                }
                
                request.setAttribute("statusrecord", StatusRecord);
                
                view.forward(request, response);
                
                
                
            }catch(Exception e)
            {
                out.println("Exception in status_record_calculate:::"+e);
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
