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
public class seeStudentData extends HttpServlet {

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
        
        //get userid
        String userid1 = request.getParameter("userid");
        
        RequestDispatcher view = request.getRequestDispatcher("display_student_submit_data_record.jsp");
        
        String check = "checked";
        String select = "selected";
        
        try {
            
             try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
             
             try{
             
                 con = DriverManager.getConnection(url,user_id,user_pass);
                 stmt = (Statement)con.createStatement();
                 stmt1 = (Statement)con.createStatement();
                 
                 String query = "select * from studentdetails where StudentId='"+userid1+"'";
                 
                 rs = stmt.executeQuery(query);
                 
                 while(rs.next())
                 {
                 String btech =Float.toString(rs.getFloat("BTech_CPI"));
                 String passbtech = Integer.toString(rs.getInt("PassBTech"));
                 String twelve =Float.toString(rs.getFloat("Twelve"));
                 String passtwelve = Integer.toString(rs.getInt("PassTwelve"));
                 String ten =Float.toString(rs.getFloat("Ten"));
                 String passten = Integer.toString(rs.getInt("PassTen"));
                 String[] record = {rs.getString("StudentName"),rs.getString("FatherName"),rs.getString("MotherName"),rs.getString("Gender"),rs.getString("DateOfBirth"),rs.getString("EmailId"),rs.getString("Branch"),rs.getString("Address"),btech,passbtech,twelve,passtwelve,ten,passten,userid1,check,select};
                 
                 
                 
                 request.setAttribute("studentdatarecord", record);
                 
                 }
                
                 view.forward(request, response);
             }catch(Exception e)
             {
             out.println("Exception in seeStudentData:::"+e);
             }
             
            out.println(userid1);
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
