<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page session="true"%>

<%
session.setAttribute("sess1", "문자열세션");
session.setAttribute("sess2", 2024);

session.setMaxInactiveInterval(5);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>세션 변수 저장</h3>
  <p><a href="session-read.jsp">세션 변수 확인</a></p>

</body>
</html>