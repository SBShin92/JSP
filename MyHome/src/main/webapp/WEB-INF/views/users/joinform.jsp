<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>My Home: Join Form</title>
    <link rel="stylesheet" href="css/users.css" />
  </head>
  <body>
    <div id="container">
      <jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
      <jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
      <div id="join-form">
        <h1>Join Form</h1>
        
        <c:if test="${ not empty requestScope.errorMsg }">
          <p style="color:red; fonte-weight:bold;">${ requestScope.errorMsg }</p>
        </c:if>
        <form method="POST" action="<c:url value='/users' />">
          <input type="hidden" name="a" value="join" />
          <label for="name">이름</label> <input type="text" name="name" /><br />
          <label for="password">암호</label>
          <input type="password" name="password" /><br />
          <label for="email">이메일</label>
          <input type="text" name="email" /><br />
          <label for="gender">성별</label>
          <input type="radio" name="gender" value="M" checked />남성
          <input type="radio" name="gender" value="F" />여성
          <input type="submit" value="Sign up" />
        </form>
      </div>
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
    </div>
  </body>
</html>
