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
public class setnotApprove extends HttpServlet {

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
       
        //get userid
        String userid = request.getParameter("userid");
        int m = 0;
        int approve = 0;
        int submit = 0;
        String activity = "TPO Approval";
        String activity1 = "Upload resume";
        String activity2 = "Wrong Data Submit";
        String status2 = "Modify and Submit";
        String query2 = null;
        
        RequestDispatcher view = request.getRequestDispatcher("display_student_submit_data_record.jsp");
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
                
                con = DriverManager.getConnection(url1,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                
                String query = "update studentdetails set Approve=? and Submit=? where StudentId=?";
                pmt = con.prepareStatement(query);
                pmt.setInt(1, approve);
                pmt.setInt(2, submit);
                pmt.setString(3, userid);
                int n=pmt.executeUpdate();
                
                String query3 = "insert into activity_status_box values('"+userid+"','"+activity2+"','"+status2+"')";
                int q = stmt1.executeUpdate(query2); 
                
                //search whether status already available....if yes then delete status
                String query1 = "select * from activity_status_box where StudentId='"+userid+"'";
                rs = stmt.executeQuery(query1);
                
                while(rs.next())
                {
                    if(rs.getString("Activity")==activity || rs.getString("Activity")==activity1)
                    {
                        if(rs.getString("Activity")==activity)
                        {
                        query2 = "delete from activity_status_box where StudentId='"+userid+"' and Activity='"+activity+"'";
                        }
                        else
                        {
                        query2 = "delete from activity_status_box where StudentId='"+userid+"' and Activity='"+activity1+"'";
                        }
                        
                        m = stmt1.executeUpdate(query2);
                        
                        if(n==1 && m==1)
                        {
                            String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Student Data not Approved successfully')</script></body></html>";
                            request.setAttribute("alert", ALERT);
            
                            view.forward(request, response);                  
                        }
                    }
                }
                
                if(n==1 && q==1)
                {
                    String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Student Data not Approved successfully')</script></body></html>";
                    request.setAttribute("alert", ALERT);
            
                    view.forward(request, response);                  
                }
            
            }catch(Exception e)
            {
                out.println("Exception in setApprove::"+e);
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
