package com.qrsx.s2016;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qrsx.entity.JspUser;
import com.qrsx.service.JspUserServiceImp;
import com.qrsx.service.JspUserServiceImpl;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 告诉浏览器不缓存
		response.setHeader("pragma", "no-cache");
		// System.out.println("请求进来了");
		response.setCharacterEncoding("UTF-8");
		// 获取页面传递过来的角色参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		IUser u = null;
		// user不为空的前提是role不为空
		if ("".equals(role) || role.equals(null)) {
			System.out.println("没有选择角色");
			return;
		}

		u = UserFacotry.getInstance(role);
		if (u.equals(null)) {
			System.out.println("没有获取到用户信息");
			return;
		}
		if (u.login(username, password) == true) {
			// 转向另外的目标页面
			// 跳转的两种方式
			// 1.重定向，原有的request失效
			// response.sendRedirect("success.jsp");
			// 2.请求转发,使用原有的request

			// 获取列表并转发
			// 获取数据
			JspUserServiceImp jus = new JspUserServiceImpl();
			List<JspUser> jspUsers = null;
			try {
				jspUsers = jus.getUsers();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			request.setAttribute("userlist", jspUsers);
			RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
			rd.forward(request, response);
		} else {
			// request.getRequestDispatcher("fail.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
			rd.forward(request, response);
		}

	}
}
