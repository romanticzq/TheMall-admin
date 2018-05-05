package com.project.dao;

import com.project.model.Admin;

public interface LoginDao {
	
	//管理员登录
	public boolean adminLogin(String name,String password);
	
	//管理员登录
	public Admin adminLoginByName(String name);
}
