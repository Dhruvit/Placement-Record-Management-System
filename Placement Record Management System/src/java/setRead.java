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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DHRUVIT
 */
public class setRead extends HttpServlet {

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
        
        String url = "jdbc:mysql://localhost/prms";
        String user_id="root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt,stmt1 = null;
        ResultSet rs = null;
        String query = null;
        PreparedStatement p = null;
        String query1 = null;
        
        response.setContentType("text/html;charset=UTF-8");
        
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        
        //get message number
        int mno = Integer.parseInt(request.getParameter("mgno"));
        int read =1;
        PrintWriter out = response.getWriter();
        
        
        RequestDispatcher view = request.getRequestDispatcher("displaymessage.jsp");
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
           
            out.println("no="+mno);
            try{
            
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                
                        //query = "update messagebox set Read=1 WHERE Id=?";
                        query = "update messagebox set Readupdate=1 WHERE Id='"+mno+"'";
                        int n = stmt.executeUpdate(query); 
                        if(n == 1)
                        {
                            query1 = "select * from messagebox where Id='"+mno+"'";
                            rs = stmt1.executeQuery(query1);
                            while(rs.next())
                            {
                            System.out.println("Update Successfully");
                            request.setAttribute("message", rs.getString("Message"));
                            view.forward(request, response);
                            }
                            
                        }
            }catch(Exception e)
            {
                out.println("Exception in setRead.java:::"+e);
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
