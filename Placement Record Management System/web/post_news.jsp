<%-- 
    Document   : post_news
    Created on : 23 Nov, 2012, 9:56:43 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post News | Placement Record Management System</title>
		 
    </head>
    <body>
	<jsp:include page="headerAdmin.html" />
	<jsp:useBean id="tpo" class="foo.TPO" scope="session"/>
	<table width="1112" height="394" align="center"  border="4" bgcolor="#CCFFFF">
			<tr >
				<td height="38" colspan="3">Welcome 
				<jsp:getProperty name="tpo" property="userid"/></td>
			</tr>
			<tr>
				<td width="211" height="307" rowspan="2"></td>
				<td width="657" rowspan="2" >
				<form action="tpo_update" method="post" >
					<table width="657" height="309" bgcolor="lemonchiffon">
						<thead BGCOLOR="lightskyblue">
			  		  <tbody BGCOLOR="lemonchiffon">
						  <tr>
							  <td width="97" height="30"><div align="center">Subject</div></td>
							  <td width="498">
							  <select name="subject" required x-moz-errormessage="Select Your Profile Type" >
							  		<option value=""> </option>
									<option value="Offcampus">Offcampus</option>
									<option value="Upcoming Company">Upcoming company</option>
									<option value="Upcoming Event">Upcoming Event</option>
								</select>							
								</td>
						  </tr>
						  <tr>
							  <td height="27"><div align="center">News</div></td><td rowspan="4"><textarea required name="news" cols="60" rows="13"></textarea></td>
						  </tr>
						  <tr>
						    <td height="14">&nbsp;</td>
					    </tr>
						  <tr>
						    <td height="29">&nbsp;</td>
					    </tr>
						  <tr>
						    <td height="29">&nbsp;</td>
					    </tr>
						<tr>
							<td><div align="center">Ref. link </div></td>
							<td><input name="link" type="text" size="50" required/></td>
						</tr>
						  <tr>
							  <td height="27">&nbsp;</td><td><input type="submit" value="Post" /><input type="reset" value="Clear" /></td>
						  </tr>
					  </tbody>
						<tfoot BGCOLOR="lightskyblue">
							<tr>
								<td colspan="2">
									PRMS Posting Application </td>
							</tr>
						</tfoot>
				  </table>
				  </form>			  </td>
			    <td width="216" height="30" align="center"><button onClick="window.location.href='placement_news.jsp'">Posting Placement News</button></td>
			</tr>
			<tr>
			  <td height="277">&nbsp;</td>
	  </tr>
			
			<tr>
				<td height="31" colspan="3"></td>
			</tr>
	</table>        
            
    
    </body>
</html>
