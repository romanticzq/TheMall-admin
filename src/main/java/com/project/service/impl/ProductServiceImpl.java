package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductDao;
import com.project.model.ProductModel;
import com.project.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	/**
	 * 查询商品
	 */
	@Override
	public List<ProductModel> productList(String name,String typeName) {
		
		return this.productDao.productList(name,typeName);
	}

	/**
	 * 分页查询商品
	 */
	@Override
	public List<ProductModel> productListPage(String name, String typeName, int index) {
		
		return this.productDao.productListPage(name, typeName, index);
	}
	
	/**
	 * 根据id查询商品
	 */
	@Override
	public ProductModel productById(int id) {
		
		return this.productDao.productById(id);
	}

	/**
	 * 修改或增加商品
	 */
	@Override
	public void productEdit(ProductModel productModel) {
		
		this.productDao.productEdit(productModel);
	}

	/**
	 * 删除商品
	 */
	@Override
	public void productDelete(int id) {
		
		this.productDao.productDelete(id);
	}


}
