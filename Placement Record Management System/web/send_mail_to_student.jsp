<%-- 
    Document   : send_mail_to_student
    Created on : Mar 30, 2012, 5:09:03 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Mail | Placement Record Management System</title>
    </head>
    <body>        
        <%
            String url = "jdbc:mysql://localhost/prms";
            
            String user_id="root";
            String user_pass = "root";
            Connection con = null; 
            Statement stmt = null;
            ResultSet rs = null;
            String query = null;
            
            
            String[] userid = request.getParameterValues("userid");
            
            ArrayList emailidList = new ArrayList();
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
            
            try{
            
                //getting email_id with use of userid and put it in to[]
            
                con = DriverManager.getConnection(url,user_id,user_pass);
               
                stmt = (Statement)con.createStatement();
               
            
                for(int j=0;j<userid.length;j++)
                {
                    query = "select EmailId from studentdetails where StudentId='"+userid[j]+"'";
                    rs = stmt.executeQuery(query);
                    while(rs.next())
                    {
                        emailidList.add(rs.getString("EmailId"));
                    }
                }
                
                //setting useridList in applicationScope
                getServletContext().setAttribute("emailidlist", emailidList);
            }catch(SQLException e)
            {
                System.out.println("Sql exception in emailServlet::"+e);
            }

        %>
        <jsp:include page="dispaly_student_record_header.html"/>
        <form action="EmailServlet" method="post">
            <table width="1112" height="247" align="center" border="4" bgcolor="#CCFFFF">  
		<tr>
                    <td width="106" height="30" align="center">Subject</td>
                    <td colspan="2"><input type="text" name="subject" required ></td>
		</tr>  
		<tr>
                    <td height="173">
			<table height="157">
                            <tr><td width="102" height="21" align="center">Message:</td></tr>
                            <tr><td></td></tr>
                            <tr><td height="26"></td></tr>
                            <tr><td></td></tr>
                            <tr><td height="22"></td></tr>
                            <tr><td height="22"></td></tr>			
			</table>
                    </td>
                    <td colspan="2"><textarea name="message" cols="40" rows="10" required ></textarea></td>
                </tr> 
		<tr>
                    <td height="28" align="center"></td><td width="58"><input type="submit" value="Send" /></td><td width="920" align="left"> <input type="button"  value="Cancel" onClick="parent.location='studentRecord.jsp'"/></td>
		</tr> 
          </table>
        </form>
    </body>
</html>
