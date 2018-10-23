<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Generate the HTML response --%>
<html>
	<head>
	  <title>Duke's Soccer League: Add a New League</title>
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
	<c:forEach items="${errorMsgs}" var="errorMsg">
		<b><font color="red">${errorMsg}</font></b><br/>
	</c:forEach>
	
	<%-- Generate main body --%>
	<p>
	This form allows you to create a new soccer league.
	</p>
	<c:url value="/add_league.do" var="actionURL"/>
	<form action="${actionURL}" method="POST" >
	    <%-- Repopulate the year field --%>
	    Year: <input type="text" name="year" value="${param.year}"/>
	    <br/><br/>
	    
	    <%-- Repopulate the season drop-down menu --%>
	    Season:
	    <select name='season'>
    		<option value="UNKNOWN">UNKNOWN</option>
            <c:forEach var="season" items="${seasons_list}" >
            	<c:if test="${season eq param.season}">
            		<c:set var="selected" value="selected"/>
            	</c:if>
                <option value="${season}" ${selected}>${season}</option>
            </c:forEach>
	    </select>
	    <br/><br/>
	    
	    <%-- Repopulate the title field --%>
	    Title: <input type="text" name="title" value="${param.title}"/>
	    <br/><br/>
	    <%-- The submit button --%>
	    <input type="submit" value="Add League" />
	</form>
	
	</body>
</html>
