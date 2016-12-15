<%-- 
    Document   : update_status_single
    Created on : 25 Nov, 2012, 6:56:21 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Update Status | Placement Record Management System</title>
		
        <style type="text/css">
<!--
.style1 {color: #FF0000}
-->
        </style>
</head>
    <body>
        <jsp:include page="headerAdmin.html" />
        <table width="1112" height="311" align="center"  border="4" bgcolor="#CCFFFF">
			<tr >
				<td height="40" colspan="3">Welcome 
				<jsp:useBean id="tpo" class="foo.TPO" scope="session"/>
				<jsp:getProperty name="tpo" property="userid"/></td>
			</tr>
			<tr>
				<td width="211" height="307" rowspan="3"></td>
				<td width="657" rowspan="3"  bgcolor="#9999FF">
				<form action="update_status_one" method="post" name="update_status_single">
					<table width="657" height="169" bgcolor="lemonchiffon">
						<thead BGCOLOR="lightskyblue">
		  		  	  <tbody BGCOLOR="lemonchiffon">
					  		<tr>
								<td height="33"><div align="center">Enter StudentId</div></td><td><input type="text" name="userid" /></td>
							</tr>
						  <tr>
							  <td width="97" height="31"><div align="center">Activity</div></td>
							  <td width="498">
							  	<input name="activity" type="text" size="50" />							  </td>
						  </tr>
						  <tr>
						  	<td height="32"><div align="center">Status</div></td><td><input name="status" type="text" size="50" /></td>
						  </tr>
						  <tr>
							  <td height="30">&nbsp;</td>
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
			  <td height="33" align="center"><div align="center"><a href="studentRecord.jsp" style="color: #FF0000;font-size:15px">Choose Multiple Selection</a></div></td>
	  </tr>
			<tr>
			  <td height="188">&nbsp;</td>
		  </tr>
			
			<tr>
				<td height="31" colspan="3"></td>
			</tr>
	</table>        
    
    </body>
</html>
