<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연산</h1>
	<ul>
		<li>${ iValue + fValue }</li>
		<li>iValue는 100보다 ${ iValue < 100 ? "작아" : "커" }</li>
		<li>null이면 true: ${ empty reqVal }</li>
		<li>존재하면 true: ${ not empty userVo }</li>
	</ul>
</body>
</html>