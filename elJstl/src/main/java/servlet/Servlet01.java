package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.UserVo;

@WebServlet("/01")
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iValue = 2024;
		double fValue = Math.PI;
		String sValue = "Hello World!";
		boolean bValue = true;
		Object nValue = null;
		
		UserVo vo = new UserVo();
		vo.setNo(100);
		vo.setEmail("exam@ple.com");
		
		request.setAttribute("iValue", iValue);
		request.setAttribute("fValue", fValue);
		request.setAttribute("sValue", sValue);
		request.setAttribute("bValue", bValue);
		request.setAttribute("nValue", nValue);
		request.setAttribute("userVo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/01.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
