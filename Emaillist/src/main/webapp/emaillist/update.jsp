<%@page import="emaillist.EmailListDAOOracleImpl"%>
<%@page import="emaillist.EmailListDAO"%>
<%@page import="emaillist.EmailListVO"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ServletContext context = getServletContext();
	String dbuser = context.getInitParameter("dbuser");
	String dbpass = context.getInitParameter("dbpass");
	Long no = Long.parseLong(request.getParameter("no"));

	EmailListDAO dao = new EmailListDAOOracleImpl(dbuser, dbpass);
	EmailListVO vo = dao.get(no);
	
	vo.setFirstName(request.getParameter("fn"));
	vo.setLastName(request.getParameter("ln"));
	vo.setEmail(request.getParameter("email"));
	
	boolean success = dao.update(vo);
	
	if (success)
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	else {
		%>
		<h1>Error</h1>
		<p>데이터 입력 중 오류가 발생했습니다</p>
		<%
	}
%>
