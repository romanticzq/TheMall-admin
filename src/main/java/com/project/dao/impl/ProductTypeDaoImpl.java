package com.project.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.ProductTypeDao;
import com.project.model.SmallType;

@Repository
public class ProductTypeDaoImpl implements ProductTypeDao{

	@Autowired
	private SessionFactory sessionFactory; 
	
	/**
	 * 查询商品类型列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SmallType> productTypeList(String typeName,String bigTypeName) {
		
		String query="from SmallType";
		if(typeName!=null&&typeName!=""){
			typeName="%"+typeName+"%";
			if(bigTypeName!=null&&bigTypeName!=""){
				query=query+" where typeName like ? and big_id=(select id from BigType where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, typeName).setParameter(1,bigTypeName).list();
			}else{
				query=query+" where typeName like ?";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, typeName).list();
			}
		}else{
			if(bigTypeName!=null&&bigTypeName!=""){
				query=query+" where big_id=(select id from BigType where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, bigTypeName).list();
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
	public List<SmallType> productTypeListPage(String typeName,String bigTypeName,int index) {
		
		String query="from SmallType";
		if(typeName!=null&&typeName!=""){
			typeName="%"+typeName+"%";
			if(bigTypeName!=null&&bigTypeName!=""){
				query=query+" where typeName like ? and big_id=(select id from BigType where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, typeName).setParameter(1,bigTypeName).setFirstResult((index-1)*5).setMaxResults(5).list();
			}else{
				query=query+" where typeName like ?";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, typeName).setFirstResult((index-1)*5).setMaxResults(5).list();
			}
		}else{
			if(bigTypeName!=null&&bigTypeName!=""){
				query=query+" where big_id=(select id from BigType where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, bigTypeName).setFirstResult((index-1)*5).setMaxResults(5).list();
			}else{
				return this.sessionFactory.getCurrentSession().createQuery(query).setFirstResult((index-1)*5).setMaxResults(5).list();
			}
		}
	}
	
	/**
	 * 根据id查询商品类型列表
	 */
	@Override
	public SmallType productTypeById(int id) {
		
		return (SmallType)this.sessionFactory.getCurrentSession().createQuery("from SmallType where id=?").setParameter(0, id).uniqueResult();
	}
	
	/**
	 * 修改或删除商品类型
	 */
	@Override
	public void productTypeEdit(SmallType productTypeModel) {
		
		this.sessionFactory.getCurrentSession().saveOrUpdate(productTypeModel);
	}

	/**
	 * 删除商品类型
	 */
	@Override
	public void productTypeDelete(int id) {
		
		SmallType productType=new SmallType(id);
		this.sessionFactory.getCurrentSession().delete(productType);
	}

	
}
