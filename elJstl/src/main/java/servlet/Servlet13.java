package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.UserVo;

@WebServlet("/13")
public class Servlet13 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<UserVo> userList = new ArrayList<UserVo>();
		for(int i=0 ; i<20 ; i++) {
			UserVo vo = new UserVo(i, i+"번 회원", i+"@gamil.com", "1234", "male");
			userList.add(vo);
		}
		
		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/13.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
