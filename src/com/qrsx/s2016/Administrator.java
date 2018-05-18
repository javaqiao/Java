package com.qrsx.s2016;

public class Administrator extends User implements IUser {

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		if (username.equals("A") && password.equals("1")) { // 管理员角色
			System.out.println("管理员登陆");
			return true;
		}
		return false;
	}
}
