<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Student Record | Placement Record Management System</title>
 <style type="text/css">
		<!--
		.style1 {
			font-family: "Courier New", Courier, monospace;
			font-size: 24px;
			color: #FF3300;
		}
		.style2 {color: #990000}
.style3 {
	font-size: 18px;
	font-weight: bold;
}
		-->
        </style>
</head>

<body>
	<jsp:include page="headerAdmin.html"/>
        ${requestScope.alert}
	<table width="1112" height="500" align="center" border="4" bgcolor="#CCFFFF" >
    	<tr>
			
			<td width="1112" align="center">
				<p align="center" class="style2 style1 style6"><strong>Select Student As Per Aggregate Criteria </strong></p> 
				<form name="createAccountForm" method="post" action="record_calculate" id="myForm" onSubmit="return validateForm(this);">
				<table>
					
  					<tr>
						<td width="248" height="30"></td>
						<td width="527">
   							<table width="61%" border="0" >
								<tr>
									<td width="48%">Enter Aggregate(CPI)</td>
								  <td width="52%"><input name="aggregate" type="text" size="20"/></td>
								</tr>
						  </table>
					  </td>
					</tr>
   					
					<tr>
						<td height="194">						</td>
						
						<td>	
     						<table width="52%" border="0" align="left">
   							<tr>
   									<td width="56%">Select Branch </td>
                                    <td width="44%"><input name="branch" type="checkbox" id="branch" value="ce" checked="checked"/> 
                              CE</td>
                             
							</tr>
							<tr>
   									<td>&nbsp;</td>
                                                                        <td><input name="branch" type="checkbox" id="branch" value="ec" />
                                                                        EC</td>
							</tr>
							<tr>
   									<td>&nbsp;</td>
                                                                        <td><input name="branch" type="checkbox" id="branch" value="it" />
                                                                        IT</td>
							</tr>
							<tr>
   									<td>&nbsp;</td>
                                                                        <td><input name="branch" type="checkbox" id="branch" value="ic" />
                                                                        IC</td>
							</tr>
							<tr>
   									<td>&nbsp;</td>
                                                                        <td><input name="branch" type="checkbox" id="branch" value="ch" />
                                                                        CH</td>
							</tr>
							<tr>
   									<td>&nbsp;</td>
                                                                        <td><input name="branch" type="checkbox" id="branch" value="cl" />
                                                                        CL</td>
							</tr>
							<tr>
   									<td>&nbsp;</td>
                                                                        <td><input name="branch" type="checkbox" id="branch" value="mc" />
                                                                        MC</td>
							</tr>	
							</table>
						</td>
					</tr>
					<tr>
						<td>
						
						</td>
				
						<td>
							<table width="275" align="left">
							<tr>
   									<td width="56%" height="24">BlackList Student  </td>
                                                                        <td width="44%"><input type="radio" name="blacklist" value="remove" checked="checked" />
                              Remove</td>
							</tr>
							<tr>
   									<td>&nbsp;</td>
                                                                        <td><input type="radio" name="blacklist" value="notremove" />
                                                                        Not Remove</td>
									
   							</tr> 
						  </table>
						</td>
					</tr>
					
					<tr>
						<td>
						
						</td>
				
						<td>
							<table align="left">
							<tr>
   								<td align="center"> <input type="submit" value="Submit" > </td>
   								
   							</tr> 
   							</table>
						</td>
					</tr>
				</table>	
				</form>

			</td>
		</tr>
</table>	  
</body>
</html>
