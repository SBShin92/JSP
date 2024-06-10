<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!-- isErrorPage를 true로 바꾸면 exception 내장객체를 사용할 수 있다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<h1>Throw Exception Happened</h1>
	<p>Code: <%=
	  response.getStatus()
	%>
	</p>
	<p>Type: <%=
	  exception.getClass().getSimpleName()
	%></p>
	<p>Message: <%= exception.getMessage() %></p>

</body>
</html>