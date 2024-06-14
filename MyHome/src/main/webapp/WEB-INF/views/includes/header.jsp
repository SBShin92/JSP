<%@page import="myhome.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%
UserVO vo = (UserVO) session.getAttribute("authUser");
%>
<div id="header">
  <h1>sashin92's Page</h1>
  <div class="button-container">
    <ul>
    <%
    if (vo != null) {
    %>
      <li><a href="<%= request.getContextPath() %>/users?a=logout">로그아웃</a></li>
    <%
    } else {
    %>
      <li><a href="<%= request.getContextPath() %>/users?a=joinform">회원가입</a></li>
      <li><a href="<%= request.getContextPath() %>/users?a=loginform">로그인</a></li>
    <%
    }
    %>
    </ul>
  </div>
</div>
