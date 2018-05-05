package com.project.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.LoginDao;
import com.project.model.Admin;

@Repository
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	private SessionFactory sessionFactory; 

	/**
	 * 用户登录
	 */
	@Override
	public boolean adminLogin(String name, String password) {
		Admin admin =(Admin) sessionFactory.getCurrentSession().createQuery("from Admin where userName=? and passWord=?").setParameter(0, name).setParameter(1, password).uniqueResult();
		if(admin!=null) {
			return true;
		}
		return false;
	}

	
	@Override
	public Admin adminLoginByName(String name) {
		Admin admin =(Admin) sessionFactory.getCurrentSession().createQuery("from AdminModel where userName=?").setParameter(0, name).uniqueResult();
		return admin;
	}

}
