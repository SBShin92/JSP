package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import vo.UserVo;

@WebServlet("/05")
public class Servlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//문제 5번 6번 예제
		
		UserVo userVo = new UserVo(1, "박명수", "park", "1234", "male");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", userVo);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/05.header.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
