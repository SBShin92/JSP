<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String name = request.getParameter("name");
	if (name == null) {
		name = "Anonymous";
	}
	%>
	<h1>Hello JSP World</h1>
    <p>안녕하세요, <%= name %></p>
    <p>이것은 JSP로 만들어진 동적 페이지 입니당</p>
</body>
</html>