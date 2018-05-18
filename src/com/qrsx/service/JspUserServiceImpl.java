package com.qrsx.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qrsx.dbUtil.DbUtil;
import com.qrsx.entity.JspUser;

public class JspUserServiceImpl implements JspUserServiceImp {
	// 获取数据
	List<JspUser> jspUsers = new ArrayList<JspUser>();

	private ResultSet rs;

	@Override
	public List<JspUser> getUsers() throws SQLException, ClassNotFoundException {

		// 第一个麻烦：DbUtil dbUtil需要初始化 改为static
		// 第二个麻烦：sql语句不能动态执行 ->sql变为参数
		// DbUtil dbUtil = new DbUtil();
		rs = DbUtil.getResultSet("select * from users");
		while (rs.next()) {
			JspUser ju = new JspUser();
			ju.setId(rs.getLong("id"));
			ju.setName(rs.getString("name"));
			ju.setPwd(rs.getString("pwd"));
			ju.setSex(rs.getInt("sex"));
			ju.setIdentity(rs.getString("identity"));
			ju.setAge(rs.getInt("age"));
			jspUsers.add(ju);

			/*
			 * System.out.println(ju.getId()); System.out.println(ju.getName());
			 * System.out.println(ju.getSex()); System.out.println(ju.getPwd());
			 * System.out.println(ju.getIdentity());
			 * System.out.println(ju.getAge());
			 */

		}
		return jspUsers;

	}

	public List<JspUser> getJspUsers() {
		return jspUsers;
	}

}
