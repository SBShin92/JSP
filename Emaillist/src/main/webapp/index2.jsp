<%@ page import="java.util.List"%>
<%@ page import="emaillist.EmailListVO"%>
<%@ page import="emaillist.EmailListDAOOracleImpl"%>
<%@ page import="emaillist.EmailListDAO"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  
ServletContext context = getServletContext();
String dbuser = context.getInitParameter("dbuser");
String dbpass = context.getInitParameter("dbpass");
String dburl = "jdbc:oracle:thin:@localhost:1521:xe";

%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>메일링 리스트:메인</title>
</head>
<body>
	<a href="index.jsp">Model 1</a>
	<a href="index2.jsp">Model 2</a>
	<hr>
	<h1>메일링 리스트</h1>
	<h3>Model 2 방식</h3>

<%
EmailListDAO dao = new EmailListDAOOracleImpl(dbuser, dbpass);
List<EmailListVO> lst = dao.getList();

for (EmailListVO node: lst) {
	String lastName = node.getLastName();
	String firstName = node.getFirstName();
	String email = node.getEmail();
%>
	<!-- 리스트 -->
	<!-- vo 객체의 getter를 이용, 리스트를 표시 -->
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<th>성</th>
			<td><%= lastName %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%= firstName %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%= email %></td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="upd-btn" data-no="<%= node.getNo() %>">수정</button>
				<button class="del-btn" data-no="<%= node.getNo() %>">삭제</button>
			</td>
		</tr>
		
	</table>
	<br />
<%
}
%>
	<p>
		<a href="<%= request.getContextPath() %>/form2.jsp">추가 이메일 등록</a>
	</p>
	<script>

		const delBtn = document.querySelectorAll(".del-btn");
		const updBtn = document.querySelectorAll(".upd-btn");

		
		delBtn.forEach((e) => {
			e.addEventListener("click", (evt) => {
				if (confirm("정말로 삭제하시겠습니까?")) {
					
					const no = evt.target.dataset.no;
					location.href="delete.jsp?no=" + no;
				}
			})
		});
		
		updBtn.forEach((e) => {
			e.addEventListener("click", (evt) => {
				const no = evt.target.dataset.no;
				location.href="update_form.jsp?no=" + no;
			});
		})
		
	</script>
</body>
</html>