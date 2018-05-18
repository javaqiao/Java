package com.qrsx.s2016;

public class UserOrdinal extends User implements IUser {

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if (username.equals("O") && password.equals("1")) { // 管理员角色
			System.out.println("普通用户登陆");
			return true;
		}
		return false;
	}
}
