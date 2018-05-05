package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ExpressDao;
import com.project.model.Express;
import com.project.service.ExpressService;

@Service
@Transactional
public class ExpressServiceImpl implements ExpressService{

	@Autowired
	private ExpressDao expressDao;
	
	/**
	 * 查询快递信息
	 */
	@Override
	public List<Express> expressList() {
		
		return this.expressDao.expressList();
	}

	/**
	 * 查询快递信息
	 */
	@Override
	public Express findExpressByName(String name) {
		
		return this.expressDao.findExpressByName(name);
	}
	
}
