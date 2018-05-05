package com.project.dao;

import java.util.List;

import com.project.model.SmallType;

public interface ProductTypeDao {

	//查询商品类型
	public List<SmallType> productTypeList(String typeName,String bigTypeName);
	
	//分页查询商品类型
	public List<SmallType> productTypeListPage(String typeName,String bigTypeName,int index);
	
	//根据id查询商品类型
	public SmallType productTypeById(int id);
	
	//修改或增加商品类型
	public void productTypeEdit(SmallType productTypeModel);
		
	//删除商品类型
	public void productTypeDelete(int id);
	
}
