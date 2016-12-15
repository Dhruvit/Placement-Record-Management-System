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
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DHRUVIT
 */
public class setSubmit extends HttpServlet {

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
        Statement stmt,stmt1,stmt2 = null;
        PreparedStatement pmt = null;
        ResultSet rs = null;
        String str = request.getParameter("branch");
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        foo.Student student = (Student)session.getAttribute("student");
        
        //get userid
        String userid = student.getUserid();
        try {
            
             try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
             try{    
                 
                 con = DriverManager.getConnection(url1,user_id,user_pass);
                 stmt = (Statement)con.createStatement();
                 stmt1 = (Statement)con.createStatement();
                 stmt2 = (Statement)con.createStatement();
            
             //insert student data in student datbase
            String student_name = request.getParameter("student_name");
            String  father_name = request.getParameter("father_name");
            String  mother_name = request.getParameter("mother_name");    
            
            String gender = request.getParameter("gender");
            
            String day = request.getParameter("day");
            
            String month = request.getParameter("month");
            
            String year = request.getParameter("year");
            
            String email_id = request.getParameter("email_id");
            
            String branch = request.getParameter("branch");
                 
            String  address= request.getParameter("address");
            
            String  str4= request.getParameter("btech");
            double btech = Double.parseDouble(str4);
            String  str5= request.getParameter("pass_btech");
            int pass_btech = Integer.parseInt(str5);
            
            String  str6= request.getParameter("result_hsc");
            double result_hsc = Double.parseDouble(str6);
            String  str7= request.getParameter("pass_hsc");
            int pass_hsc = Integer.parseInt(str7);
            
            String  str8= request.getParameter("result_ssc");
            double result_ssc = Double.parseDouble(str8);
            String  str9= request.getParameter("pass_ssc");
            int pass_ssc = Integer.parseInt(str9);
            
            String subject = request.getParameter("subject");
            String str10 = request.getParameter("interest");
            int interest = Integer.parseInt(str10);
            
            int blacklist = 0;
            int approve = 0;
            int submit = 1;
            int selectinplacement = 0;
            
            String query2 = null;
            String dob = day+"/"+month+"/"+year;
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath () + "</h1>");
            out.println("<h1>" + userid+" " +student_name+" "+father_name+" "+ mother_name +" "+dob+" "+ gender +" "+ email_id +""+branch+" "+btech+" "+result_ssc+" "+result_hsc+" </h1>");
            out.println("</body>");
            out.println("</html>");
            
            String query = null;
            String query1 = null;
            
            String activity = "Application Recevied";
            String status = "Application Recevied";
            String activity1 = "Modification";
            String status1 = "Student cant modify data";
            String redirectURL1 = "http://localhost:8080/Placement%20Record%20Management%20System/default_data";
            
            String u1;
            String q1 = "Select StudentId from studentdetails";
            rs = stmt1.executeQuery(q1);
            int flag = 0;
            if(rs.next())//resultset have atleast one record
            {
                do{
                    u1 = rs.getString("StudentId");
                    if(u1.equals(userid))
                    {
                        //entry is already done
                        flag=1;
                        
                    }
                  }while(rs.next());
            
            }
         
             if(flag==1)
             {
                 //update record if entry is already done
                        query = "update studentdetails set StudentName=?,FatherName=?,MotherName=?,DateOfBirth=?,Gender=?,Address=?,EmailId=?,Branch=?,BTech_CPI=?,PassBTech=?,Twelve=?,PassTwelve=?,Ten=?,PassTen=?,Blacklist=?,Approve=?,Submit=?,Interested=?,Subject=?,SelectInPlacement=? where StudentId=?";  
                        pmt = con.prepareStatement(query);  
                        pmt = con.prepareStatement(query);
                        pmt.setString(1, student_name);
                        pmt.setString(2, father_name);
                        pmt.setString(3, mother_name);
                        pmt.setString(4, dob);
                        pmt.setString(5, gender);
                        pmt.setString(6, address);
                        pmt.setString(7, email_id);
                        pmt.setString(8, branch);
                        pmt.setDouble(9, btech);
                        pmt.setInt(10, pass_btech);
                        pmt.setDouble(11, result_hsc);
                        pmt.setInt(12, pass_hsc);
                        pmt.setDouble(13, result_ssc);
                        pmt.setInt(14, pass_ssc);
                        pmt.setInt(15, blacklist);
                        pmt.setInt(16, approve);
                        pmt.setInt(17, submit);
                        pmt.setInt(18, interest);
                        pmt.setString(19, subject);
                        pmt.setInt(20, selectinplacement);
                        pmt.setString(21, userid);
                        
                        
                        int n=pmt.executeUpdate();
                        
                        //make status update Activity:Application Recevied  and  Status:Application Recevied
                        query1 = "insert into activity_status_box values('"+userid+"','"+activity+"','"+status+"')";
            
                        int m = stmt1.executeUpdate(query1);
                        
                        //make status update Activity:Modification  and  Status:Syudent can't modify data
                        query2 = "insert into activity_status_box values('"+userid+"','"+activity1+"','"+status1+"')";
                        
                        int q = stmt2.executeUpdate(query2);
                        if(n==1 && m==1 && q==1)
                        {
                            response.sendRedirect(redirectURL1); 
                        }
             
             }
             else
             {
                 //insert entry if entry is not found
                        query="insert into studentdetails values('"+userid+"','"+student_name+"','"+father_name+"','"+mother_name+"','"+dob+"','"+gender+"','"+address+"','"+email_id+"','"+branch+"','"+btech +"','"+pass_btech+"','"+result_hsc+"','"+pass_hsc+"','"+result_ssc+"','"+pass_ssc+"','"+blacklist+"','"+approve+"','"+submit+"','"+interest+"','"+subject+"','"+selectinplacement+"')";      
                        int n = stmt.executeUpdate(query);
                        
                        //make status update Activity:Application Recevied  and  Status:Application Recevied
                        query1 = "insert into activity_status_box values('"+userid+"','"+activity+"','"+status+"')";
                        
                        //make status update Activity:Modification  and  Status:Syudent can't modify data
                        query2 = "insert into activity_status_box values('"+userid+"','"+activity1+"','"+status1+"')";
                        int m = stmt1.executeUpdate(query1);
                        
                        int q = stmt2.executeUpdate(query2);
                        if(n==1 && m==1 && q==1)
                        {
                            response.sendRedirect(redirectURL1); 
                        }
             
             }
                
          
             }catch(Exception e)
             {
            
             out.println("Exception  in setSubmit:::" + e);
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
