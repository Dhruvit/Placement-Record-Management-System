
<%-- 
    Document   : welcome
    Created on : Feb 26, 2012, 12:14:30 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,foo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome | Placement Record Management System</title>
        <script type="text/javascript">
			function giveMesg()
                        {   
                            loginForm.userid.value = null;
                            loginForm.userid.password = null;
                            alert("User not have account..Please create acoount");
                            return true;
                        }
           
			function checkForm(loginForm)
  			{		
    		
    			if(loginForm.userid.value == "") {
      				alert("Please enter UserID");
      				loginForm.userid.focus();
      				return false;
    			}
			
				if(loginForm.password.value == "") {
      				alert("Please enter Password");
      				loginForm.password.focus();
      				return false;
    			}
                        
                                if(loginForm.type.value == null) {
      				alert("Please select type");
      				loginForm.password.focus();
      				return false;
    			}
			
			
    			if(loginForm.userid.value != "" ) {
      			
					if(loginForm.userid.value.length > 6 || loginForm.userid.value.length < 6) {
        				alert("Only allow six digit UserID");
        				loginForm.userid.value = null;
						loginForm.userid.focus();
        				return false;
      				}
					
					re = /^[0-9]{6,7}$/;
					if(!re.test(loginForm.userid.value) )
					{
						alert("Only allow numeric UserID ");
						loginForm.userid.value = null; 
      					loginForm.userid.focus();
      					return false;
    				}
				
				}
			
				if(loginForm.password.value != "" && loginForm.password.value == loginForm.password.value) {
      				if(loginForm.password.value.length <= 4) {
        				alert("Password must contain at least four characters!");
        				loginForm.password.value = null;
						loginForm.password.focus();
        				return false;
      				}
     				
					if(loginForm.password.value == loginForm.id.value) {
        				alert("Password must be different from Username!");
        				loginForm.password.value = null;
						loginForm.userid.value = null;
						loginForm.userid.focus();
        				return false;
      				}
					
      			return true;
  				}
			}

		</script>
        <style type="text/css">
    <!--
    .style1 {
            font-family: "Times New Roman", Times, serif;
            font-size: 36px;
            color: #FF3300;
            font-weight: bold;
    }
    -->
    </style>
	

    </head>
    <body>
            
    <jsp:include page="welcomeHeader.html"/>
    
    <%  String url = "jdbc:mysql://localhost/prms";
        String user_id = "root";
        String user_pass = "root";
        Connection con = null; 
        Statement stmt = null;
        
        ResultSet rs = null;
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String user_type = request.getParameter("user_type");
        
       // System.out.println("type :::"+type);
        String redirectURL = "http://localhost:8080/DDU_Placement_Cell/welcomeStudent.jsp";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                }catch(ClassNotFoundException e){System.out.println("ClassNotFoundException in mysql");}
        
            try{
                con = DriverManager.getConnection(url,user_id,user_pass);
                stmt = (Statement)con.createStatement();
                
                      
                   
                     //check is user haven't account then give message to create account
                
                    rs = stmt.executeQuery("select * from Login_Table ");
                
                    String user_id1 = null;
                    String user_pass1 = null;
                    String user_type1 = null;
                    while(rs.next())
                    {
                        user_id1 = rs.getString("userid");
                        user_pass1 = rs.getString("password");
                        user_type1 = rs.getString("user_type");
                        if((user_id1.equals(userid)) && (user_pass1.equals(password)) && (user_type1.equals(user_type)))
                        {
                            if(user_type.equals("Student"))
                            {
                              %>
                              <jsp:useBean id="student" class="foo.Student" scope="request">
                                 <jsp:setProperty name="student" property="userid" param="userid" />
                              </jsp:useBean>
                             <jsp:forward page="session_student"/>
                               <%
                            }
                            else if(user_type.equals("TPO"))
                            {
                            %>
                             <jsp:useBean id="tpo" class="foo.TPO" scope="request">
                                 <jsp:setProperty name="tpo" property="userid" param="userid" />
                             </jsp:useBean>
                             <jsp:forward page="session_tpo"/>
                               <%
                            }
                            else if(user_type.equals("Approver"))
                            {
                            %>
                             <jsp:useBean id="approver" class="foo.Approver" scope="request">
                                 <jsp:setProperty name="approver" property="userid" param="userid" />
                             </jsp:useBean>
                             <jsp:forward page="session_approver"/>
                               <%
                            }
                                    
                        }
                        if((rs.isLast()) && (userid != null) && (password != null))
                        {
                          out.println("<html><body>");
                          out.println(" <script type = " + " text/javascript " + " > ");
                          out.println("window.onload = giveMesg");
                          out.println("</script></body></html>");  
                        }
                    }
                  
                 
                stmt.close();
                con.close();
            }catch(SQLException e){}
        
        %>
            <table width="1112" height="500" align="center" border="4" bgcolor="#CCFFFF">
			
            <tr>
            <td height="135" align="center">
            <form action="welcome.jsp" method="post" name="loginForm"  onSubmit="return checkForm(this);">
              <table width="300" height="84" border="0">
                <tr>
                  <p align="center"><strong><font size="5">User Login</font></strong></p>
                </tr>
				<tr>
					<td><p>Type:</p></td>
                  	<td>
						<select name="user_type" required x-moz-errormessage="Select User Type" >
							<option value=" " >--Select One--</option>
							<option value="Student">Student</option>
							<option value="TPO">TPO</option>
                                                        <option value="Approver">Approver</option>
						</select>
					</td>
				</tr>
                <tr>
                  <td><p>UserID:</p></td>
                  <td><input type="text" name="userid" align="right" required pattern="[0-9]+"/></td>
                  
                </tr>
                <tr>
                  <td><p>Password:</p></td>
                  <td><input type="password" name="password"  align="right" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}"/></td>
                  
                </tr>
                <tr>
                  <td><input name="submit" type="submit" value="Login"  onClick="return validateForm(this);"/></td>
                  <td><a href="createAccount.jsp" >Create Account</a></td>
                </tr>
              </table>
            </form>	
			</td>
            </tr>
			
	</table>
        
    </body>
</html>
