package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myhome.dao.UsersDAO;
import myhome.dao.UsersDAOMySQLImpl;
import myhome.vo.UserVO;

@WebServlet(name = "Users", urlPatterns = "/users")
public class UserServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		RequestDispatcher rd = null;
		
		if ("joinform".equals(actionName)) {
			rd = req.getRequestDispatcher("WEB-INF/views/users/joinform.jsp");
		} else if ("joinsuccess".equals(actionName)) {
			rd = req.getRequestDispatcher("WEB-INF/views/users/joinsuccess.jsp");
		} else if ("loginsuccess".equals(actionName)) {
			rd = req.getRequestDispatcher("WEB-INF/views/users/loginsuccess.jsp");
		} else {
			rd = req.getRequestDispatcher("WEB-INF/views/users/loginform.jsp");
		}
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		
		if ("join".equals(actionName)) {
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			
			UserVO vo = new UserVO(name, password, email, gender);
			UsersDAO dao = new UsersDAOMySQLImpl(dbuser, dbpass);
			
			boolean success = dao.insert(vo);
			if (success) {
				resp.sendRedirect(req.getContextPath() + "/users?a=joinsuccess");
			} else {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "가입 실패");
			}			
		} else if ("login".equals(actionName)) {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			UsersDAO dao = new UsersDAOMySQLImpl(dbuser, dbpass);
			UserVO vo = dao.getUserIdAndPassword(email, password);
			if (vo != null) {
				resp.sendRedirect(req.getContextPath() + "/users?a=loginsuccess");
			} else {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "로그인 실패");
			}
		}
		else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	
}
