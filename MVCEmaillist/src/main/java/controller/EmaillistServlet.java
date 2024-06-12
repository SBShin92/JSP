package controller;

import java.io.IOException;
import java.util.List;

import emaillist.EmailListDAO;
import emaillist.EmailListDAOOracleImpl;
import emaillist.EmailListVO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Emaillist", urlPatterns = "/el")
public class EmaillistServlet extends BaseServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String actionName = req.getParameter("a");
		if ("form".equals(actionName)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/form.jsp");
			rd.forward(req, resp);
		} else if ("updateForm".equals(actionName)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/emaillist/update_form.jsp");
			rd.forward(req, resp);					
		}
		else {
			EmailListDAO dao = new EmailListDAOOracleImpl(dbuser, dbpass);
			List<EmailListVO> lst = dao.getList();

			req.setAttribute("list", lst);
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String actionName = req.getParameter("a");
		if ("insert".equals(actionName)) {
			String lastName = req.getParameter("ln");
			String firstName = req.getParameter("fn");
			String email = req.getParameter("email");
			
			EmailListVO vo = new EmailListVO(lastName, firstName, email);
			EmailListDAO dao = new EmailListDAOOracleImpl(dbuser, dbpass);

			boolean success = dao.insert(vo);

			if (success)
				resp.sendRedirect(req.getContextPath() + "/el");
		}
	}	
}
