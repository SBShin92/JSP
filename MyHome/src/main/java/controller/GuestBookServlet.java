package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import myhome.dao.GuestBookDAO;
import myhome.dao.GuestBookDAOMySQLImpl;
import myhome.vo.GuestBookVO;

@WebServlet(name = "GroupBook", urlPatterns = "/guestbook")
public class GuestBookServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		if ("delete".equals(actionName)) {
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/guestbook/deleteform.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/guestbook/list.jsp");
			rd.forward(req, resp);			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GuestBookDAO dao = new GuestBookDAOMySQLImpl(dbuser, dbpass);
		String actionName = req.getParameter("a");
		
		if ("delete".equals(actionName)) {
			
			String password = req.getParameter("password");
			
			Long no = Long.parseLong(req.getParameter("no"));
			GuestBookVO vo = dao.get(no);

			if (vo.getPassword().equals("") || password.equals(vo.getPassword())) {
				dao.delete(vo);
			}
			
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/guestbook/list.jsp");
			rd.forward(req, resp);
		} else if ("add".equals(actionName)) {
			String name = req.getParameter("name");
			if (name.equals(""))
				name = "익명";
			String pass = req.getParameter("pass");
			String content = req.getParameter("content");
			
			GuestBookVO vo = new GuestBookVO(name, pass, content);

			boolean success = dao.insert(vo);
			
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/guestbook/list.jsp");
			rd.forward(req, resp);
		}
	}
}
