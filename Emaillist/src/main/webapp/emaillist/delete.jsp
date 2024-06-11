<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
try {
	ServletContext context = getServletContext();
	String dbuser = context.getInitParameter("dbuser");
	String dbpass = context.getInitParameter("dbpass");
	String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
	String sql = "DELETE FROM emaillist " + 
				"WHERE no = ?";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
	PreparedStatement pstmt = con.prepareStatement(sql);
	Long no = Long.parseLong(request.getParameter("no"));
	
	pstmt.setLong(1, no);
	int deleteCount = pstmt.executeUpdate();
	if (deleteCount == 1)
		response.sendRedirect(request.getContextPath());
	else {
		%>
		<h1>Error</h1>
		<p>데이터 입력 중 오류가 발생했습니다</p>
		<%
	}
	
	pstmt.close();
	con.close();
	
	
} catch (ClassNotFoundException e) {
	throw new ClassNotFoundException("Driver Not Found");
} catch (Exception e) {
	throw e;
}

%>