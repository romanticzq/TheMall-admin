package com.project.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.ProductDao;
import com.project.dao.ProductTypeDao;
import com.project.model.ProductModel;
import com.project.model.ProductTypeModel;

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
	public List<ProductModel> productList(String name,String typeName) {
		
		String query="from ProductModel";
		if(name!=null&&name!=""){
			name="%"+name+"%";
			if(typeName!=null&&typeName!=""){
				query=query+" where productName like ? and type_id=(select id from ProductTypeModel where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).setParameter(1,typeName).list();
			}else{
				query=query+" where productName like ?";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).list();
			}	
		}else{
			if(typeName!=null&&typeName!=""){
				query=query+" where type_id=(select id from ProductTypeModel where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0,typeName).list();
			}else{
				return this.sessionFactory.getCurrentSession().createQuery(query).list();
			}
		}
		
	}
	
	/**
	 * 分页查询商品
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> productListPage(String name, String typeName, int index) {
		
		String query="from ProductModel";
		if(name!=null&&name!=""){
			name="%"+name+"%";
			if(typeName!=null&&typeName!=""){
				query=query+" where productName like ? and type_id=(select id from ProductTypeModel where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).setParameter(1,typeName).setFirstResult((index-1)*5).setMaxResults(5).list();
			}else{
				query=query+" where productName like ?";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0, name).setFirstResult((index-1)*5).setMaxResults(5).list();
			}	
		}else{
			if(typeName!=null&&typeName!=""){
				query=query+" where type_id=(select id from ProductTypeModel where typeName=?)";
				return this.sessionFactory.getCurrentSession().createQuery(query).setParameter(0,typeName).setFirstResult((index-1)*5).setMaxResults(5).list();
			}else{
				return this.sessionFactory.getCurrentSession().createQuery(query).setFirstResult((index-1)*5).setMaxResults(5).list();
			}
		}
	}
	
	/**
	 * 根据id查询商品列表
	 */
	@Override
	public ProductModel productById(int id) {
		
		return (ProductModel)this.sessionFactory.getCurrentSession().createQuery("from ProductModel where id=?").setParameter(0, id).uniqueResult();
	}
	
	/**
	 * 修改或增加商品
	 */
	@Override
	public void productEdit(ProductModel productModel) {
		
		List<ProductTypeModel> type=ProductTypeDao.productTypeList(productModel.getType().getTypeName());
		productModel.setType(type.get(0));
		this.sessionFactory.getCurrentSession().saveOrUpdate(productModel);
	}

	/**
	 * 删除商品
	 */
	@Override
	public void productDelete(int id) {
		
		ProductModel productType=new ProductModel(id);
		this.sessionFactory.getCurrentSession().delete(productType);
	}

	
}
