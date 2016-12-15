<%-- 
    Document   : update_status_multiple
    Created on : 25 Nov, 2012, 6:34:15 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Status | Placement Record Management System</title>
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
            
            ArrayList useridList = new ArrayList();
            
            for(int i=0;i<userid.length;i++)
            {
                useridList.add(userid[i]);
            
            }
            //setting useridList in applicationScope
            getServletContext().setAttribute("useridlist", useridList);
            

        %>
        <jsp:include page="dispaly_student_record_header.html" />
        <table width="1112" height="261" align="center"  border="4" bgcolor="#CCFFFF">
			<tr >
				<td height="38" colspan="3">Welcome 
				<jsp:useBean id="tpo" class="foo.TPO" scope="session"/>
				<jsp:getProperty name="tpo" property="userid"/> </td>
			</tr>
			<tr>
				<td width="211" height="307" rowspan="2"></td>
				<td width="657" rowspan="2"  bgcolor="#99CCFF">
				<form action="update_status_multi" method="post">
					<table width="657" height="139" bgcolor="lemonchiffon">
						<thead BGCOLOR="lightskyblue"/>
		  		  	  <tbody BGCOLOR="lemonchiffon">
						  <tr>
							  <td width="97" height="36"><div align="center">Activity</div></td>
							  <td width="498">
							  	<input name="activity" type="text" size="50" />
							  </td>
						  </tr>
						  <tr>
						  	<td height="35"><div align="center">Status</div></td><td><input name="status" type="text" size="50" /></td>
						  </tr>
						  <tr>
							  <td height="35">&nbsp;</td>
							  <td><input type="submit" value="Update" /><input type="reset" value="Reset" /></td>
						  </tr>
					  </tbody>
						<tfoot BGCOLOR="lightskyblue">
							<tr>
								<td colspan="2">
									PRMS Status Update Application </td>
							</tr>
						</tfoot>
				  </table>
			    </form>			  </td>
			    
			</tr>
			<tr>
			  <td height="175">&nbsp;</td>
	  </tr>
			
			<tr>
				<td height="31" colspan="3"></td>
			</tr>
	</table>        
    
    </body>
</html>
