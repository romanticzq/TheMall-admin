package com.project.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.ExpressDao;
import com.project.model.Express;

@Repository
public class ExpressDaoImpl implements ExpressDao{

	@Autowired
	private SessionFactory sessionFactory; 
	
	/**
	 * 查询快递
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Express> expressList() {
		
		String query="from Express";
		return this.sessionFactory.getCurrentSession().createQuery(query).list();
	}

	/**
	 * 根据公司名称查询快递
	 */
	@Override
	public Express findExpressByName(String name) {
		
		String query="from Express where companyName=?";
		return (Express) this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).uniqueResult();
	}

}
