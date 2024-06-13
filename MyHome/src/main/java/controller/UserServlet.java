package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		} else {
			rd = req.getRequestDispatcher("WEB-INF/views/users/loginform.jsp");
		}
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
	
	
}
