package com.project.service;

import java.util.List;

import com.project.model.Express;

public interface ExpressService {

	//查询快递信息
	public List<Express> expressList();
	
	//根据公司名称查询快递信息
	public Express findExpressByName(String name);
}
