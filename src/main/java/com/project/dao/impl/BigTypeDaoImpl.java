package com.project.dao.impl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.BigTypeDao;
import com.project.model.BigType;

@Repository
public class BigTypeDaoImpl implements BigTypeDao{

	@Autowired
	private SessionFactory sessionFactory; 
	
	/**
	 * 查询顶级商品类型列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<BigType> bigTypeList() {
		
		String query="from BigType";
		return this.sessionFactory.getCurrentSession().createQuery(query).list();
	}
	
	/**
	 * 根据id查询顶级商品类型
	 */
	@Override
	public BigType bigTypeById(int id) {
		
		return (BigType)this.sessionFactory.getCurrentSession().createQuery("from BigType where id=?").setParameter(0, id).uniqueResult();
	}
	
	/**
	 * 根据名称查询顶级商品类型
	 */
	@Override
	public BigType bigTypeByName(String name) {
		
		return (BigType)this.sessionFactory.getCurrentSession().createQuery("from BigType where typeName=?").setParameter(0, name).uniqueResult();
	}
}
