package com.project.dao;

import java.util.List;

import com.project.model.UserModel;

public interface UserDao {

	//查询用户
	public List<UserModel> userList(String userName,int status,int sex);
	
	//分页查询用户
	public List<UserModel> userListPage(String userName,int status,int sex,int index);
	
	//修改用户状态
	public void userEdit(int id);
	
	//删除用户
	public void userDelete(int id);
}
