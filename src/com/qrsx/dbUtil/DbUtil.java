package com.qrsx.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String username = "java1";
	private static String password = "java1";

	// private static String sqlHandle = "select * from USERS";

	private static Connection conn;
	private static Statement stmt;
	private static ResultSet rs;

	// 连接数据库
	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		if (conn == null) {
			// 获取连接
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		}

		return conn;
	}

	// 获取数据
	public static ResultSet getResultSet(String sql) throws SQLException,
			ClassNotFoundException {
		getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		return rs;

	}

	// 释放资源
	public void release() throws SQLException {
		rs.close();
		stmt.close();

	}

	public void releaseConn() throws SQLException {
		conn.close();
	}

}
