package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SetCookie", urlPatterns = "/cookie/set")
public class SetCookieController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("text/html");
		out.println("<h1>Cookie 저장</h1>");
		
		Cookie c = new Cookie("testCookie", URLEncoder.encode("Servlet에서 쿠키 저장을 명령합니다. SetCookie", "UTF-8"));
		c.setMaxAge(24 * 60 * 60);
		
		
		resp.addCookie(c);
		out.printf("<p>%s를 쿠키이름 %s로 저장합니다.</p>%n", c.getValue(), c.getName());
		out.printf("<p> Cookie Decode: %s</p>%n", URLDecoder.decode(c.getValue(), "UTF-8"));
	}
}
