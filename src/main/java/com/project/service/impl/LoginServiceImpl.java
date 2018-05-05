package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.LoginDao;
import com.project.model.Admin;
import com.project.service.LoginService;

@Transactional
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public boolean adminLogin(String name, String password) {
		
		return this.loginDao.adminLogin(name, password);
	}

	@Override
	public Admin adminLoginByName(String name) {
		
		return this.loginDao.adminLoginByName(name);
	}

}
