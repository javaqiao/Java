package com.qrsx.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qrsx.entity.JspUser;
import com.qrsx.service.JspUserServiceImp;
import com.qrsx.service.JspUserServiceImpl;

//Action做请求转发的工作
@WebServlet("/JspUserServlet")
public class JspUserAction extends HttpServlet {
	JspUserServiceImp jus = new JspUserServiceImpl();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取列表并转发
		// 获取数据
		List<JspUser> jspUsers = null;

		try {
			jspUsers = jus.getUsers();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("userlist", jspUsers);
		RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
		rd.forward(request, response);
	}
}
