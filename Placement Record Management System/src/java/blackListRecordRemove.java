/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author DHRUVIT
 */
public class blackListRecordRemove extends HttpServlet {

       String url = "jdbc:mysql://localhost/prms";
        String user_id="root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt = null;
        ResultSet rs = null;
        String query = null;
        PreparedStatement p = null;
        
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String userid = request.getParameter("userid");
        String branch = request.getParameter("branch");
        RequestDispatcher view = request.getRequestDispatcher("remove_blackList_student.jsp");
        
        try{
             try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
             
             try{
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
             
                        query = "update studentdetails set Blacklist = 0 WHERE StudentId = ?";
                        p =(PreparedStatement)con.prepareStatement(query);
                        p.setString(1, userid);
                        int n = p.executeUpdate();
                        if(n == 1)
                        {
                            System.out.println("Remove Successfully");
                            
                        }
             }
             catch(SQLException e)
             {
                 System.out.println("error in blacklistrecordadd::"+e);
             }
             
            
             view.forward(request, response);
        }
        finally
                {out.close();}
        
        
        
        
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
