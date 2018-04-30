package com.project.service;

import java.util.List;

import com.project.model.BigType;

public interface BigTypeService {
	
	//查询顶级商品类型
	public List<BigType> bigTypeList();
			
	//根据id查询顶级商品类型
	public BigType bigTypeById(int id);
	
	//根据名称查询顶级商品类型
	public BigType bigTypeByName(String name);

}
