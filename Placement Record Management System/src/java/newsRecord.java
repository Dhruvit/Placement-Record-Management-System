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
public class newsRecord extends HttpServlet {

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
        PreparedStatement pmt = null;
        ResultSet rs,rs1 = null;
        
        java.util.List TPOUpdate = new java.util.ArrayList();
        java.util.List PlacementNews = new java.util.ArrayList();
        PrintWriter out = response.getWriter();
        
        RequestDispatcher view = request.getRequestDispatcher("news.jsp");
        try {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                
                out.println("2");
                String query = "select * from tpo_update";
                String query1 = "select * from placement_news";
                
                rs = stmt.executeQuery(query);
                rs1 = stmt1.executeQuery(query1);
                out.println("1");
                if(rs.next())
                {
                    do{
                    
                        String[] record = {rs.getString("Subject"),rs.getString("news"),rs.getString("ref_link")};
                        TPOUpdate.add(record);
                        
                    }while(rs.next());
                    
                    request.setAttribute("tpoupdate", TPOUpdate);
                    
                }
                else
                {
                    String[] record = {null,null,null};
                    TPOUpdate.add(record);
                
                    request.setAttribute("tpoupdate", TPOUpdate);
                }
                
                if(rs1.next())
                {
                    do{
                        
                        String[] record = {rs1.getString("CompanyName"),Integer.toString(rs1.getInt("NoOfStudent")),rs1.getString("News")};
                        PlacementNews.add(record);
                        
                    }while(rs1.next());
                            
                    request.setAttribute("placementnews", PlacementNews);
                
                }
                else
                {
                    String[] record = {null,null,null};
                    PlacementNews.add(record);
                    
                    request.setAttribute("placementnews", PlacementNews);
                }
                out.print("3");
                
                view.forward(request, response);
            
            }catch(Exception e)
            {
                out.println("Exception in newsRecord:::"+e);
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
