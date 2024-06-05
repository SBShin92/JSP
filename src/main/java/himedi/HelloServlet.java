package himedi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Logger;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger("HelloServlet");
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.info("[LifeCycle]: init");
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[LifeCycle]: service");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[LifeCycle]: doGet");
		
		// GET 요청으로 name 인자를 전달 받아 출력
		resp.setContentType("text/html; charset=UTF-8");
		String name = req.getParameter("name");
		if (name == null) {
			name = "Anonymous";
		}
		PrintWriter out = resp.getWriter();
		out.println("<h1>hi Servlet</h1>");
		out.println("<p>하잉 " + name + "</p>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[LifeCycle]: doPost");
		
		// POST 요청으로 전달받은 데이터 목록 출력
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>폼 데이터 처리</h1>");
		out.println("<p>폼으로부터 전송된 데이터</p>");
		
		Enumeration<String> params = req.getParameterNames();
		out.println("<ul>");
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			out.println("<li>" + paramName + " : " + req.getParameter(paramName) + "</li>");
		}
		out.println("</ul>");
	}

	@Override
	public void destroy() {
		logger.info("[LifeCycle]: Servlet Shutdown...");
		super.destroy();
	}
}
