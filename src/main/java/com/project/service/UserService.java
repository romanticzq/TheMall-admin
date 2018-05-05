package com.project.service;

import java.util.List;

import com.project.model.User;

public interface UserService {

	//查询用户
	public List<User> userList(String userName,String status,String sex);
	
	//查询用户
	public List<User> userListPage(String userName,String status,String sex,int index);
		
	//修改用户状态
	public void userEdit(int id);
	
	//删除用户
	public void userDelete(int id);
}
