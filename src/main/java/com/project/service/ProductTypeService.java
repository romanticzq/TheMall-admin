package com.project.service;

import java.util.List;

import com.project.model.ProductTypeModel;

public interface ProductTypeService {

	//查询商品类型
	public List<ProductTypeModel> productTypeList(String typeName,String bigTypeName);
	
	//分院查询商品类型
	public List<ProductTypeModel> productTypeListPage(String typeName,String bigTypeName,int index);
			
	//根据id查询商品类型
	public ProductTypeModel productTypeList(int id);
	
	//修改或增加商品类型
	public void productTypeEdit(ProductTypeModel productTypeModel);
			
	//删除商品类型
	public void productTypeDelete(int id);
}
