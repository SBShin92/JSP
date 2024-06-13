<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sashin92's Page</title>
<link type="text/css" rel="stylesheet" href="css/home.css" />
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
		<div id="wrapper">
			<div id="content">
				<!-- content 영역 -->
				<h1> 환영합니다. sashin92의 페이지 입니다. </h1>
				<br/>
				<p>페이지 작성 중입니다...</p>
				<a href="<%= request.getContextPath() %>/users">로그인</a>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
</html>