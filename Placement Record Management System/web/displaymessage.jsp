<%-- 
    Document   : displaymessage
    Created on : 23 Nov, 2012, 3:12:52 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Message | Placement Record Management System</title>
    </head>
    <body>
        <jsp:include page="header1.html"/>
		<table width="1112" height="289" align="center"  border="4" bgcolor="#CCFFFF">
			<tr >
				<td height="38" colspan="3">				</td>
			</tr>
			<tr>
				<td width="126" height="37">Message:				</td>
				<td width="437" rowspan="5"><textarea name="textarea" cols="70" rows="12" disabled="disabled">
                                        ${requestScope.message}
                                    </textarea></td>
				<td width="521" rowspan="5">				</td>
			</tr>
			<tr>
			  <td height="33"></td>
		  </tr>
			<tr>
			  <td height="28"></td>
		  </tr>
			<tr>
			  <td height="33"></td>
		  </tr>
			<tr>
			  <td height="57"></td>
		  </tr>
			<tr>
				<td height="33" colspan="3"><input type="button"  onClick="parent.location='messageCount'" value="<--- Back" /></td>
			</tr>
	</table>        
    </body>
</html>
