<%-- 
    Document   : resumeupload2
    Created on : Mar 3, 2012, 4:42:26 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Resume | Placement Record Management System</title>
        <script type="text/javascript">
            function checkFile()
            {
                re=/[^\s]+(\.(?i)(pdf)$/;
                if(!re.test(uploadForm.file.value)) {
        		alert("Only upload resume type of pdf format");
        		uploadForm.file.focus();
        		return false;
      			}
            }
            function noBack() 
            {
                window.history.forward(0);
            }
        </script>
    </head>
    <body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
    <jsp:include page="headerStudent.html"/>
    ${requestScope.alert}
    <table width="1112" height="336" align="center" border="4" bgcolor="#CCFFFF">
		<tr>
		<td height="32" colspan="3">&nbsp;</td>
		</tr>
        <tr>
			<td width="200">&nbsp;</td>
            <td width="684" height="173" align="center">
                <form method="post"  action="UploadResume" enctype="multipart/form-data" name="uploadForm" onSubmit="return checkFile(this);">
                    <table width="498" height="93" border="0">
                        <tr>
                            <p align="center"><strong><font size="5">Upload Resume</font></strong></p>
                        </tr>
                        <tr>
                            <td><p>Upload a Resume:</p></td>
                            <td><input  type="file" name="file" align="right" size="50"/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Upload" onClick="return validateForm(this);"/></td>
                        </tr>
                  </table>
                </form>
          </td>
		  <td width="200">&nbsp;</td>
		  
        </tr>
		<tr>
		<td colspan="3">Student can upload only pdf file in format of &quot;userid branch.pdf&quot; e.g 092067 ce.pdf </td>
		</tr>
    </table>
	
    </body>
</html>
