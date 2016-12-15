/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import foo.Student;
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
public class add_placement_student extends HttpServlet {

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
        ResultSet rs = null;
        
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        
        String branch = request.getParameter("branch");
        String compant_name = request.getParameter("compant_name");
        String subject = request.getParameter("subject");
        String year = request.getParameter("year");
        String userid = request.getParameter("userid");
        
        String redirectURL1 = "http://localhost:8080/Placement%20Record%20Management%20System/add_placement_student.jsp";
        
        String query,query1,query2 = null;
        int select = 1;
        
        String activity = "Congratulation for Placement";
        String status = "Plz confirmed yor PLacement";
        
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
                
                con = DriverManager.getConnection(url1,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                stmt2 = (Statement)con.createStatement();
                
                query="insert into Placement_Box values('"+userid+"','"+compant_name+"','"+branch+"','"+year+"','"+subject+"')";
                
                query1="update studentdetails set SelectInPlacement=? where StudentId=?";
                pmt = con.prepareStatement(query1);
                pmt.setInt(1, select);
                pmt.setString(2,userid);
                
                int m=pmt.executeUpdate();
                
                int n = stmt.executeUpdate(query);
                
                        //make status update Activity:  and  Status:Syudent can't modify data
                        query2 = "insert into activity_status_box values('"+userid+"','"+activity+"','"+status+"')";
                        
                        int q = stmt2.executeUpdate(query2);
                        if(n==1 && m==1 && q==1)
                        {
                            response.sendRedirect(redirectURL1); 
                        }
                
            
            }catch(Exception e)
            {
                out.println("Exception in add_placement_student:::"+e);
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
