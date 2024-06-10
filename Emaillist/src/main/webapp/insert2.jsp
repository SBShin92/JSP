<%@page import="emaillist.EmailListDAOOracleImpl"%>
<%@page import="emaillist.EmailListDAO"%>
<%@page import="emaillist.EmailListVO"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%

ServletContext context = getServletContext();
String dbuser = context.getInitParameter("dbuser");
String dbpass = context.getInitParameter("dbpass");
String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
String sql = "INSERT INTO emaillist(no, last_name, first_name, email) " + 
			"VALUES (seq_emaillist_pk.nextval, ?, ?, ?)";

String lastName = request.getParameter("ln");
String firstName = request.getParameter("fn");
String email = request.getParameter("email");


EmailListVO vo = new EmailListVO(lastName, firstName, email);
EmailListDAO dao = new EmailListDAOOracleImpl(dbuser, dbpass);

boolean success = dao.insert(vo);

if (success)
	response.sendRedirect(request.getContextPath() + "/index2.jsp");
else {
	%>
	<h1>Error</h1>
	<p>데이터 입력 중 오류가 발생했습니다</p>
	<%
}
	
%>