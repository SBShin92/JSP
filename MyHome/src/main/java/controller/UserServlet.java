package controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import myhome.dao.UsersDAO;
import myhome.dao.UsersDAOMySQLImpl;
import myhome.vo.UserVO;

@WebServlet(name = "Users", urlPatterns = "/users")
public class UserServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		String result = req.getParameter("result");
		RequestDispatcher rd = null;
		
		if ("joinform".equals(actionName)) {
			if ("fail".equals(result)) {
				req.setAttribute("errorMsg", "양식이 올바르지 않습니다.");
			}
			rd = req.getRequestDispatcher("WEB-INF/views/users/joinform.jsp");
		} else if ("loginform".equals(actionName)) {
			if ("fail".equals(result)) {
				req.setAttribute("errorMsg", "로그인에 실패했습니다.");
			}
			rd = req.getRequestDispatcher("WEB-INF/views/users/loginform.jsp");
		} else if ("logout".equals(actionName)) {
			req.getSession(false).invalidate();
			rd = req.getRequestDispatcher(req.getContextPath());
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
				resp.sendRedirect(req.getContextPath());
			} else {
				resp.sendRedirect(req.getContextPath() + "/users?a=joinform&result=fail");
			}			
		} else if ("login".equals(actionName)) {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			UsersDAO dao = new UsersDAOMySQLImpl(dbuser, dbpass);
			UserVO vo = dao.getUserIdAndPassword(email, password);
			if (vo != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("authUser", vo);
				resp.sendRedirect(req.getContextPath());
			} else {
				resp.sendRedirect(req.getContextPath() + "/users?a=loginform&result=fail");
			}
		}
		else {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
