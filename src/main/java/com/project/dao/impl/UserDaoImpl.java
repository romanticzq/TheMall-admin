package com.project.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.UserDao;
import com.project.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory; 

	/**
	 * 查询用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> userList(String userName,String status,String sex) {
		System.out.println("查询："+userName+","+status+","+sex);
		String query="from User";
		if(userName!=null&&userName!=""){
			userName="%"+userName+"%";
			query=query+" where userName like ?";
			if(status!=null&&status!="") {
				query=query+" and status=?";
				if(sex!=null&&sex!=""){
					query=query+" and gender=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setParameter(1, status).setParameter(2, sex).list();
				}else {
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setParameter(1, status).list();
				}
				
			}else {
				if(sex!=null&&sex!=""){
					query=query+" and gender=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setParameter(1, sex).list();
				}else {
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).list();
				}
			}
		}else{
			if(status!=null&&status!="") {
				query=query+" where status=?";
				if(sex!=null&&sex!=""){
					query=query+" and gender=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).setParameter(1, sex).list();
				}else{
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).list();
				}
			}else {
				if(sex!=null&&sex!=""){
					query=query+" where gender=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, sex).list();
				}else {
					System.out.println("没有参数");
					return this.sessionFactory.getCurrentSession().createQuery(query).list();
				}
			}
		}
		
	}

	/**
	 * 修改用户状态
	 */
	@Override
	public void userEdit(int id) {
		User user=(User) this.sessionFactory.getCurrentSession().createQuery("from User where id=?").setParameter(0,id).uniqueResult();
		if(user.getStatus().equals("正常")){
			user.setStatus("冻结");
		}else{
			user.setStatus("正常");
		}
		this.sessionFactory.getCurrentSession().update(user);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void userDelete(int id) {
		User user=(User) this.sessionFactory.getCurrentSession().createQuery("from User where id=?").setParameter(0, id).uniqueResult();;
		
		this.sessionFactory.getCurrentSession().delete(user);
	}

	/**
	 * 分页查询用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> userListPage(String userName, String status, String sex, int index) {
		
		String query="from User";
		if(userName!=null&&userName!=""){
			userName="%"+userName+"%";
			query=query+" where userName like ?";
			if(status!=null&&status!="") {
				query=query+" and status=?";
				if(sex!=null&&sex!=""){
					query=query+" and gender=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setParameter(1, status).setParameter(2, sex).setFirstResult((index-1)*5).setMaxResults(5).list();
				}else {
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setParameter(1, status).setFirstResult((index-1)*5).setMaxResults(5).list();
				}
				
			}else {
				if(sex!=null&&sex!=""){
					query=query+" and gender=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setParameter(1, sex).setFirstResult((index-1)*5).setMaxResults(5).list();
				}else {
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setFirstResult((index-1)*5).setMaxResults(5).list();
				}
			}
		}else{
			if(status!=null&&status!="") {
				query=query+" where status=?";
				if(sex!=null&&sex!=""){
					query=query+" and gender=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).setParameter(1, sex).setFirstResult((index-1)*5).setMaxResults(5).list();
				}else{
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).setFirstResult((index-1)*5).setMaxResults(5).list();
				}
			}else {
				if(sex!=null&&sex!=""){
					query=query+" where gender=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, sex).setFirstResult((index-1)*5).setMaxResults(5).list();
				}else {
					System.out.println("没有参数");
					return this.sessionFactory.getCurrentSession().createQuery(query).setFirstResult((index-1)*5).setMaxResults(5).list();
				}
			}
		}
	}

}
