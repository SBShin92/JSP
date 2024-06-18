<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>방명록</title>
    <link type="text/css" rel="stylesheet" href="css/guestbook.css" />
  </head>
  <body>
    <div id="container">
      <jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
      <jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
      <div id="content">
        <div id="guestbook">
          <form action="<c:url value='/guestbook' />" method="POST">
            <input type="hidden" name="no" value="${ param.no }">
            <input type="hidden" name="a" value="delete" />
            <table>
              <tr>
                <td>비밀번호</td>
                <td><input type="password" name="password" /></td>
                <td><input type="submit" value="확인" /></td>
                <td>
                  <a href="<c:url value='/guestbook' />">돌아가기</a>
                </td>
              </tr>
            </table>
          </form>
        </div>
      </div>
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
    </div>
  </body>
</html>
