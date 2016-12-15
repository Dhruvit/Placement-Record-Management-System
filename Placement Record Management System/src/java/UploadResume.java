
// Import required java libraries
import foo.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.servlet.RequestDispatcher;


import javax.servlet.*;
import javax.servlet.http.*;
 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

public class UploadResume extends HttpServlet {
   
   private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 200 * 1024;
   private int maxMemSize = 1024 * 1024;
   private File file ;
   

   public void init( ){
      // Get the file location where it would be stored.
      filePath = 
             getServletContext().getInitParameter("file-upload");
      
   }
   public void doPost(HttpServletRequest request, 
               HttpServletResponse response)
              throws ServletException, java.io.IOException {
      
       // Check that we have a file upload request
      isMultipart = ServletFileUpload.isMultipartContent(request);
       
       String url1 = "jdbc:mysql://localhost/prms";
       String user_id="root";
       String user_pass = "root";
       Connection con = null;
       Statement stmt,stmt1,stmt2 = null;
       ResultSet rs,rs1 = null;
       
       //return preexisting session or return null if session does not exist
        HttpSession session = request.getSession(false);
        foo.Student student = (Student)session.getAttribute("student");
        
        //get userid
        String userid = student.getUserid();
       
        RequestDispatcher view = request.getRequestDispatcher("resumeupload.jsp");
        PrintWriter out = response.getWriter();
        
        if( !isMultipart ){
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet upload</title>");  
         out.println("</head>");
         out.println("<body>");
         out.println("<p>No file uploaded</p>"); 
         out.println("</body>");
         out.println("</html>");
         return;
        }
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax( maxFileSize );
        
        try{
            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
                
                 con = DriverManager.getConnection(url1,user_id,user_pass);
                 stmt = (Statement)con.createStatement();
                 stmt1 = (Statement)con.createStatement();
                 stmt2 = (Statement)con.createStatement();
                 
                //check only approve student upload resume and once student upload resume he/she can't upload resume again
                 String q1 = "select * from studentdetails where StudentId='"+userid+"'";
                 String q2 = "select * from resume_info where StudentId='"+userid+"'";
                 
                      
                     rs1 = stmt.executeQuery(q1);
                     if(rs1.next())
                     {
                        out.println(rs1.getInt("Approve"));
                        if(rs1.getInt("Approve")==0)
                        {
                        //student data is not approve so student can't upload resume
                        String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Student data not approve...Student can not upload resume')</script></body></html>";
                        request.setAttribute("alert", ALERT);
                        view.forward(request, response);
                        }
                     }
                 
                    rs = stmt1.executeQuery(q2);
                    if(rs.next())
                    {
                     //student already upload resume
                     String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Already Upload resume')</script></body></html>";
                     request.setAttribute("alert", ALERT);
                     view.forward(request, response);
                     
                    }
                 
                 
                     
                 
                 
                 // Parse the request to get file items.
                List fileItems = upload.parseRequest(request);
	
                // Process the uploaded file items
                Iterator i = fileItems.iterator();

                  out.println("<html>");
                  out.println("<head>");
                  out.println("<title>Servlet upload</title>");  
                  out.println("</head>");
                  out.println("<body>");
                  out.println("3");
      
                  while ( i.hasNext () ) 
                  {
                    FileItem fi = (FileItem)i.next();
                    if ( !fi.isFormField () )	
                    {
            
                        out.println("2");
                        
                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        
                        
                        // Write the file
                        if( fileName.lastIndexOf("\\") >= 0 )
                        {
                            file = new File( filePath + 
                            fileName.substring( fileName.lastIndexOf("\\"))) ;
                        }
                        else
                        {
                            file = new File( filePath + 
                            fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                        }
                        fi.write( file ) ;
                        String path = filePath + fileName;
                        String query1 = "insert into resume_info values('"+userid+"','"+fileName+"','"+path+"')";
            
                        int m = stmt1.executeUpdate(query1);
                        
                        if(m==1)
                        {
                            String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Upload Successfully')</script></body></html>";
                            request.setAttribute("alert", ALERT);
                            view.forward(request, response);
                        
                        }
                    
                    out.println("Uploaded Filename: " + fileName + path+ "<br>");
                    }
                   }
                    out.println("</body>");
                    out.println("</html>");
                 
                 
            
            }catch(Exception e)
            {
                String ALERT = "<html><body><script type = " + " text/javascript " + " >alert('Maximum file size allowed is 200KB')</script></body></html>";
                request.setAttribute("alert", ALERT);
                view.forward(request, response);
                out.println("Exception in UploadResume::"+e);
                
            }
        
        }finally
        {
            out.close();
        }
       
   }
   public void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
        throws ServletException, java.io.IOException {
        
        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
   } 
}