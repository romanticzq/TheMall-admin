package com.project.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.OrderDao;
import com.project.model.OrderModel;
import com.project.model.UserModel;

@Repository
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 查询订单
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderModel> orderList(int status,String userName) {

		String query="from OrderModel";
		if(userName!=null&&userName!=""){
			userName="%"+userName+"%";
			if(status!=0){
				query=query+" where status=? and user_id in (select id from UserModel where userName like ?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).setParameter(1, userName).list();
			}else{
				query=query+" where user_id in (select id from UserModel where userName like ?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).list();
			}
		}else{
			if(status!=0){
				query=query+" where status=?";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).list();
			}else{
				return this.sessionFactory.getCurrentSession().createQuery(query).list();
			}
			
		}
		
	}
	
	
	
}
