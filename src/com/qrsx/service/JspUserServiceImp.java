package com.qrsx.service;

import java.sql.SQLException;
import java.util.List;

import com.qrsx.entity.JspUser;

public interface JspUserServiceImp {
	public List<JspUser> getUsers() throws SQLException, ClassNotFoundException;

}
