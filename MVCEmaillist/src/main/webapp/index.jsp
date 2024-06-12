<%@page import="emaillist.EmailListVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

List<EmailListVO> lst = null;
if (request.getAttribute("list") instanceof List)
	lst = (List<EmailListVO>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>메일링 리스트:메인</title>
</head>
<body>
	<h1>메일링 리스트</h1>
	<h3>Model 2 방식</h3>
	<div>
	  <a href="<%= request.getContextPath() %>/el">리스트 불러오기</a>
	  <a href="<%= request.getContextPath() %>">리스트 닫기</a>
	</div><br />

<%
if (lst != null) {
	for (EmailListVO node: lst) {
%>
	<!-- 리스트 -->
	<!-- vo 객체의 getter를 이용, 리스트를 표시 -->
	<table border="1" cellpadding="5" cellspacing="2">
		<tr>
			<th>성</th>
			<td><%= node.getLastName() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%= node.getFirstName() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%= node.getEmail() %></td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="upd-btn" data-no="">수정</button>
				<button class="del-btn" data-no="">삭제</button>
			</td>
		</tr>
		
	</table>
	<br />
<%
	}
}
%>

	<p>
		<a href="<%= request.getContextPath() %>/el?a=form">추가 이메일 등록</a>
	</p>
	<script>

		const delBtn = document.querySelectorAll(".del-btn");
		const updBtn = document.querySelectorAll(".upd-btn");

		
		delBtn.forEach((e) => {
			e.addEventListener("click", (evt) => {
				if (confirm("정말로 삭제하시겠습니까?")) {
					
					const no = evt.target.dataset.no;
					location.href="?no=" + no;
				}
			})
		});
		
		updBtn.forEach((e) => {
			e.addEventListener("click", (evt) => {
				const no = evt.target.dataset.no;
				location.href="<%= request.getContextPath() %>/emaillist/update_form.jsp?no=" + no;
			});
		})
		
	</script>
</body>
</html>