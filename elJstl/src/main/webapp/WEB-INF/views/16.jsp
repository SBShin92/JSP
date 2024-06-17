<%@page import="vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Variable Set</h1>
	<% String greeting = "Hello World"; %>
	<p><b>greeting</b> : <%= greeting %>
	<h1>Java Beans Set</h1>
	<%
	UserVo memberInfo = (UserVo)request.getAttribute("memberInfo");
	
	memberInfo.setName("홍길동");
	memberInfo.setGender("남성");
	memberInfo.setNo(1);
	memberInfo.setEmail("hong@hwalbin.org");
	%>
	<p><b>memberInfo</b> : <%= memberInfo %>
	
</body>
</html>