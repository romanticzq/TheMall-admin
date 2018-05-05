package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductDao;
import com.project.model.Commodity;
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
	public List<Commodity> productList(String name,String typeName,String bigTypeName) {
		
		return this.productDao.productList(name,typeName,bigTypeName);
	}

	/**
	 * 分页查询商品
	 */
	@Override
	public List<Commodity> productListPage(String name, String typeName,String bigTypeName, int index) {
		
		return this.productDao.productListPage(name, typeName,bigTypeName, index);
	}
	
	/**
	 * 根据id查询商品
	 */
	@Override
	public Commodity productById(int id) {
		
		return this.productDao.productById(id);
	}

	/**
	 * 修改或增加商品
	 */
	@Override
	public void productEdit(Commodity productModel) {
		
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
