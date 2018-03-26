package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDao;
import com.project.model.UserModel;
import com.project.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	/**
	 * 查询用户
	 */
	@Override
	public List<UserModel> userList(String userName,int status,int sex) {
		
		return this.userDao.userList(userName,status,sex);
	}

	/**
	 * 修改用户状态
	 */
	@Override
	public void userEdit(int id) {
		
		this.userDao.userEdit(id);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void userDelete(int id) {
		
		this.userDao.userDelete(id);
	}

	/**
	 * 分页查询用户
	 */
	@Override
	public List<UserModel> userListPage(String userName, int status, int sex, int index) {
		
		return this.userDao.userListPage(userName, status, sex, index);
	}

}
