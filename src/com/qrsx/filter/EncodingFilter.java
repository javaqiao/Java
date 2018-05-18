package com.qrsx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		boolean passed = true;
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		request.setCharacterEncoding("UTF-8");// 解码
		response.setCharacterEncoding("UTF-8");// 编码
		if (passed == false) {
			// response.sendRedirect("./fail.jsp");
			System.out.println("没有通过验证");
			return;
		}
		chain.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	// @Override
	// public void doFilter(ServletRequest req, ServletResponse resp,
	// FilterChain filterChain) throws IOException, ServletException {
	// // HttpServletRequest request = (HttpServletRequest) req;
	// // String user = (String) request.getSession().getAttribute("user");
	// // if (user == null) {
	// // HttpServletResponse response = (HttpServletResponse) resp;
	// // // response.sendRedirect("./login.jsp");
	// // return;
	// // }
	// filterChain.doFilter(req, resp);
	// }
}
