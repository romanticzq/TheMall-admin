package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductTypeDao;
import com.project.model.ProductTypeModel;
import com.project.service.ProductTypeService;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService{

	@Autowired
	private ProductTypeDao productTypeDao;
	
	/**
	 * 查询商品类型列表
	 */
	@Override
	public List<ProductTypeModel> productTypeList(String typeName,String bigTypeName) {
		
		return this.productTypeDao.productTypeList(typeName,bigTypeName);
	}
	
	/**
	 * 分页查询商品类型列表
	 */
	@Override
	public List<ProductTypeModel> productTypeListPage(String typeName,String bigTypeName,int index) {
		
		return this.productTypeDao.productTypeListPage(typeName,bigTypeName,index);
	}
	
	/**
	 * 根据查询商品类型列表
	 */
	@Override
	public ProductTypeModel productTypeList(int id) {
		
		return this.productTypeDao.productTypeById(id);
	}
	
	/**
	 * 修改或增加商品类型列表
	 */
	@Override
	public void productTypeEdit(ProductTypeModel productTypeModel) {
		
		this.productTypeDao.productTypeEdit(productTypeModel);
	}
	
	/**
	 * 删除商品类型列表
	 */
	@Override
	public void productTypeDelete(int id) {
		
		this.productTypeDao.productTypeDelete(id);
	}

	
}
