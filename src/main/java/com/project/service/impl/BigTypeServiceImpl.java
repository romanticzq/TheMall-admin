package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.BigTypeDao;
import com.project.model.BigType;
import com.project.service.BigTypeService;

@Service
@Transactional
public class BigTypeServiceImpl implements BigTypeService{
	
	@Autowired
	private BigTypeDao bigType;

	@Override
	public List<BigType> bigTypeList() {
		
		return this.bigType.bigTypeList();
	}

	@Override
	public BigType bigTypeById(int id) {
		
		return this.bigType.bigTypeById(id);
	}

	@Override
	public BigType bigTypeByName(String name) {
		
		return this.bigType.bigTypeByName(name);
	}

}
