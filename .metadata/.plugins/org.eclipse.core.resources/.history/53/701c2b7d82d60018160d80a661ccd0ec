<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%-- Generate the HTML response --%>
<html>
	<head>
	  <title>Duke's Soccer League: Registration</title>
	<s:head/>
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
		  <td bgcolor='#CCCCFF' align='center' valign='center' height='20'>
		    <b>1) Select League</b>
		  </td>
		  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
		    <b>2) Enter Player Info</b>
		 </td>
		  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
		    <b>3) Select Division</b>
		  </td>
		</tr>
		</table>
		<br/>
		
		<%-- Report any errors (if any) --%>
		<s:actionerror/>
		
		<%-- Present the form --%>
		<s:form action="reg_select_league" method="POST">
		<s:textfield name="league.year" label="Year"/>
		<s:select list="seasons_list"
			name="league.season" label="Season"
			headerKey="UNKNOWN"
			headerValue="UNKNOWN"/>
		<s:submit value="Continue..."/>
		</s:form>
	</body>
</html>
