package com.project.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.ProductDao;
import com.project.dao.ProductTypeDao;
import com.project.model.Commodity;
import com.project.model.SmallType;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Autowired
	private ProductTypeDao ProductTypeDao;
	
	/**
	 * 查询商品列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> productList(String name,String typeName,String bigTypeName) {
		
		String query="from Commodity";
		if(name!=null&&name!=""){
			name="%"+name+"%";
			if(typeName!=null&&typeName!=""){
				query=query+" where productName like ? and small_id=(select id from SmallType where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).setParameter(1,typeName).list();
			}else{
				if(bigTypeName!=null&&bigTypeName!=""){
					query=query+" where productName like ? and small_id in (select id from SmallType where big_id=(select id from BigType where typeName=?))";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).setParameter(1,bigTypeName).list();
				}else{
					query=query+" where productName like ?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).list();
				}
			}	
		}else{
			if(typeName!=null&&typeName!=""){
				query=query+" where small_id=(select id from SmallType where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0,typeName).list();
			}else{
				if(bigTypeName!=null&&bigTypeName!=""){
					query=query+" where small_id in (select id from SmallType where big_id=(select id from BigType where typeName=?))";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, bigTypeName).list();
				}else{
					return this.sessionFactory.getCurrentSession().createQuery(query).list();
				}
			}
		}
		
	}
	
	/**
	 * 分页查询商品
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity> productListPage(String name, String typeName,String bigTypeName, int index) {
		
		String query="from Commodity";
		if(name!=null&&name!=""){
			name="%"+name+"%";
			if(typeName!=null&&typeName!=""){
				query=query+" where productName like ? and small_id=(select id from SmallType where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).setParameter(1,typeName).setFirstResult((index-1)*5).setMaxResults(5).list();
			}else{
				if(bigTypeName!=null&&bigTypeName!=""){
					query=query+" where productName like ? and small_id in (select id from SmallType where big_id=(select id from BigType where typeName=?))";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).setParameter(1,bigTypeName).setFirstResult((index-1)*5).setMaxResults(5).list();
				}else{
					query=query+" where productName like ?";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).setFirstResult((index-1)*5).setMaxResults(5).list();
				}
			}	
		}else{
			if(typeName!=null&&typeName!=""){
				query=query+" where small_id=(select id from SmallType where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0,typeName).setFirstResult((index-1)*5).setMaxResults(5).list();
			}else{
				if(bigTypeName!=null&&bigTypeName!=""){
					query=query+" where small_id in (select id from SmallType where big_id=(select id from BigType where typeName=?))";
					return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, bigTypeName).setFirstResult((index-1)*5).setMaxResults(5).list();
				}else{
					return this.sessionFactory.getCurrentSession().createQuery(query).setFirstResult((index-1)*5).setMaxResults(5).list();
				}
			}
		}
	}
	
	/**
	 * 根据id查询商品列表
	 */
	@Override
	public Commodity productById(int id) {
		
		return (Commodity)this.sessionFactory.getCurrentSession().createQuery("from Commodity where id=?").setParameter(0, id).uniqueResult();
	}
	
	/**
	 * 修改或增加商品
	 */
	@Override
	public void productEdit(Commodity productModel) {
		
		List<SmallType> type=ProductTypeDao.productTypeList(productModel.getSmallType().getTypeName(),null);
		productModel.setSmallType(type.get(0));
		this.sessionFactory.getCurrentSession().saveOrUpdate(productModel);
	}

	/**
	 * 删除商品
	 */
	@Override
	public void productDelete(int id) {
		
		Commodity productType=new Commodity(id);
		this.sessionFactory.getCurrentSession().delete(productType);
	}

	
}
