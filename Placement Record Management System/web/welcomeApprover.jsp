<%-- 
    Document   : welcomeApprover
    Created on : 18 Nov, 2012, 11:25:43 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="foo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approver | Placement Record Management System</title>
    </head>
    <body>
        <jsp:include page="headerApprover.html"/>
		<table  width="1112" height="500" align="center" border="4" bgcolor="#CCFFFF">
		<tr>
			<td height="71">
				<jsp:useBean id="countrecord" class="foo.CountRecord" scope="session"/>
                    <h1>Total Remaining Student for approving record::
                                <jsp:getProperty name="countrecord" property="count"/>
                    </h1>
		  </td>
		</tr>
		<tr>
		</tr>
                    
                                                            
   	</table>
    </body>
</html>
