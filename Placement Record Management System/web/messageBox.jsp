<%-- 
    Document   : feedback
    Created on : Feb 26, 2012, 2:53:33 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <script type="text/javascript">
         function noBack() 
            {
                window.history.forward(0);
            }
    </script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>MessageBox | Placement Record Management System</title>
<style type="text/css">
<!--
.style1 {font-size: 18px}
.style2 {
	font-size: 24px;
	font-family: "Courier New", Courier, monospace;
	color: #6600FF;
}
.style3 {font-size: 10px}
-->
</style>
</head>

<body>
<jsp:include page="headerStudent.html"/>
	<form  method="post" name="messageBox"  action="setRead">
        <table width="1112" height="152" align="center"  border="4" bgcolor="#CCFFFF">
		<tr>
					<td bgcolor="#00CCFF">
						<table width="482">
							<thead>
						  <th>Inbox(${requestScope.totalmsg})</th><th>Unread(${requestScope.totalunread})</th>
							</thead>
					  </table>
					</td>
                    
		</tr>
		<tr>
			<td height="107" colspan="2" >
				<table width="1095" height="109"  align="center">
					<thead  BGCOLOR="lightskyblue">
				  <th>No.</th><th>Subject</th><th>From</th><th>Date</th><th>See</th>
					
					<tbody BGCOLOR="lemonchiffon">
                  	
            			<c:forEach var="listElement" items="${messagebox}">
            			<tr>
                     
                    		<td width="117" align="center" bgcolor="${listElement[5]}">
                        		${listElement[0]}			        		</td>
                    		<td width="360" align="center" bgcolor="${listElement[5]}">
                        		${listElement[2]}						</td>
                    		<td width="240" align="center" bgcolor="${listElement[5]}">
                        		${listElement[3]}						</td> 
                    		<td width="240" align="center" bgcolor="${listElement[5]}">
                        		${listElement[4]}						</td>
                    	
                    		<td width="114" align="center" bgcolor="${listElement[5]}">
                            	<button name="mgno" value="${listElement[1]}" onclick="window.location.href='setRead'" >read</button>        
                          	</td>
             			</tr>
            			</c:forEach>
					</tbody>
					<tfoot BGCOLOR="lightskyblue">
  					<tr>
    					<td height="21" colspan="5" >read Message... </td>
  					</tr>
					</tfoot>
				</table>
		  </td>
		</tr>
			
	  </table>
</form>
</body>
</html>

