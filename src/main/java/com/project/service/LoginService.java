package com.project.service;

import com.project.model.Admin;

public interface LoginService {

	//管理员登录
	public boolean adminLogin(String name,String password);
	
	//管理员登录
	public Admin adminLoginByName(String name);
}
