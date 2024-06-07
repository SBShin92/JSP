package himedi.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private static Logger logger =
			Logger.getLogger(EncodingFilter.class.getSimpleName());
	private static String encoding = "UTF-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("[EncodingFilter] init");
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		logger.info("[EncodingFilter] doFilter");

		PrintWriter out = resp.getWriter();
		out.println("<h6>Encoding Filter 작동 전</h6>");

		// request filter
		req.setCharacterEncoding(encoding);
		
		// response filter
		resp.setContentType("text/html");
		resp.setCharacterEncoding(encoding);

		chain.doFilter(req, resp);
		out.println("<h6>Encoding Filter 작동 후</h6>");
	}

	@Override
	public void destroy() {
		logger.info("[EncodingFilter] Destroy");
		Filter.super.destroy();
	}
}
