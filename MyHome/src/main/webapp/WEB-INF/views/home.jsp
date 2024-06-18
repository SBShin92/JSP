<%@page import="myhome.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
			<div id="site-introduction">
				<!-- content 영역 -->
				<h2>환영합니다
        <c:if test="${ not empty authUser }">
          <c:out value=" ${ authUser.name }님."/>
        </c:if>
        </h2>
				<p>세션을 이용한 로그인 유지기능까지 구현했습니다.</p>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/includes/footer.jsp"%>
	</div>
</body>
</html>