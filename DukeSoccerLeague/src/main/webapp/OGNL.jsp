<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<p>
	<s:set var="color" value="'Blue'"/>
	color:<s:property value="color"/><br/>
	color:<s:property value="#color"/>
</p>
<p>
	<s:set var="fruit" value="'Apple'" scope="page"/>
	fruit:<s:property value=""/><br/>
</p>
<p>
	<s:set var="user" value="'Eric'" scope="page"/>
	<s:set var="user" value="'David'" scope="request"/>
	user:<s:property value=""/><br/>

</p>
<p>
	<s:set var="sex" value="#{'M':'Male','girl':'Female'}"/>
	#sex.M:<s:property value="M"/><br/>
	#sex.girl:<s:property value="girl"/><br/>
</p>				
</body>
</html>