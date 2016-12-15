<%-- 
    Document   : display_blackList_student_record
    Created on : Apr 25, 2012, 3:14:07 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blacklist Students | Placement Record Management System</title>
    </head>
    <body>
        <jsp:include page="display_blackList_student_record_header.html"/>
        <form action="welcomeAdmin.jsp" method="post">
        <table width="1112" height="40" align="center" border="4" bgcolor="#CCFFFF">
			<thead  BGCOLOR="lightskyblue">
		  <th>StudentId</th><th>Student Name</th><th>Branch</th><th>Email ID</th><th>BTech_CPI</th>
			<tbody BGCOLOR="lemonchiffon">
            	<c:forEach var="listElement" items="${blacklist}">
            		<tr>
                    	
                    	<td width="122" align="center">
                        	${listElement[0]}			        	</td>
                    	<td width="315" align="center">
                        	${listElement[1]}                    	</td>
                    	<td width="126" align="center">
                        	${listElement[2]}                    	</td> 
                    	<td width="331" align="center">
                        	${listElement[3]}                    	</td>
                    	<td width="178" align="center">
                        	${listElement[4]}                    	</td>
                        
             		</tr>
            	</c:forEach>
			</tbody>
			<tfoot BGCOLOR="lightskyblue">
  				<tr>
    				<td COLSPAN="6"><a href="remove_blackList_student.jsp"  title="Remove Student from Blacklist" name="blacklistrecord" />Remove Student from Blacklist</td>
  				</tr>
			</tfoot>
			<tbody>
				<tr bordercolor="#CCFFFF">
				  <td colspan="2"><input type="button" value="Ok" onClick="parent.location='welcomeAdmin.jsp'"/><input type="button" value="Add More" onClick="parent.location='add_blackList_student.jsp'"/></td>
			    </tr>
			</tbody>
		</table>
		</form>
    </body>
</html>
