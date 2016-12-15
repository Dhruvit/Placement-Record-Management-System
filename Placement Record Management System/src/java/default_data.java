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
public class default_data extends HttpServlet {

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
        foo.Student student = (Student)session.getAttribute("student");
        
        //get userid
        String userid = student.getUserid();
        
        String readOnly = "readonly"; 
        String readOff = null;
        String disabled = "disabled";
        String disabledno = null;
        String day = null;
        String month = null;
        String year = null;
        RequestDispatcher view = request.getRequestDispatcher("Student_details.jsp");
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
            
                con = DriverManager.getConnection(url1,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                
                //if(approve=1) then don't modify data and if(submit=1) then don't modify data
                
                //get data from studentdetails table
                String query = "select * from studentdetails where StudentId='"+userid+"'";
                 
                 rs = stmt.executeQuery(query);
                 
                 while(rs.next())
                 {
                    String btech =Float.toString(rs.getFloat("BTech_CPI"));
                    String passbtech = Integer.toString(rs.getInt("PassBTech"));
                    String twelve =Float.toString(rs.getFloat("Twelve"));
                    String passtwelve = Integer.toString(rs.getInt("PassTwelve"));
                    String ten =Float.toString(rs.getFloat("Ten"));
                    String passten = Integer.toString(rs.getInt("PassTen"));
                    
                    if(rs.getInt("Submit")==1)
                    {
                        out.print("s1");
                        String dob = rs.getString("DateOfBirth");
                        out.print("s2");
                        if(dob != null)
                        {
                        day = dob.substring(0, 2);
                        month = dob.substring(3, 5);
                        year = dob.substring(6,10);
                        
                        }
                        out.println(day+" "+month+" "+year);
                        out.print("s3");
                        String[] record = {rs.getString("StudentName"),rs.getString("FatherName"),rs.getString("MotherName"),rs.getString("Gender"),rs.getString("DateOfBirth"),rs.getString("EmailId"),rs.getString("Branch"),rs.getString("Address"),btech,passbtech,twelve,passtwelve,ten,passten,readOnly,disabled,day,month,year,Integer.toString(rs.getInt("Interested")),rs.getString("Subject")};
                        request.setAttribute("studentdatarecord", record);
                    }
                    else if(rs.getInt("Approve")==1)
                    {
                        out.print("s1");
                        String dob = rs.getString("DateOfBirth");
                        out.print("s2");
                        if(dob != null)
                        {
                        day = dob.substring(0, 2);
                        month = dob.substring(3, 5);
                        year = dob.substring(6,10);
                        }
                        out.print("s3");
                        out.println(day+" "+month+" "+year);
                    String[] record = {rs.getString("StudentName"),rs.getString("FatherName"),rs.getString("MotherName"),rs.getString("Gender"),rs.getString("DateOfBirth"),rs.getString("EmailId"),rs.getString("Branch"),rs.getString("Address"),btech,passbtech,twelve,passtwelve,ten,passten,readOnly,disabled,day,month,year,Integer.toString(rs.getInt("Interested")),rs.getString("Subject")};
                    request.setAttribute("studentdatarecord", record);    
                    
                    }
                    else
                    {
                        out.print("s1");
                        String dob = rs.getString("DateOfBirth");
                        out.print("s2");
                        if(dob != null)
                        {
                        day = dob.substring(0, 2);
                        month = dob.substring(3, 5);
                        year = dob.substring(6,10);
                        }
                        out.print("s3");
                        out.println(day+" "+month+" "+year);
                    String[] record = {rs.getString("StudentName"),rs.getString("FatherName"),rs.getString("MotherName"),rs.getString("Gender"),rs.getString("DateOfBirth"),rs.getString("EmailId"),rs.getString("Branch"),rs.getString("Address"),btech,passbtech,twelve,passtwelve,ten,passten,readOff,disabledno,day,month,year,Integer.toString(rs.getInt("Interested")),rs.getString("Subject")};
                    request.setAttribute("studentdatarecord", record);
                    }
                 
                 }
                
                 view.forward(request, response);
                
            }catch(Exception e)
            {
                out.println("Exception in default_data::"+e);
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
