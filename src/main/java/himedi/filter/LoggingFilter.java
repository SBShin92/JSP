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
import jakarta.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {
	private static final Logger logger = Logger.getLogger(LoggingFilter.class.getSimpleName());
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("[LoggingFilter] init");
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		out.println("<h6>LoggingFilter 작동 전</h6>");
		logger.info("[LoggingFilter] doFilter");
		
		HttpServletRequest httpRequest = (HttpServletRequest)req;
		logger.info("**들어오는 요청 URI**: " + httpRequest.getRequestURI());
		
		chain.doFilter(req, resp);
		
		out.println("<h6>LoggingFilter 작동 후</h6>");
		logger.info("응답 상태: " + resp.getContentType());
	}

	@Override
	public void destroy() {
		logger.info("[LoggingFilter] Destroy");
		Filter.super.destroy();
	}	
}
