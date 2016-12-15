/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DHRUVIT
 */
public class loginTable extends HttpServlet {

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
        String url = "jdbc:mysql://localhost/prms";
        String user_id="root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt = null;
        Statement stmt1,stmt2 = null;
        ResultSet rs = null;
        
        String activity = "Candidate Registration";
        String status = "Registered";
        try{
            
             try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
                
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                stmt2 = (Statement)con.createStatement();
                
            //insert student login details in Login Details table
          
            String userid = request.getParameter("userid");
            String password = request.getParameter("password1");
            String branch = request.getParameter("branch");
            String user_type = request.getParameter("user_type");
       
            String redirectURL = "http://localhost:8080/Placement%20Record%20Management%20System/welcome.jsp";
            
            String query = "insert into login_table values('"+userid+"','"+password+"','"+branch+"','"+user_type+"')";   
           
            int n = stmt.executeUpdate(query);
            
            if(user_type.equals("Student"))
            {
                
                //make entery in studentdetails table if user is student
                String query2 = "insert into studentdetails (StudentId,Branch) values ('"+userid+"','"+branch+"')";
            
                int q = stmt2.executeUpdate(query2);
                //make status update Activity:Candidate Registration  and  Status:Registered
                String query1 = "insert into activity_status_box values('"+userid+"','"+activity+"','"+status+"')";
            
                int m = stmt1.executeUpdate(query1);
                if(n==1 && m==1 && q==1)
                {
                    response.sendRedirect(redirectURL); 
                }
            }
            
            if(n==1)
            {
                response.sendRedirect(redirectURL); 
            }
            
            }catch(Exception e)
            {out.println("Exception  nnnnnn:::" + e);}
            
        }finally{
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
