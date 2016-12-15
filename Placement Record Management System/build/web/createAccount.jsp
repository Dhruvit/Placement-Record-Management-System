<%-- 
    Document   : resumeupload1
    Created on : Mar 2, 2012, 10:59:10 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account | Placement Record Management System</title>
        <script type="text/javascript">
            
            window.history.forward(0);
            function giveMesg()
            {   
                            createAccountFor.userid.value = null;
                            //createAccountFor.userid.password = null;
                            alert("User already have account");
                            return true;
            }
            function noBack() 
            {
                window.history.forward(0);
            }
			
			/*function validateForm(createAccountForm)
			{
				
				
				if(createAccountForm.name.value == "") {
					//document.getElementById("errorName").innerHTML="Fill FirstName";
      				alert("Please enter UserID");
      				loginForm.name.focus();
      				return false;
    			}
			}*/
			
		</script>
			
        <style type="text/css">
		<!--
		.style1 {
			font-family: "Courier New", Courier, monospace;
			font-size: 24px;
			color: #FF3300;
		}
		.style2 {color: #990000}
		.style4 {color: #CC0000}
		-->
        </style>
</head>
    
<body >
            
    <jsp:include page="welcomeHeader.html"/>
    <%  String url = "jdbc:mysql://localhost/prms";
        String user_id = "root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt = null;
        
        ResultSet rs = null;
        String userid = request.getParameter("userid");
        
        String redirectURL = "http://localhost:8080/DDU_Placement_Cell/welcomeStudent.jsp";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
        
            try{
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                
                      
               
                //check is user already have account then give message
                
                rs = stmt.executeQuery("select * from Login_Table ");
                
                String user_id1 = null;
                
                while(rs.next())
                {
                    user_id1 = rs.getString("userid");
                    
                    if(user_id1.equals(userid))
                    {
                        
                        out.println("<html><body>");
                        out.println(" <script type = " + " text/javascript " + " > ");
                        //out.println("window.onload = giveMesg");
                        out.println("alert('User alredy have account')");
                        out.println("</script></body></html>"); 
                        //response.sendRedirect("http://localhost:8080/DDU_Placement_Cell/welcomeStudent.jsp");
                        break;
                    }
                    if((rs.isLast()) && (userid != null))
                    {   
                        %>
                        <jsp:forward page="loginTable"/>
                        <%
                      
                    }
                }
                stmt.close();
                con.close();
            }catch(SQLException e){}
        
        %>
    
    <table width="1112" height="500" align="center" border="4" bgcolor="#CCCCFF" >
    	<tr>
			
			<td width="1112" align="center">
				<p align="center" class="style6 style5 style1 style2"><strong>Create Account</strong></p> 
				<form name="createAccountForm" method="post" action="createAccount.jsp" >
				<table>
					
 		 
  					<tr>
  					  <td width="86" height="147"></td>
						<td colspan="2">
   							<table width="103%" border="0" >
   								<tr>
   									<td width="17%">UserID</td>
  	  	  				  	  	  <td width="83%"><input name="userid" type="text"  size="25" required pattern="[0-9]+" x-moz-errormessage="Enter UserId"></td>
		  				  	  	</tr>
 
			   					<tr>
   									<td>Password</td>
								  <td><input name="password1" type="password" size="25" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}"  onchange="form.password2.pattern = this.value;">
								    (min. 6 char, alphanumeric,containing Uppercase and lowercase letter(s))</td>
								</tr> 
  	 
  								<tr>
   									<td>Confirm Password</td>
        							<td><input name=" password2" type="password" size="25" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}"></td>
								</tr> 
   
 
  			 					<tr>
  			 					  <td height="24">Branch</td>
  			 					  <td>
								  <select name="branch" required >
												<option value=" " >  </option>
												<option value="ce">CE</option>
												<option value="ec">EC</option>
												<option value="it">IT</option>
												<option value="ic">IC</option>
												<option value="ch">CH</option>
												<option value="mc">MC</option>
												<option value="cl">CL</option>
							        </select>								  </td>
		 					  </tr>
  			 					<tr>
   									<td height="24">User Type </td>
   									<td>
									<select name="user_type" required>
   									  	<option value="na"></option>
   									  	<option value="Student">Student</option>
   									  	<option value="TPO">TPO</option>
   									  	<option value="Approver">Approver</option>
							        </select>									</td>
								</tr>
						  </table>					  </td>
					</tr>
					
					<tr>
					  <td></td>
					  <td width="123">&nbsp;</td>
					    <td width="632"><table align="left">
                          <tr>
                            <td align="center"><input name="submit" type="submit" value="Submit">
                            </td>
                            <td  align="left"><input name="reset" type="reset"  value="Clear"></td>
                          </tr>
                      </table></td>
					</tr>
				</table>	
				</form>

			</td>
		</tr>
    </table>	  
</body>
</html>

