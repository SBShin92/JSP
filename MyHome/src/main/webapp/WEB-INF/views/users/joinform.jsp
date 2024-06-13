<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Home: Join Form</title>
<link rel="stylesheet" href="css/home.css">

</head>
<body>
	<div id="container">
		<div id="content">
			<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>

			<h1>Join Form</h1>
			<form method="POST" action="<%=request.getContextPath()%>/users">
				<input type="hidden" name="a" value="join" /> <label for="name">이름</label>
				<input type="text" name="name" /><br /> <label for="password">암호</label>
				<input type="password" name="password" /><br /> <label for="email">이메일</label>
				<input type="text" name="email" /><br /> <label for="gender">성별</label>
				<input type="radio" name="gender" value="M" checked>남성 <input
					type="radio" name="gender" value="F">여성 <input
					type="submit" value="가입" />
			</form>
			<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>