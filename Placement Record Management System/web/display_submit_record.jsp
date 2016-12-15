<%-- 
    Document   : display_student_record
    Created on : Mar 30, 2012, 5:08:35 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit Record | Placement Record Management System</title>
        
    </head>
    <body>
        
	<jsp:include page="headerApprover.html"/>
	<form  method="post" name="submitform"  action="seeStudentData">
        <table width="1112" height="" align="center" border="4" bgcolor="#CCFFFF">
			<thead  BGCOLOR="lightskyblue">
				<th>StudentId</th><th>StudentName</th><th>Email ID</th><th>BTech(CPI)</th><th>See</th>
			<tbody BGCOLOR="lemonchiffon">
            	<c:forEach var="listElement" items="${submitrecordlist}">
            		<tr>
                    	
                    	<td width="109" align="center">
                        	${listElement[0]}			        	</td>
                    	<td width="340" align="center">
                        	${listElement[1]}                    	</td>
                    	<td width="" align="center">
                        	${listElement[2]}                    	</td> 
                    	<td width="205" align="center">
                        	${listElement[3]}                    	</td>
                    	
                    	<td width="100" align="center">
			            	<button name="userid" value="${listElement[0]}" onClick="windows.location.href='seeStudentData'">Select</button>  			
						</td>
             		</tr>
            	</c:forEach>
			</tbody>
			<tfoot BGCOLOR="lightskyblue">
  				<tr>
    				<td COLSPAN="5">Select student for approvement.</td>
  				</tr>
			</tfoot>
		</table>
	</form>
    </body>
</html>
