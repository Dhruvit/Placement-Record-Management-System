<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title> Remove Blacklist Student | Placement Record Management System</title>
<style type="text/css">
<!--
.style1 {
	font-size: 24px;
	font-weight: bold;
}
-->
</style>
</head>

<body>
    <jsp:include page="remove_blacklist_student_header.html"/>
    <table width="1112" height="361" align="center"  border="4" bgcolor="#CCFFFF">
    <tr>
      <td  height="43" colspan="3"><div align="center"><span class="style1">Remove BlackList Student </span></div></td>
      </tr>
    
    <tr>
     <td width="388">&nbsp;</td>
      <td width="289">
		<form method="post" action="blackListRecordRemove">
			<table width="292" height="92" align="center">
				<tr>
					<td width="49%" height="24" >UserID:</td>
	  	  	  		<td colspan="2" title="UserID"><input type="text" name="userid" ></td>
  	  	  		</tr>
				
				<tr>
					<td height="24">Branch:</td>
   									
   									<td width="51%"><select name="branch" >
												<option value=" " >  </option>
												<option value="ce">CE</option>
												<option value="ec">EC</option>
												<option value="it">IT</option>
												<option value="ic">IC</option>
												<option value="ch">CH</option>
												<option value="mc">MC</option>
												<option value="cl">CL</option>
								        </select>				  </td>
				</tr>
				<tr>
				  <td height="26"><input type="submit" value="Remove"/></td>
				  <td colspan="2">&nbsp;</td>
			  	</tr>
				<tr >
					<td colspan="2"><a href="blacklist_record_calculate_new"  title="See all Blacklist Student"/>See all Blacklist Student </td>
				</tr>
		  </table>
		</form>		</td>
      <td width="407" height="76"></td>
    </tr>
    <tr>
      <td width="388" height="212" colspan="3">&nbsp;</td>
      </tr>
	</table>
</body>
</html>
