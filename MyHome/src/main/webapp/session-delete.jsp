<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>

<%
session.removeAttribute("sess1");
session.removeAttribute("sess2");
session.invalidate();
response.sendRedirect("session-read.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Redirect Page</title>
</head>
<body>


</body>
</html>