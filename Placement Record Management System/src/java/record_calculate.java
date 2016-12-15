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
public class record_calculate extends HttpServlet {

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
        Statement stmt,stmt1,stmt2 = null;
        PreparedStatement pmt = null;
        ResultSet rs,rs1,rs2 = null;
        
        
        PrintWriter out = response.getWriter();
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        
        java.util.List RecordList = new java.util.ArrayList();
        
        String[] branch = request.getParameterValues("branch");
        float aggregate = Float.parseFloat(request.getParameter("aggregate"));
        String blacklist = request.getParameter("blacklist");
        int approve = 1;
        
        
        RequestDispatcher view = request.getRequestDispatcher("display_student_record.jsp");
        
        String query = null;
        String query1 = null;
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
            
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                stmt2 = (Statement)con.createStatement();
                
                out.println(+aggregate+blacklist+approve);
                
                    if(blacklist.equals("remove"))
                    {
                        for(int i=0;i<branch.length;i++)
                        {
                            query = "select * from studentdetails where Branch='"+branch[i]+"' and BTech_CPI>='"+aggregate+"' and Approve='"+approve+"' and Blacklist='"+0+"'";
                            
                            rs = stmt.executeQuery(query);
                            
                            while(rs.next())
                            {
                                String userid1 = rs.getString("StudentId");
                                query1 = "select * from resume_info where StudentId='"+userid1+"'";
                                rs1 = stmt1.executeQuery(query1);
                                if(rs1.next())
                                {
                                    if((rs.getInt("SelectInPlacement")==0) && (rs.getInt("Interested")==1))
                                    {
                                    String path = "http://localhost:8080/Placement%20Record%20Management%20System/Resume/"+rs1.getString("ResumeName");
                                    String[] record = {rs.getString("StudentId"),rs.getString("StudentName"),rs.getString("EmailId"),rs.getString("Branch"),Float.toString(rs.getFloat("BTech_CPI")),path};
                                    RecordList.add(record);
                                    out.println(rs1.getString("ResumeName"));
                                    }
                                }
                            }
                        
                        }

                    }
                    else
                    {
                        for(int i=0;i<branch.length;i++)
                        {
                            query = "select * from studentdetails where Branch='"+branch[i]+"' and BTech_CPI>='"+ aggregate+"' and Approve='"+approve+"'";
                            
                            rs = stmt.executeQuery(query);
                            while(rs.next())
                            {
                                String userid1 = rs.getString("StudentId");
                                query1 = "select ResumeName from resume_info where StudentId='"+userid1+"'";
                                rs1 = stmt1.executeQuery(query1);
                                if(rs1.next())
                                {
                                    if((rs.getInt("SelectInPlacement")==0)  &&  (rs.getInt("Interested")==1))
                                    {
                                    out.println("s1");
                                    String path = "http://localhost:8080/Placement%20Record%20Management%20System/Resume/"+rs1.getString("ResumeName");
                                    String[] record = {rs.getString("StudentId"),rs.getString("StudentName"),rs.getString("EmailId"),rs.getString("Branch"),Float.toString(rs.getFloat("BTech_CPI")),path};
                                    RecordList.add(record);
                                    out.println(rs1.getString("ResumeName"));
                                    }
                                }
                            }
                            
                        }
                    }
                    
                    
                    
                    
                    
               
                request.setAttribute("recordlist", RecordList);
                
                out.println("finish");
                view.forward(request, response);
            }catch(Exception e)
            {
                out.println("Exception in record_calculate::"+e);
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
