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
public class placed_student_record_calculate extends HttpServlet {

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
        String str = request.getParameter("branch");
        
        //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        
        String companyname = request.getParameter("company_name");
        String branch = request.getParameter("branch");
        String subject = request.getParameter("subject");
        String year = request.getParameter("year");
        
        String query,query1,query2;
        
        
        String[] branches = {"ce","ec","it","ic","ch","mc","cl"};
        String[] years = {"2012","2011","2010","2009"};
        String[] subjects = {"Java/J2EE",".Net","Perl","C++","Embedded","Wireless","VlSI","Power","Structure"};
        String[] companynames = {"TCS","Infibeam","NeoDigital","Zeus","Cybage","Meditab","Infostratch","Matrix","Cybridge","Tatvic","Maruti Technology"};
        
        java.util.List List1 = new java.util.ArrayList();
        
        RequestDispatcher view1 = request.getRequestDispatcher("report1.jsp");
        RequestDispatcher view2 = request.getRequestDispatcher("report2.jsp");
        RequestDispatcher view3 = request.getRequestDispatcher("report3.jsp");
        RequestDispatcher view4 = request.getRequestDispatcher("report4.jsp");
        RequestDispatcher view5 = request.getRequestDispatcher("report5.jsp");
        RequestDispatcher view6 = request.getRequestDispatcher("report6.jsp");
        RequestDispatcher view7 = request.getRequestDispatcher("report7.jsp");
        
        try {
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
                
                con = DriverManager.getConnection(url1,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                stmt1 = (Statement)con.createStatement();
                
                out.println(companyname+" "+branch+" "+subject+" "+year + branches.length + years.length);
                
                if((!companyname.equals("na")) && (branch.equals("na")) && (subject.equals("na")) && (year.equals("na")))
                {
                    out.println(companyname+" "+branch+" "+subject+" "+year + branches.length + years.length);
                    for(int i = 0;i<branches.length;i++)
                    {
                        for(int j = 0;j<years.length;j++)
                        {
                        out.print("s1");
                        query = "select * from Placement_Box where CompanyName='"+companyname+"' and Branch='"+branches[i]+"' and Year='"+years[j]+"'";
                        rs = stmt.executeQuery(query);
                        int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            
                            if(count != 0)
                            {
                               String[] record = {years[j],branches[i],Integer.toString(count)};
                               out.println(branches[i]+years[j]+Integer.toString(count));
                               List1.add(record);
                               out.println(count);
                            }
                        }
                    }
                    out.print("finish");
                    request.setAttribute("studentlist", List1);
                    view1.forward(request, response);
                }
                else if((!companyname.equals("na")) && (!branch.equals("na")) && (subject.equals("na")) && (year.equals("na")))
                {
                    for(int i=0;i<years.length;i++)
                    {
                        query = "select * from Placement_Box where CompanyName='"+companyname+"' and Branch='"+branch+"' and Year='"+years[i]+"'";
                        rs = stmt.executeQuery(query);
                        
                        int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            
                            if(count != 0)
                            {
                               String[] record = {years[i],branch,Integer.toString(count),companyname};
                               List1.add(record);
                            }
                    }
                    request.setAttribute("studentlist", List1);
                    view2.forward(request, response);
                    
                }
                else if((!companyname.equals("na")) && (!branch.equals("na")) && (!subject.equals("na")) && (year.equals("na")))
                {
                    for(int i=0;i<years.length;i++)
                    {
                        query = "select * from Placement_Box where CompanyName='"+companyname+"' and Branch='"+branch+"' and Year='"+years[i]+"' and Subject='"+subject+"'";
                        rs = stmt.executeQuery(query);
                        
                            int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            
                            if(count != 0)
                            {
                                String[] record = {years[i],branch,subject,Integer.toString(count),companyname};
                                List1.add(record);
                            }
                    }
                    request.setAttribute("studentlist", List1);
                    view3.forward(request, response);
                    
                }
                else if((!companyname.equals("na")) && (!branch.equals("na")) && (!subject.equals("na")) && (!year.equals("na")))
                {
                    query = "select * from Placement_Box where CompanyName='"+companyname+"' and Branch='"+branch+"' and Year='"+year+"' and Subject='"+subject+"'";
                    rs = stmt.executeQuery(query);
                        
                            int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            
                            String[] record = {year,branch,subject,Integer.toString(count),companyname};
                            List1.add(record);
                            request.setAttribute("studentlist", List1);
                            view4.forward(request, response);
                }
                else if((companyname.equals("na")) && (!branch.equals("na")) && (subject.equals("na")) && (year.equals("na")))
                {
                    for(int i=0;i<years.length;i++)
                    {
                        for(int j=0;j<subjects.length;j++)
                        {
                            for(int k=0;k<companynames.length;k++)
                            {
                            query = "select * from Placement_Box where Branch='"+branch+"' and Year='"+years[i]+"' and CompanyName='"+companynames[k]+"' and Subject='"+subjects[j]+"'";
                            rs = stmt.executeQuery(query);
                        
                            int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            if(count != 0)
                            {
                                String[] record = {years[i],companynames[k],subjects[j],Integer.toString(count)};
                                List1.add(record);
                            }
                            }
                        }
                    }
                    request.setAttribute("studentlist", List1);
                    view5.forward(request, response);
                    
                }
                else if((companyname.equals("na")) && (!branch.equals("na")) && (!subject.equals("na")) && (year.equals("na")))
                {
                    for(int i=0;i<years.length;i++)
                    {
                        for(int j=0;j<companynames.length;j++)
                        {
                        query = "select * from Placement_Box where Branch='"+branch+"'and CompanyName='"+companynames[j]+"' and Year='"+years[i]+"' and Subject='"+subject+"'";
                        rs = stmt.executeQuery(query);
                        
                            int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            if(count != 0)
                            {
                                String[] record = {years[i],companynames[j],subject,Integer.toString(count)};
                                List1.add(record);
                            }
                        }
                    }
                    request.setAttribute("studentlist", List1);
                    view5.forward(request, response);
                
                }
                else if((companyname.equals("na")) && (!branch.equals("na")) && (!subject.equals("na")) && (!year.equals("na")))
                {
                    for(int i=0;i<companynames.length;i++)
                    {
                        query = "select * from Placement_Box where CompanyName='"+companynames[i]+"' and Branch='"+branch+"' and Year='"+year+"' and Subject='"+subject+"'";  
                        
                        rs = stmt.executeQuery(query);
                        
                            int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            if(count != 0)
                            {
                                String[] record = {year,companynames[i],subject,Integer.toString(count)};
                                List1.add(record);
                            }
                    }
                    request.setAttribute("studentlist", List1);
                    view5.forward(request, response);
                
                }
                else if((companyname.equals("na")) && (branch.equals("na")) && (!subject.equals("na")) && (year.equals("na")))
                {
                    for(int i=0;i<years.length;i++)
                    {
                        for(int j=0;j<branches.length;j++)
                        {
                            for(int k=0;k<companynames.length;k++)
                            {
                                query = "select * from Placement_Box where CompanyName='"+companynames[k]+"' and Branch='"+branches[j]+"' and Year='"+years[i]+"' and Subject='"+subject+"'";  
                                
                                rs = stmt.executeQuery(query);
                        
                            int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            if(count != 0)
                            {
                                String[] record = {years[i],companynames[k],branches[j],Integer.toString(count)};
                                List1.add(record);
                            }
                            }
                        }
                    }
                    request.setAttribute("studentlist", List1);
                    view6.forward(request, response);
                
                }
                else if((companyname.equals("na")) && (branch.equals("na")) && (!subject.equals("na")) && (!year.equals("na")))
                {
                    for(int i=0;i<branches.length;i++)
                    {
                        for(int j=0;j<companynames.length;j++)
                        {
                            query = "select * from Placement_Box where CompanyName='"+companynames[j]+"' and Branch='"+branches[i]+"' and Year='"+year+"' and Subject='"+subject+"'";  
                            rs = stmt.executeQuery(query);
                        
                            int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            if(count != 0)
                            {
                                String[] record = {year,companynames[j],branches[i],Integer.toString(count)};
                                List1.add(record);
                            }
                        }
                    }
                    request.setAttribute("studentlist", List1);
                    view6.forward(request, response);
                
                }
                else if((companyname.equals("na")) && (branch.equals("na")) && (subject.equals("na")) && (!year.equals("na")))
                {
                    for(int i=0;i<branches.length;i++)
                    {
                        for(int j=0;j<subjects.length;j++)
                        {
                            for(int k=0;k<companynames.length;k++)
                            {
                                query = "select * from Placement_Box where CompanyName='"+companynames[k]+"' and Branch='"+branches[i]+"' and Year='"+year+"' and Subject='"+subjects[j]+"'";  
                            rs = stmt.executeQuery(query);
                        
                            int count=0;
                            if(rs.next())
                            {
                                out.print("s2");
                                do
                                {
                                    count++;
                                    
                                }while(rs.next());
                        
                             }
                            if(count != 0)
                            {
                                String[] record = {companynames[j],branches[i],subjects[j],Integer.toString(count)};
                                List1.add(record);
                            }
                            }
                        }
                    }
                    request.setAttribute("studentlist", List1);
                    view7.forward(request, response);
                    
                
                }
            
            }catch(Exception e)
            {
                out.println("Exception in placed_student_record_calculate::"+e);
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
