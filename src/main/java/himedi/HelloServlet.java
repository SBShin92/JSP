package himedi;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET 요청으로 name 인자를 전달 받아 출력
		resp.setContentType("text/html; charset=UTF-8");
		String name = req.getParameter("name");
		if (name == null) {
			name = "Anonymous";
		}
		PrintWriter out = resp.getWriter();
		out.println("<h1>hi Servlet</h1>");
		out.println("<p>하잉 " + name + "</p>");
		
		
//		super.doGet(req, resp);
	}

}
