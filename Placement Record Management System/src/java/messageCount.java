/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import foo.*;
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author DHRUVIT
 */
public class messageCount extends HttpServlet {

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
        
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher view = request.getRequestDispatcher("messageBox.jsp");
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        foo.Student student = (Student)session.getAttribute("student");
        
        //get student userid
        String userid = student.getUserid();
        
        java.util.List MessageBox = new java.util.ArrayList();
        
        int count = 0;
        int no = 0;
        int read = 0;
        int unread = 0;
        
        String colour = null;
        
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                
                rs = stmt.executeQuery("select count(*) from MessageBox where StudentId='"+userid+"'");
                while(rs.next())
                {
                    count = rs.getInt(1);
                }
                
                rs1 = stmt1.executeQuery("select * from MessageBox where StudentId='"+userid+"'");
                
                if(rs1.next())
                {
                    do{
                        if(rs1.getInt("Readupdate")==0)
                        {
                            unread++;
                            colour = "lemonchiffon";
                        }
                        else
                        {
                            read++;
                            colour = "#CCCCCC";
                        }
                        no++;
                        String subject = rs1.getString("Subject")+"...";
                        String no1 = Integer.toString(rs1.getInt("Id"));
                        String[] record = {Integer.toString(no),no1,subject,rs1.getString("From"),rs1.getString("Date"),colour};
                        MessageBox.add(record);
                            
                    
                    }while(rs1.next());
                   
                    request.setAttribute("messagebox", MessageBox); 
                    
                    
                }
                else
                {       colour =  "lemonchiffon";
                        String[] record = {null,null,null,null,null};
                        MessageBox.add(record);
                    
                        request.setAttribute("messagebox", MessageBox);
                    
                }
                
                request.setAttribute("totalmsg", count);
                request.setAttribute("totalunread",unread );
                
                view.forward(request, response);
            }catch(SQLException e)
            {
            out.println("SQLException in swami1::"+e);
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
