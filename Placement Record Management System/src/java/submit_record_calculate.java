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
public class submit_record_calculate extends HttpServlet {

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
        RequestDispatcher view = request.getRequestDispatcher("display_submit_record.jsp");
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        foo.Approver approver = (Approver)session.getAttribute("approver");
        
        //get userid
        String userid = approver.getUserid();
        
        java.util.List SubmitRecordList = new java.util.ArrayList();
        
        
        PrintWriter out = response.getWriter();
        try{
        
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
                
                String query1 = "select * from studentdetails where Branch='"+branch1+"' and Submit='"+1+"'";
                
                rs1 = stmt1.executeQuery(query1);
                
                
                
                if(rs1.next())
                {
                    do{
                        out.print("s1");
                        String btech =Float.toString(rs1.getFloat("BTech_CPI"));
                        String[] record = {rs1.getString("StudentId"),rs1.getString("StudentName"),rs1.getString("EmailId"),btech};
                        SubmitRecordList.add(record);
                            
                    
                    }while(rs1.next());
                                       
                    
                    request.setAttribute("submitrecordlist", SubmitRecordList); 
                    out.print("soon4");
                    
                }
                else
                {
                    out.print("soon6");
                    
                        String[] record = {null,null,null,null};
                        SubmitRecordList.add(record);
                    
                    request.setAttribute("submitrecordlist", SubmitRecordList); 
                    
                }
                
                
                
                view.forward(request, response);
            }catch(SQLException e)
            {
            out.println("SQLException in swami1::"+e);
            }
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
