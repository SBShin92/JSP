package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cookie/get")
public class GetCookieController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();		
		String actionName = req.getParameter("a");
		Cookie[] cookies = req.getCookies();
		
		if ("delete".equals(actionName)) {
			for (Cookie cookie: cookies) {
				if (cookie.getName().equals("testCookie")) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					out.println("<p>testcookie 삭제</p>");
				}
			}
		} else {
			out.println("<h1>쿠키 목록</h1>");
			for (Cookie cookie: cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				int age = cookie.getMaxAge();
				out.printf("<p>Name: %s, Value: %s, MaxAge: %d</p>%n", name, value, age);
				out.printf("<p> Cookie Decode: %s</p>%n", URLDecoder.decode(value, "UTF-8"));
			}
		}
		
	}
}
