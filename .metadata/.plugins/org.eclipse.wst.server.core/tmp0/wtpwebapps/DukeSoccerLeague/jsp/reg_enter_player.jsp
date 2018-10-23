<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Generate the HTML response --%>
<html>
	<head>
	  <title>${pageTitle}</title>
	</head>
	<body bgcolor='white'>
	
		<%-- Generate page heading --%>
		<!-- Page Heading -->
		<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
		  <td><h3>Duke's Soccer League: Registration</h3></td>
		</tr>
		</table>
	
		<%-- Create the Progress Monitor --%>
		<br/>
		<table border='1' cellspacing='0' cellpadding='0' width='400'>
		<tr height='20'>
		  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
		    <b>1) Select League</b>
		  </td>
		  <td bgcolor='#CCCCFF' align='center' valign='center' height='20'>
		    <b>2) Enter Player Info</b>
		 </td>
		  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
		    <b>3) Select Division</b>
		  </td>
		</tr>
		</table>
		<br/>
		
		<%-- Report any errors (if any) --%>
		<c:if test="${not empty errorMsgs}">
		  <p>
		  <font color='red'>Please correct the following errors:
		  <ul>
		  <c:forEach var="message" items="${errorMsgs}">
		    <li>${message}</li>
		  </c:forEach>
		  </ul>
		  </font>
		  </p>
		</c:if>
		
		<%-- Present the form --%>
		<c:url value="/reg_enter_player.do" var="actionURL"/>	
		<form action='${actionURL}' method='POST'>
			<%-- Repopulate the year field --%>
			Name: <input type='text' name='name' value='${param.name}' /> <br/><br/>
			Address: <input type='text' name='address' value='${param.address}' /> <br/><br/>
			City: <input type='text' name='city' value='${param.city}' /> <br/><br/>
			Province: <input type='text' name='province' value='${param.province}' /> <br/><br/>
			Postal code: <input type='text' name='postalCode' value='${param.postalCode}' /> <br/><br/>
			<input type='Submit' value='Continue...' />
		</form>		
	</body>
</html>
