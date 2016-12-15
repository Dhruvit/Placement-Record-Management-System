<%-- 
    Document   : welcomeStudent
    Created on : Mar 3, 2012, 4:39:54 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student | Placement Record Management System</title>
    </head>
    <body>
        <jsp:include page="headerStudent.html"/>
        <%
        
        ServletContext sc = getServletContext();
        String url = "jdbc:mysql://localhost/admin";
        String user_id="root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt = null;
        ResultSet rs = null;
        String userid = request.getParameter("userid");
        
        try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
        
        try{
            con = DriverManager.getConnection(url,user_id,user_pass);
            stmt = (Statement)con.createStatement();
            
            //get branch for particular user
            
            rs = stmt.executeQuery("select * from id_password ");
            
             String user_id1 = null;
             String branch = null;
             
              while(rs.next())
                {
                    user_id1 = rs.getString("userid");
                    
                    if(user_id1.equals(userid) )
                    {
                    branch = rs.getString("branch");
                    break;
                    }
                    
                }
             sc.setAttribute("userid", userid);
             sc.setAttribute("branch", branch);
             stmt.close();
             con.close();
        }catch(SQLException e){}
        
        
        %>
        <table width="1112" height="500" align="center" border="4" bgcolor="#CCFFFF">
		<tr>
			<td height="500">
				<img src="img/91 whole of DDIT.jpg" width="1100" height="500" alt="DDU pic" />			</td>
		</tr>
    </table>
    </body>
</html>
