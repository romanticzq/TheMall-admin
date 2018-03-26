package com.project.service;

import java.util.List;

import com.project.model.ProductModel;

public interface ProductService {

	//查询商品
	public List<ProductModel> productList(String name,String typeName);
	
	//分页查询商品
	public List<ProductModel> productListPage(String name,String typeName,int index);
		
	//根据id查询商品
	public ProductModel productById(int id);
			
	//修改或增加商品
	public void productEdit(ProductModel productModel);
				
	//删除商品
	public void productDelete(int id);
}
