<%@page import="emaillist.EmailListVO"%>
<%@page import="emaillist.EmailListDAOOracleImpl"%>
<%@page import="emaillist.EmailListDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>메일링 리스트: 가입 폼</title>
</head>

<body>
	<h1>메일링 리스트 수정</h1>
	<h3>원본</h3>
<%
	ServletContext context = getServletContext();
	String dbuser = context.getInitParameter("dbuser");
	String dbpass = context.getInitParameter("dbpass");
	Long no = Long.parseLong(request.getParameter("no"));

	EmailListDAO dao = new EmailListDAOOracleImpl(dbuser, dbpass);
	EmailListVO vo = dao.get(no);
%>
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<td>성</td>
			<td><%= vo.getLastName() %></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%= vo.getFirstName() %></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%= vo.getEmail() %></td>
		</tr>
	</table>
	<br>
	<form action="<%= request.getContextPath() %>/update.jsp?no=<%= no %>" method="POST">
		<label for="ln">성</label>
		<input type="text" name="ln" value="<%= vo.getLastName() %>"><br />
		<label for="fn">이름</label>
		<input type="text" name="fn" value="<%= vo.getFirstName() %>"><br />
		<label for="email">이메일</label>
		<input type="text" name="email" value=" <%= vo.getEmail() %>"><br />
		<input type="submit" value="수정">
	</form>

	<p>
		<a href="<%= request.getContextPath() %>">목록</a>
	</p>
</body>

</html>