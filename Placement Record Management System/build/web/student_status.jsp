<%-- 
    Document   : student_status
    Created on : 23 Nov, 2012, 8:36:08 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Status | Placement Record Management System</title>
    </head>
    <body>
        <jsp:include page="headerStudent.html" />
	<table width="1112" height="413" align="center"  border="4" bgcolor="#CCFFFF">
			<tr >
				<td height="38" colspan="3">Welcome 
				&quot;Write Name of Student&quot;</td>
			</tr>
			<tr>
				<td width="211" height="319"></td>
				<td width="657" >
					<table width="657" height="87">
						<thead BGCOLOR="lightskyblue">
			  		  <th width="321" height="27">Activity</th>
			  		  <th width="324">Status</th>
						<tbody BGCOLOR="lemonchiffon">
                                                    <c:forEach var="listElement" items="${statusrecord}">
							<tr>
								<td height="27"><div align="center">${listElement[0]}</div></td>
								<td><div align="center">${listElement[1]}</div></td>
							</tr>
                                                    </c:forEach>
						</tbody>
						<tfoot BGCOLOR="lightskyblue">
							<tr>
								<td height="23" colspan="2">
									PRMS Application Status								</td>
							</tr>
						</tfoot>
				  </table>
			  </td>
			  <td width="216">			  </td>
	  </tr>
			
			<tr>
				<td height="40" colspan="3"></td>
			</tr>
	</table>        
    </body>
</html>
