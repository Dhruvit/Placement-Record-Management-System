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
        <title>Student Record | Placement Record Management System</title>
		<script type="text/javascript">
            var goTarget 

			function setTarget(target){ 
			goTarget = target;
			} 

			function gotoTarget(form) {
			
			//remember to leave action field blank when defining the form 
			if(goTarget == 0) document.display_student_record.action="send_mail_to_student.jsp"; 
			if(goTarget == 1) document.display_student_record.action="update_status_multiple.jsp"; 
            }
			
			function openPDF(file)
			{
			windows.open(file, 'resizable,scrollbars');
			}
        </script>
    </head>
    <body>
        
	<jsp:include page="dispaly_student_record_header.html"/>
        <form action="" method="post" name="display_student_record" onSubmit="gotoTarget(this)">
        <table width="1112" height="40" align="center" border="4" bgcolor="#CCFFFF">
			<thead  BGCOLOR="lightskyblue">
				<th></th><th>StudentId</th><th>Name</th><th>EmailId</th><th>Branch</th><th>BTech(CPI)</th><th>See</th>
			</thead>
			<tbody BGCOLOR="lemonchiffon">
            	<c:forEach var="listElement" items="${recordlist}">
            		<tr>
                    	<td width="28" height="28" align="center">
                        	<input type="checkbox" name="userid" value="${listElement[0]}" checked="checked" />
              			</td>
                    	<td width="109" align="center">
                        	${listElement[0]}              
			        	</td>
                    	<td width="200" align="center">
                        	${listElement[1]}
                    	</td>
                    	<td width="279" align="center">
                        	${listElement[2]} 
                    	</td> 
                    	<td width="205" align="center">
                        	${listElement[3]} 
                    	</td>
                    	<td width="162" align="center">
                        	${listElement[4]}
                    	</td>
                    	<td width="77" align="center">
                        <a  href="${listElement[5]}" title="Resume" target="_blank" style="font-size:10pt;text-decoration:none;">Resume</a>	
						
              			</td>
             		</tr>
            	</c:forEach>
			</tbody>
			<tfoot BGCOLOR="lightskyblue">
  				<tr>
    				<td COLSPAN="7">Check student for sending mail.</td>
  				</tr>
			</tfoot>
			<tbody>
				<tr bordercolor="#CCFFFF">
                     <td width="20"><input type="submit" value="Send mail" onClick="setTarget(0)"/></td>
                        <td align="center" width="20"><input type="submit" value="Update Status" onClick="setTarget(1)"/></td>
				</tr>
			</tbody>
		</table>
		</form>
    </body>
</html>
