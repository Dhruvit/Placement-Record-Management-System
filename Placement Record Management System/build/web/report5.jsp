<%-- 
    Document   : report1
    Created on : 1 Dec, 2012, 5:36:19 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
		<style type="text/css">
<!--
.style3 {
	font-size: 36px;
	font-weight: bold;
	font-family: "Times New Roman", Times, serif;
	color: #FF3300;
}
.style5 {
	font-size: 24px;
	font-weight: bold;
	font-family: "Courier New", Courier, monospace;
}
.style6 {color: #6600FF}
-->
</style>
    </head>
    <jsp:include page="header_report.html"/>
        <form action="welcomeAdmin.jsp" method="post">
        <table width="1112" height="91" align="center" border="4" bgcolor="#CCFFFF">
			<thead  BGCOLOR="lightskyblue">
		    <th>Year</th>
		      <th>Company Name</th>
			  <th>Subject</th>
		      <th>No. of Student</th>
		      
			<tbody BGCOLOR="lemonchiffon">
            	<c:forEach var="listElement" items="${studentlist}">
            		<tr>
                    	
                    	<td width="201" height="25" align="center">
                        	${listElement[0]}			        	</td>
                    	<td width="415" align="center">
                        	${listElement[1]}                    	</td>
						<td width="282" align="center">
                        	${listElement[2]}                    	</td>
 
                    	<td width="180" align="center">${listElement[3]}  </td> 
                    	                 	
                        
             		</tr>
            	</c:forEach>
			</tbody>
			<tfoot BGCOLOR="lightskyblue">
  				<tr>
    				<td COLSPAN="6">&nbsp;</td>
  				</tr>
			</tfoot>
			
		</table>
		</form>
    </body>
</html>
