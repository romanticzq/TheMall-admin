package com.project.dao;

import java.util.List;

import com.project.model.Commodity;

public interface ProductDao {

	//查询商品
	public List<Commodity> productList(String name,String typeName,String bigTypeName);
			
	//分页查询商品
	public List<Commodity> productListPage(String name,String typeName,String bigTypeName,int index);
		
	//根据id查询商品
	public Commodity productById(int id);
		
	//修改或增加商品
	public void productEdit(Commodity productModel);
			
	//删除商品
	public void productDelete(int id);
}
