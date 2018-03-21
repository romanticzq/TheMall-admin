package com.project.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.UserDao;
import com.project.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory; 

	/**
	 * 查询用户
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> userList(String userName,int status,int sex) {
		System.out.println("查询："+userName+","+status+","+sex);
		String query="from UserModel";
		if(userName!=null&&userName!=""){
			userName="%"+userName+"%";
			query=query+" where userName like ?";
			if(status!=0) {
				query=query+" and status=?";
				if(sex!=0){
					query=query+" and sex=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setParameter(1, status).setParameter(2, sex).list();
				}else {
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setParameter(1, status).list();
				}
				
			}else {
				if(sex!=0){
					query=query+" and sex=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).setParameter(1, sex).list();
				}else {
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userName).list();
				}
			}
		}else{
			if(status!=0) {
				query=query+" where status=?";
				if(sex!=0){
					query=query+" and sex=?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).setParameter(1, sex).list();
				}else{
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, status).list();
				}
			}else {
				if(sex!=0){
					query=query+" where sex=?";
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
		UserModel user=(UserModel) this.sessionFactory.getCurrentSession().createQuery("from UserModel where id=?").setParameter(0,id).uniqueResult();
		if(user.getStatus()==1){
			user.setStatus(2);
		}else{
			user.setStatus(1);
		}
		this.sessionFactory.getCurrentSession().update(user);
	}

	/**
	 * 删除用户
	 */
	@Override
	public void userDelete(int id) {
		UserModel user=new UserModel(id);
		this.sessionFactory.getCurrentSession().delete(user);
	}

}
