<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  
ServletContext context = getServletContext();
String dbuser = context.getInitParameter("dbuser");
String dbpass = context.getInitParameter("dbpass");
String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
String sql = "SELECT last_name, first_name, email, no FROM emaillist ORDER BY created_at DESC";

%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>메일링 리스트:메인</title>
</head>
<body>
	<a href="index.jsp">Model 1</a>
	<a href="/Emaillist/emaillist/index2.jsp">Model 2</a>
	<hr>
	<h1>메일링 리스트</h1>
	<h3>Model 1 방식</h3>

<%
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	String lastName = "";
	String firstName = "";
	String email = "";
	Long no;
	
	while (rs.next()) {
		lastName = rs.getString("last_name");
		firstName = rs.getString("first_name");
		email = rs.getString("email");
		no = rs.getLong("no");
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
				<button class="upd-btn" data-no="<%= no %>">수정</button>
				<button class="del-btn" data-no="<%= no %>">삭제</button>
			</td>
		</tr>
		
	</table>
	<br />
<%
	}
	rs.close();
	stmt.close();
	con.close();
} catch (ClassNotFoundException e) {
	throw new ClassNotFoundException("Driver Not Found");
} catch (Exception e) {
	throw new Exception("########### Err ############");
}
%>
	<p>
		<a href="<%= request.getContextPath() %>/emaillist/form.jsp">추가 이메일 등록</a>
	</p>
	<script>

		const delBtn = document.querySelectorAll(".del-btn");
		const updBtn = document.querySelectorAll(".upd-btn");

		
		delBtn.forEach((e) => {
			e.addEventListener("click", (evt) => {
				if (confirm("정말로 삭제하시겠습니까?")) {
					
					const no = evt.target.dataset.no;
					location.href="/Emaillist/emaillist/delete.jsp?no=" + no;
				}
			})
		});
		
		updBtn.forEach((e) => {
			e.addEventListener("click", (evt) => {
				const no = evt.target.dataset.no;
				location.href="/Emaillist/emaillist/update_form.jsp?no=" + no;
			});
		})

		
	</script>
</body>
</html>