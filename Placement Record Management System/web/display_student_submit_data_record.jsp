<%-- 
    Document   : display_student_data_record
    Created on : 19 Nov, 2012, 9:13:43 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Student Details | Placement Record Management System</title>
        <script type="text/javascript">
            var goTarget 

			function setTarget(target){ 
			goTarget = target;
			 } 

			function gotoTarget(form) {
			
			//remember to leave action field blank when defining the form 
			if(goTarget == 0) document.display_student_data.action="setApprove"; 
			if(goTarget == 1) document.display_student_data.action="setnotApprove"; 
                        if(goTarget == 2) document.display_student_data.action="sendMessageToStudent.jsp";
			}
        </script>
    </head>
    <body>
        <jsp:include page="display_student_submit_data_record_header.html"/>  
        ${requestScope.alert}
        <table width="1112" height="500" align="center" border="4" bgcolor="#CCFFFF">
        <tr>
            <td align="center">
                <form method="post" name="display_student_data" action="" onSubmit="return gotoTarget(this)" >
                    	<table width="1020" align="center">
					<tr>
                                            
                                            <td colspan="3"><p align="center"><strong><font size="5"> Student Details::   UserId = ${studentdatarecord[14]}
                                                            
                                                            </font></strong></p></td>
					</tr>
                                        
  					<tr>
						<td width="146" height="169"></td>
						<td colspan="2">
   							<table width="93%" border="0" >
   								<tr>
   									<td width="17%">Student's Name:</td>
  	  	  				  	  	    <td width="83%">${studentdatarecord[0]}</td>
								</tr>
 
			   					<tr>
   									<td>Father's Name : </td>
   									<td>${studentdatarecord[1]}</td>
   								</tr> 
  	 
  								<tr>
   									<td>Mother's Name : </td>
        							<td>${studentdatarecord[2]}</td>
   								</tr> 
								<tr>
									<td>Gender:</td>
									<td>
									${studentdatarecord[3]}
									</td>
								</tr>

   								
   								<tr>
   									<td>Date Of Birth:</td>
   									<td>${studentdatarecord[4]}</td>
   								</tr>
								
								<tr>
   									<td>Email Id:</td>
        							<td>${studentdatarecord[5]}</td>
   								</tr>
								
								<tr>
   									<td height="29">Branch:</td>
   									<td>${studentdatarecord[6]}        				
									</td>
   								 </tr> 
									
								  <tr> 
								      <td height="23">Address:</td>
       							      <td rowspan="2">
									  	<textarea  cols="46.5" rows="5" name="address" disabled="disabled">${studentdatarecord[7]}</textarea>
									  </td>
								  </tr>
								  <tr>
							      	<td></td>
						      	  </tr>  
						  </table>	
						</td>
					</tr>
   					
					<tr>
						<td colspan="3" align="center">
	   						<p align="center"><strong><font size="5"> Educational Details::</font></strong></p> 
  						</td>
					</tr>
					
					<tr>
						<td></td>
						<td colspan="2">	
     						<table width="99%" border="0" align="left">
   							<tr>
   								<td width="16%">B.Tech(CPI):</td>
					  	  	  	<td width="24%">${studentdatarecord[8]}</td>
								<td width="15%">Passing Year:</td>
					  	  	    <td width="45%">${studentdatarecord[9]}</td>
   							</tr> 
   
  		 					<tr>
   								<td>H.S.C:</td>
   								<td>${studentdatarecord[10]}</td>
								<td>Passing Year:</td>
   								<td>${studentdatarecord[11]}</td>
   							</tr> 
   
   
   							<tr>
   								<td>S.S.C:</td>
   								<td>${studentdatarecord[12]}</td>
								<td>Passing Year : </td>
   								<td>${studentdatarecord[13]}</td>
							</tr> 
						    </table>						
						</td>
					</tr>
					
                                        
					<tr>
						<td></td>
				
						<td width="134">&nbsp;</td>
					    <td width="724"><table align="left">
                          <tr>
                            <td align="center"><button name="userid" value="${studentdatarecord[14]}" onClick="setTarget(0)" type="submit">Approve</button></td>
			    <td  align="left"><button name="userid" value="${studentdatarecord[14]}" onClick="setTarget(1)" type="submit">Not Approve</button>
				</td>
                            <td  align="left"><button name="userid" value="${studentdatarecord[14]}" onClick="setTarget(2)" type="submit">Send Message</button></td>
                          </tr>
                        </table></td>
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
