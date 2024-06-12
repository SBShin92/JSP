<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
<link type="text/css" 
	rel="stylesheet" 
	href="<%= request.getContextPath() %>/css/guestbook.css"/>

</head>
<body>
	<div id="guestbook" class="delete-form">
		<form action="<%= request.getContextPath() %>/gb" method="POST">
		<input type="hidden" name="no" value="<%= request.getParameter("no") %>">
		<input type="hidden" name="a" value="delete">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="확인"></td>
				<td><a href="<%= request.getContextPath() %>/gb">삭제 취소</a></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>