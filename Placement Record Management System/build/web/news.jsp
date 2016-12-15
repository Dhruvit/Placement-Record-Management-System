<%-- 
    Document   : news
    Created on : 24 Nov, 2012, 11:54:24 AM
    Author     : DHRUVIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>News | Placement Record Management System</title>
        <style type="text/css">
<!--
.style2 {
	color: #FF6666;
	font-weight: bold;
}
.style3 {color: #FF0000}
-->
        </style>
</head>
    <body>
        <jsp:include page="welcomeHeader.html"/>
	<table width="1112" height="500" align="center"  border="4" bgcolor="lemonchiffon">
		<tr>
			<td height="32" colspan="4" bgcolor="#CCCCFF">			</td>
		</tr>
		<tr>
			<td width="116" height="284" rowspan="2" bgcolor="#CCCCFF">			</td>
		    <td width="425" height="29" bgcolor="lightskyblue"><div align="center"><strong>TPO Update </strong></div></td>
		    <td width="425" bgcolor="lightskyblue"><div align="center"><strong>2012 Placement </strong></div></td>
		    <td width="116" rowspan="2" bgcolor="#CCCCFF"></td>
		</tr>
		<tr>
		  <td bgcolor="#CCFFFF">
		  		<marquee height="250px" id="sli" scrollamount="2" scrolldelay="1" direction="up" onMouseOver="this.setAttribute('scrollamount', 0, 0);" onMouseOut="this.setAttribute('scrollamount', 2, 0);" style="font-family:cambria;padding-left:5px">
                                    <c:forEach var="listElement" items="${tpoupdate}">	
                                        <li style="color: #000000;font-size:15px">&#187; ${listElement[0]}:${listElement[1]}<br />
    					<a href="${listElement[2]}" style="color: #FF0000;font-size:15px">Click Here!</a><img alt="new" src="img/newimage2.gif"><br />
    					</br>
					</li>
                                    </c:forEach>    
				</marquee>
		  </td>
	      <td width="425" bgcolor="#CCFFFF">
		  	<marquee height="250px" id="sli" scrollamount="2" scrolldelay="1" direction="up" onMouseOver="this.setAttribute('scrollamount', 0, 0);" onMouseOut="this.setAttribute('scrollamount', 2, 0);" style="font-family:cambria;font-size:15px;padding-left:5px;font-weight:20px" >

				<ul style="list-style: disc">
    				<li style="color: #FF0000;">
					<center>
	  					<span>Congratulations to all the students.</span>
					</center><br>
                                        <c:forEach var="listElement1" items="${placementnews}">
					<li style="color: #000000">&#187; ${listElement1[0]} - ${listElement1[1]} Students
                                            <div class="hidden-container"></div><br /></c:forEach>
    				<br />
    
       			</ul>
			</marquee>
		  </td>
	  </tr>
		<tr>
			<td height="31" colspan="4" bgcolor="#CCCCFF">			</td>
		</tr>
	</table>
    </body>
</html>
