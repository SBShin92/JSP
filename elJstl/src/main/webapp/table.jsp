<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="" method="GET">
    <input name="r"><label for="r">행</label> <input name="c"><label
      for="c">열</label>
    <button type="submit">실행</button>
  </form>
  <br />
  <br />

  <h3>JSTL choose, forEach</h3>
  <c:choose>
    <c:when test="${ not empty param.r }">
      <c:set var="nRow" value="${param.r}" />
    </c:when>
    <c:otherwise>
      <c:set var="nRow" value="3"></c:set>
    </c:otherwise>
  </c:choose>
  <c:choose>
    <c:when test="${ not empty param.c }">
      <c:set var="nCol" value="${param.c}" />
    </c:when>
    <c:otherwise>
      <c:set var="nCol">3</c:set>
    </c:otherwise>
  </c:choose>


  <table border='1px' cellspacing='0' cellpadding='10px'>
    <c:forEach begin="0" end="${nRow - 1}" var="row">
      <tr>
        <c:forEach begin="0" end="${nCol - 1}" var="col">
          <td>cell(${row}, ${col})</td>
        </c:forEach>
      </tr>
    </c:forEach>
  </table>
</body>
</html>