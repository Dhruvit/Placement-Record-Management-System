<%-- 
    Document   : Student_details
    Created on : 16 Nov, 2012, 11:15:12 AM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,foo.*"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Details | Placement Record Management System</title>
        <script type="text/javascript">
            var goTarget 
			function setValue()
			{
                            //set default value
                            if ("${studentdatarecord[3]}" == "male"){
                            // Radiobutton "No" should be selected.
                            document.getElementById("female").checked = false;
                            document.getElementById("male").checked = true;
                            }
                            else if ("${studentdatarecord[3]}" == "female"){
                            // Radiobutton "Yes" should be selected.
                            document.getElementById("male").checked = false;
                            document.getElementById("female").checked = true;
                            }
							
							if ("${studentdatarecord[19]}" == "1"){
                            // Radiobutton "No" should be selected.
                            document.getElementById("no_interest").checked = false;
                            document.getElementById("yes_interest").checked = true;
                            }
                            else if ("${studentdatarecord[19]}" == "0"){
                            // Radiobutton "Yes" should be selected.
                            document.getElementById("yes_interest").checked = false;
                            document.getElementById("no_interest").checked = true;
                            }
							
                            //document.getElementById("gender").value = "${studentdatarecord[3]}"; 
                            document.getElementById("day").value = "${studentdatarecord[16]}"; 
                            document.getElementById("month").value = "${studentdatarecord[17]}"; 
                            document.getElementById("year").value = "${studentdatarecord[18]}"; 
                            document.getElementById("branch").value = "${studentdatarecord[6]}"; 
							document.getElementById("subject").value = "${studentdatarecord[20]}"; 
                                
                        }

			function setTarget(target){ 
			goTarget = target;
			 } 

			function gotoTarget(form) {
			
			//remember to leave action field blank when defining the form 
			if(goTarget == 0) document.myform.action="stuDb"; 
			if(goTarget == 1) document.myform.action="setSubmit"; 
			}
        </script>
    </head>
    <body onLoad="return setValue()">
	
        <jsp:include page="headerStudent.html"/>
    ${requestScope.alert}
    <table width="1112" height="500" align="center" border="4" bgcolor="#CCFFFF">
        <tr>
            <td align="center">
                <form method="post" name="myform" onSubmit="return gotoTarget(this)" action="" id="myform" onload="return setValue()">
                    	<table width="1020" align="center">
					<tr>
                                            <jsp:useBean id="student" class="foo.Student" scope="session"/>
                                            <td colspan="3"><p align="center"><strong><font size="5"> Student Details:: <jsp:getProperty name="student" property="userid"/>
                                                            
                                                            </font></strong></p></td>
					</tr>
 		 
  					<tr>
						<td width="146" height="370"></td>
						<td colspan="2">
   							<table width="93%" border="0" >
   								<tr>
                                                                    <td width="19%">Student's Name</td>
  	  	  				  	  	    <td width="81%"><input type="text" name="student_name" size="60" value="${studentdatarecord[0]}" ${studentdatarecord[14]} required ></td>
								</tr>
 
			   					<tr>
   									<td>Father's Name </td>
   									<td><input type="text" name="father_name" size="60" value="${studentdatarecord[1]}"  required  ${studentdatarecord[14]}></td>
   								</tr> 
  	 
  								<tr>
   									<td>Mother's Name </td>
        							<td><input type="text" name="mother_name" size="60" value="${studentdatarecord[2]}" required  ${studentdatarecord[14]}></td>
   								</tr> 
								<tr>
									<td>Gender</td>
									<td>
                                                                            <input type="radio" required x-moz-errormessage="Select Your Sex" name="gender" id="male" value="male"   ${studentdatarecord[14]}  ${studentdatarecord[15]}/>Male
                                                                            <input type="radio" required x-moz-errormessage="Select Your Sex" name="gender" value="female" id="female" ${studentdatarecord[14]}  ${studentdatarecord[15]}/>Female                                   </td>
								</tr>

   								
   								<tr>
   									<td>Date Of Birth</td>
   									<td>
										<select name="day" required  ${studentdatarecord[15]}  id="day">
										<option value="na">Day</option>
										<option value="01" selected="selected">1</option>
										<option value="02">2</option>
										<option value="03">3</option>
										<option value="04">4</option>
										<option value="05">5</option>
										<option value="06">6</option>
										<option value="07">7</option>
										<option value="08">8</option>
										<option value="09">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
										</select>
									
										<select name="month"  ${studentdatarecord[15]} id="month" >
										<option value="na">Month</option>
										<option value="01" selected="selected">January</option>
										<option value="02">February</option>
										<option value="03">March</option>
										<option value="04">April</option>
										<option value="05">May</option>
										<option value="06">June</option>
										<option value="07">July</option>
										<option value="08">August</option>
										<option value="09">September</option>
										<option value="10">October</option>
										<option value="11">November</option>
										<option value="12">December</option>
										</select>
															
										<select name="year"  ${studentdatarecord[15]} id="year">
										<option value="na">Year</option>
										<option value="1980" selected="selected">1980</option>
										<option value="1981">1981</option>
										<option value="1982">1982</option>
										<option value="1983">1983</option>
										<option value="1984">1984</option>
										<option value="1985">1985</option>
										<option value="1986">1986</option>
										<option value="1987">1987</option>
										<option value="1988">1988</option>
										<option value="1989">1989</option>
										<option value="1990">1990</option>
										<option value="1991">1991</option>
										<option value="1992">1992</option>
										<option value="1993">1993</option>
										<option value="1994">1994</option>
										<option value="1995">1995</option>
										<option value="1996">1996</option>
										<option value="1997">1997</option>
										<option value="1998">1998</option>
										<option value="1991">1999</option>
										<option value="2000">2000</option>
										<option value="2001">2001</option>
										<option value="2002">2002</option>
										<option value="2003">2003</option>
										<option value="2004">2004</option>
										<option value="2005">2005</option>
										<option value="2006">2006</option>
										<option value="2007">2007</option>
										<option value="2008">2008</option>
										<option value="2009">2009</option>
										<option value="2010">2010</option>
									  </select>        							</td>
   								</tr>
								
								<tr>
   									<td>Email Id</td>
                                                                        <td><input  type="email" size="60" name="email_id" value="${studentdatarecord[5]}" placeholder="me@example.com" ${studentdatarecord[14]}></td>
   								</tr>
								
								<tr>
								  <td height="29">Interested in Placement </td>
								  <td><label>
								    <input name="interest" type="radio" value="1" id="yes_interest" ${studentdatarecord[14]}  ${studentdatarecord[15]} />
								    Yes
							        <input name="interest" type="radio" value="0"  id="no_interest" ${studentdatarecord[14]}  ${studentdatarecord[15]}/>
							        No</label></td>
							  </tr>
								<tr>
								  <td height="29">Interested Subject </td>
								  <td>
								  		<select name="subject" required  ${studentdatarecord[15]} id="subject">
												<option value=" " >Select Subject</option>
												<option value="Java/J2EE">Java/J2EE</option>
												<option value=".Net">.Net</option>
												<option value="Perl">Perl</option>
												<option value="C++">C++</option>
												<option value="Embedded">Embedded</option>
												<option value="Wireless">Wireless</option>
												<option value="VlSI">VlSI</option>
												<option value="Power">Power</option>
												<option value="Structure">Structure</option>
								        </select>
								  </td>
							  </tr>
								<tr>
   									<td height="29">Branch</td>
   									<td><select name="branch" required  ${studentdatarecord[15]} id="branch">
												<option value=" " >--</option>
												<option value="ce" selected="selected">CE</option>
												<option value="ec">EC</option>
												<option value="it">IT</option>
												<option value="ic">IC</option>
												<option value="ch">CH</option>
												<option value="mc">MC</option>
												<option value="cl">CL</option>
								        </select>									</td>
							  </tr> 
									
								  <tr> 
								      <td height="23">Address</td>
						            <td rowspan="2">
								      <textarea  cols="46.5" rows="5" name="address" ${studentdatarecord[14]}>${studentdatarecord[7]}</textarea>								      </td>
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
   								<td width="16%">B.Tech(CPI)</td>
					  	  	  	<td width="24%"><input type="text" name="btech" value="${studentdatarecord[8]}" maxlength="3" ${studentdatarecord[14]} required ></td>
								<td width="15%">Passing Year</td>
					  	  	  <td width="45%"><input type="text" name="pass_btech" value="${studentdatarecord[9]}" required  ${studentdatarecord[14]}></td>
   							</tr> 
   
  		 					<tr>
   								<td>H.S.C</td>
   								<td><input type="text" name="result_hsc" value="${studentdatarecord[10]}" required  ${studentdatarecord[14]}></td>
								<td>Passing Year</td>
   								<td><input type="text" name="pass_hsc" value="${studentdatarecord[11]}" required  ${studentdatarecord[14]}></td>
   							</tr> 
   
   
   							<tr>
   								<td>S.S.C</td>
   								<td><input type="text" name="result_ssc" value="${studentdatarecord[12]}" required  ${studentdatarecord[14]}></td>
								<td>Passing Year </td>
   								<td><input type="text" name="pass_ssc" value="${studentdatarecord[13]}" required  ${studentdatarecord[14]}></td>
							</tr> 
						    </table>						
						</td>
					</tr>
					
					<tr>
						<td></td>
				
						<td width="134">&nbsp;</td>
					    <td width="724"><table align="left">
                          <tr>
                            <td align="center"><input name="save" type="submit" value="Save" onClick="setTarget(0)" ${studentdatarecord[14]} ${studentdatarecord[15]}/></td>
                            <td  align="left"><input name="reset" type="reset"  value="Clear" ${studentdatarecord[14]} ${studentdatarecord[15]}></td>
			    <td  align="left"><input name="submit" type="submit"  value="Submit" onClick="setTarget(1)" ${studentdatarecord[14]} ${studentdatarecord[15]}></td>
                          </tr>
                        </table></td>
					</tr>
				</table>	
				</form>

			</td>
		</tr>
    </table>
                </form>
            </td>
        </tr>
    </table>
	
    </body>
</html>
