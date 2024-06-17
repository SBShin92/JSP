<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터형</title>
</head>
<body>
	<h1>데이터형</h1>
	<h3>JSP</h3>
	<%
	int iValue = (int)request.getAttribute("iValue");
	Object nValue = (Object)request.getAttribute("nValue");
  %>
  <p>iValue: <%= iValue %></p>
  <p>nValue: <%= nValue %></p>
  
	<!-- servlet에서 넘어온 값들을 표현할때 사용한다. java보다 간결하다 -->
  <h3>EL</h3>
	<ul>
		<li>${iValue}</li>
		<li>${fValue}</li>
		<li>${sValue}</li>
		<li>${bValue}</li>
		<li>${nValue}</li>
    <li>${ userVo.email }</li> <!-- 알아서 get메소드 호출 -->
	</ul>
</body>
</html>