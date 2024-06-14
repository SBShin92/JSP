<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
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
          <h1>환영합니다. sashin92의 페이지 입니다.</h1>
          <br />
          <p>페이지 작성 중입니다...</p>
          <div class="button-container">
            <form method="GET" action="users">
              <input type="hidden" name="a" value="loginform" />
              <input type="submit" value="로그인" class="submit-button" />
            </form>
            <form method="GET" action="users">
              <input type="hidden" name="a" value="joinform" />
              <input type="submit" value="가입하기" class="submit-button" />
            </form>
          </div>
        </div>
      </div>
      <%@ include file="/WEB-INF/views/includes/footer.jsp"%>
    </div>
  </body>
</html>
