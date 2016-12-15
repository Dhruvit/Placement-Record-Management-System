<%-- 
    Document   : sendMessage
    Created on : 20 Nov, 2012, 11:41:19 AM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send Message | Placement Record Management System</title>
    </head>
    <body>
        <jsp:include page="sendMessageToStudentheader.html"/>
        <form action="sendMessage" method="post">
            ${requestScope.alert}
            <table width="1112" height="247" align="center" border="4" bgcolor="#CCFFFF">  
		<tr>
                    <td width="83" height="30" align="center">Subject</td>
                    <td colspan="3"><input type="text" name="subject" required /></td>
		</tr>  
		<tr>
                    <td height="173">
			<table height="157">
                            <tr><td width="102" height="21" align="center">Message:</td></tr>
                            <tr><td></td></tr>
                            <tr><td height="26"></td></tr>
                            <tr><td></td></tr>
                            <tr><td height="22"></td></tr>
                            <tr><td height="22"></td></tr>			
			</table>
                    </td>
                    <td colspan="3"><textarea name="message" cols="40" rows="10" required ></textarea></td>
                </tr> 
		<tr>
                    <td height="28" align="center"></td><td width="50"><button name="userid" type="submit" value="${param.userid}" onClick="window.location.href='sendMessage'">Send</button></td>
		<td width="50" align="left"> <input type="reset"  value="Clear" /></td>
		<td width="895" align="left"></td>
		</tr> 
          </table>
        </form>
    </body>
</html>
