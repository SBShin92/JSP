<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>Session 읽기</h3>
  <%
  String sess1 = (String)session.getAttribute("sess1");
  Integer sess2 = (Integer)session.getAttribute("sess2");
  %>
  <p>sess1: <%= sess1 %></p>
  <p>sess2: <%= sess2 %></p>
  <p>세션 설정한 유지시간(초): <%= session.getMaxInactiveInterval() %></p>
  <p>세션 타이머(초): <%= (session.getLastAccessedTime() - session.getCreationTime()) / 1000 %></p>

  
  <p><a href="session-write.jsp">세션 저장</a></p>
  <p><a href="session-delete.jsp">세션 삭제</a></p>
  

</body>
</html>