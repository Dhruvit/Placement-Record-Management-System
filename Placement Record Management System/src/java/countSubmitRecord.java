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
public class countSubmitRecord extends HttpServlet {

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
        Statement stmt,stmt1 = null;
        PreparedStatement pmt = null;
        ResultSet rs,rs1 = null;
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        foo.Approver approver = (Approver)session.getAttribute("approver");
        
        //get userid
        String userid = approver.getUserid();
        
        //get object of CountRecord Object
        foo.CountRecord countrecord = new foo.CountRecord();
        
        int count = 0;
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
                
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                
                String query = "select * from login_table where userid='"+userid+"'";
                
                rs = stmt.executeQuery(query);
                out.print(userid);
                String branch1 = null;
                while(rs.next())
                {
                    branch1 = rs.getString("branch");
                }
                out.println("branch::"+branch1);
                
                String query1 = "select * from studentdetails where Branch='"+branch1+"' and Submit='"+1+"'";
                out.print("soon3");
                rs1 = stmt1.executeQuery(query1);
                
                String redirectURL1 = "http://localhost:8080/Placement%20Record%20Management%20System/welcomeApprover.jsp";
                out.print("soon5");
                if(rs1.next())
                {
                    do{
                        out.print("s1");
                        count++;
                    
                    }while(rs1.next());
                                       
                    countrecord.setCount(count);
                    session.setAttribute("countrecord", countrecord); 
                    out.print(count);
                    response.sendRedirect(redirectURL1);
                }
                else
                {
                    out.print("soon6");
                    count = 0;
                    countrecord.setCount(count);
                    session.setAttribute("countrecord", countrecord);
                    response.sendRedirect(redirectURL1);
                }
                
            
            }catch(Exception e)
            {
                out.println("Exception in countSubmitRecord:::"+e);
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
