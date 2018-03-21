package com.project.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.ProductTypeDao;
import com.project.model.Page;
import com.project.model.ProductTypeModel;

@Repository
public class ProductTypeDaoImpl implements ProductTypeDao{

	@Autowired
	private SessionFactory sessionFactory; 
	
	/**
	 * 查询商品类型列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductTypeModel> productTypeList(String typeName) {
		
		String query="from ProductTypeModel";
		if(typeName!=null&&typeName!=""){
			query=query+" where typeName=?";
			return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, typeName).list();
		}
		return this.sessionFactory.getCurrentSession().createQuery(query).list();
	}
	
	/**
	 * 分页查询商品类型列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductTypeModel> productTypeListPage(String typeName,int index) {
		
		String query="from ProductTypeModel";
		if(typeName!=null&&typeName!=""){
			query=query+" where typeName=?";
			return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, typeName).setFirstResult((index-1)*5).setMaxResults(5).list();
		}
		return this.sessionFactory.getCurrentSession().createQuery(query).setFirstResult((index-1)*5).setMaxResults(5).list();
	}
	
	/**
	 * 根据id查询商品类型列表
	 */
	@Override
	public ProductTypeModel productTypeById(int id) {
		
		return (ProductTypeModel)this.sessionFactory.getCurrentSession().createQuery("from ProductTypeModel where id=?").setParameter(0, id).uniqueResult();
	}
	
	/**
	 * 修改或删除商品类型
	 */
	@Override
	public void productTypeEdit(ProductTypeModel productTypeModel) {
		
		this.sessionFactory.getCurrentSession().saveOrUpdate(productTypeModel);
	}

	/**
	 * 删除商品类型
	 */
	@Override
	public void productTypeDelete(int id) {
		
		ProductTypeModel productType=new ProductTypeModel(id);
		this.sessionFactory.getCurrentSession().delete(productType);
	}

	/**
	 * 分页查询商品类型记录
	 */
	@Override
	public Page productTypeListPage(Page page) {
		
		return null;
	}

	
	
}
