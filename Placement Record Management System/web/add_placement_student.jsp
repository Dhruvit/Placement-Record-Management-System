<%-- 
    Document   : add_placement_student
    Created on : 1 Dec, 2012, 4:00:21 PM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <style type="text/css">
<!--
.style1 {font-size: 20px}
.style5 {font-size: 20px; font-weight: bold; }
-->
        </style>
</head>
    <body>
    <jsp:include page="headerAdmin.html"/>
    <table width="1112" height="451" align="center"  border="4" bgcolor="#CCFFFF">
    <tr>
      <td  height="43" colspan="3"><div align="center"><span class="style5">Add Student Who are Placed in company </span></div></td>
      </tr>
    
    <tr>
     <td width="371">&nbsp;</td>
      <td width="369">
		<form method="post" action="add_placement_student">
			<table width="366" height="196" align="center">
				<tr>
				  <td height="24" >Userid</td>
				  <td colspan="2" title="UserID"><input type="text" name="userid" ></td>
			  </tr>
				<tr>
					<td width="49%" height="24" >Company Name </td>
	  	  	  		<td colspan="2" title="UserID">
						<select name="compant_name" >
												<option value=" " >Select Company</option>
												<option value="TCS">TCS</option>
												<option value="Infibeam">Infibeam</option>
												<option value="NeoDigital">NeoDigital</option>
												<option value="Zeus">Zeus</option>
												<option value="Cybage">Cybage</option>
												<option value="Meditab">Meditab</option>
												<option value="Infostratch">Infostratch</option>
												<option value="Matrix">Matrix</option>
												<option value="Cybridge">Cybridge</option>
												<option value="Tatvic">Tatvic</option>
												<option value="Maruti Technology">Maruti Technology</option>
			          </select>					</td>
  	  	  		</tr>
				
				<tr>
					<td height="24">Branch</td>
   									
   									<td width="51%"><select name="branch" >
												<option value=" " >--</option>
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
				  <td height="26">Subject</td>
				  <td colspan="2">
				  	<select name="subject" id="subject">
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
			        </select>				  </td>
			  </tr>
				<tr>
				  <td height="26">Year</td>
				  <td colspan="2">
				  	<select name="year" >
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
										<option value="2011">2011</option>
										<option value="2012">2012</option>
										<option value="2013">2013</option>
				    </select>				  </td>
			  </tr>
				<tr>
				  <td height="26"><input type="submit" value="Add"/></td>
				  <td colspan="2">&nbsp;</td>
			  	</tr>
				<tr >
					<td height="28" colspan="2"><a href="see_placed_student.jsp"  title="See all Blacklist Student" name="blacklistrecord" />Analysis of  Placed Student </td>
				</tr>
		  </table>
	  </form>		</td>
      <td width="344" height="180"></td>
    </tr>
    <tr>
      <td height="212" colspan="3">&nbsp;</td>
      </tr>
	</table>
</body>
</html>
