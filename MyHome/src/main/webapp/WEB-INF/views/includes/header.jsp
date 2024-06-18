<%@page import="myhome.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="header">
  <h1>sashin92's Page</h1>
  <div class="button-container">
    <ul>
      <c:choose>
        <c:when test="${ empty sessionScope.authUser }">
          <li><a href="<c:url value="/users?a=joinform" />">회원가입</a></li>
          <li><a href="<c:url value="/users?a=loginform" />">로그인</a></li>   
        </c:when>
        <c:otherwise>
          <li><a href="<c:url value="/users?a=logout" />">로그아웃</a></li>
        </c:otherwise>
      </c:choose>
    </ul>
  </div>
</div>
