<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%-- Generate the HTML response --%>
<html>
	<head>
		<title>Duke's Soccer League: List Leagues</title>
	</head>
	<body bgcolor='white'>

	<%-- Generate page heading --%>
	<!-- Page Heading -->
	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
			<td><h3>Duke's Soccer League: List Leagues</h3></td>
		</tr>
	</table>

	<%-- Generate main body --%>
	<p>
	The set of soccer leagues are:
	</p>

<ul>
    <c:forEach items="${leagueList}" var="league">
        <li>${league.title} (${league.year},${league.season})</li>
    </c:forEach>
</ul>

	</body>
</html>
