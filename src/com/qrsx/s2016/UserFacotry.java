package com.qrsx.s2016;

public class UserFacotry {

	public static IUser getInstance(String role) {
		// 动态类几种方式
		// 1.Loader getClassLoader();
		// ClassLoader cl = Thread.class.getClassLoader();
		// Class<?> u = cl.loadClass(className);
		// // 目标装载的Administror
		// Administrator a = (Administrator) u.newInstance();

		// 2. class.forName()方式 JDBC
		// 该函数实际完成两部分功能：装载类 类的初始化
		// Class cl = Class.forName(className);
		// Administrator a = (Administrator) cl.newInstance();
		// 3.new 方式
		// Administrator a = new Administrator();

		System.out.println("角色:" + role);

		// 已知角色是管理员，求获得管理员对象
		if (role.equals("1")) {

			return new Administrator();
		}
		// 已知角色是普通用户，求获得普通用户对象
		if (role.equals("2")) {
			return new UserOrdinal();
		}

		return null;
	}
}
