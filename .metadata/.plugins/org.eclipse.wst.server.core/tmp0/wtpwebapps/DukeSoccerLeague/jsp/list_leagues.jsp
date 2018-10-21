<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="/struts-tags" prefix="s" %>
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

    <s:iterator value="leagueList" var="league" status="loopStatus">
        <s:if test = "#loopStatus.odd">
    		<s:set var="color" value="'#DCDCDC'"/>
    	</s:if>
    	<s:else>
    		<s:set var="color" value="'F8F8F8'"/>
    	</s:else>
    	<li style="background-color:<s:property value='color'/>" >
    	${league.title}(${league.year},${league.season})
    	</li>
    </s:iterator>
</ul>

	</body>
</html>
