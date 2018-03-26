package com.project.dao;

import java.util.List;

import com.project.model.ProductTypeModel;

public interface ProductTypeDao {

	//查询商品类型
	public List<ProductTypeModel> productTypeList(String typeName);
	
	//分页查询商品类型
	public List<ProductTypeModel> productTypeListPage(String typeName,int index);
	
	//根据id查询商品类型
	public ProductTypeModel productTypeById(int id);
	
	//修改或增加商品类型
	public void productTypeEdit(ProductTypeModel productTypeModel);
		
	//删除商品类型
	public void productTypeDelete(int id);
	
}
