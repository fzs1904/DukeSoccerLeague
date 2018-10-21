<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%-- Generate the HTML response --%>
<html>
	<head>
	  <title>Duke's Soccer League: Add a New League</title>
	  <s:head />
	  
	</head>
	<body bgcolor='white'>
	
	<%-- Generate page heading --%>
	<!-- Page Heading -->
	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
			<td><h3>Duke's Soccer League: ${pageTitle}</h3></td>
		</tr>
	</table>
	
	<%-- Report any errors (if any) --%>
	<s:actionerror/>
	
	<%-- Generate main body --%>
	<p>
	This form allows you to create a new soccer league.
	</p>

		<s:form action="add_league" method="POST">
			<s:textfield name="year" label="Year"/>
			<s:select list="seasons_list"
				name="season" label="Season"
				headerKey="UNKNOWN"
				headerValue="UNKNOWN"/>	
			<s:textfield name="title" label="Title"/>
			<s:submit value="Add League"/>
		</s:form>
	
	</body>
</html>
