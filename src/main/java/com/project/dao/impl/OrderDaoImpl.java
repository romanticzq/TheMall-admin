package com.project.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.OrderDao;
import com.project.model.Orders;

@Repository
public class OrderDaoImpl implements OrderDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 查询订单
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> orderList(String status,String userName) {

		String query="from Orders";
		if(userName!=null&&userName!=""){
			userName="%"+userName+"%";
			if(status!=null&&status!=""){
				query=query+" where status=? and u_id1 in (select userId from User where userName like ?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).setParameter(1, userName).list();
			}else{
				query=query+" where u_id1 in (select userId from User where userName like ?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).list();
			}
		}else{
			if(status!=null&&status!=""){
				query=query+" where status=?";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).list();
			}else{
				return this.sessionFactory.getCurrentSession().createQuery(query).list();
			}
			
		}
		
	}

	/**
	 * 分页查询商品类型列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Orders> orderListPage(String status, String userName, int index) {
		
		String query="from Orders";
		if(userName!=null&&userName!=""){
			userName="%"+userName+"%";
			if(status!=null&&status!=""){
				query=query+" where status=? and u_id1 in (select userId from User where userName like ?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).setParameter(1, userName).setFirstResult((index-1)*5).setMaxResults(5).list();
			}else{
				query=query+" where u_id1 in (select userId from User where userName like ?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setFirstResult((index-1)*5).setMaxResults(5).list();
			}
		}else{
			if(status!=null&&status!=""){
				query=query+" where status=?";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).setFirstResult((index-1)*5).setMaxResults(5).list();
			}else{
				return this.sessionFactory.getCurrentSession().createQuery(query).setFirstResult((index-1)*5).setMaxResults(5).list();
			}
			
		}
	}

	/**
	 * 根据id查找订单
	 */
	@Override
	public Orders findOrdersById(int id) {
		
		return (Orders) this.sessionFactory.getCurrentSession().createQuery("from Orders where id=?").setParameter(0,id).uniqueResult();
	}

	/**
	 * 保存订单
	 */
	@Override
	public void saveOrders(Orders order) {
		
		this.sessionFactory.getCurrentSession().saveOrUpdate(order);
	}
	
}
