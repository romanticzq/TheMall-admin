package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.OrderDao;
import com.project.model.OrderModel;
import com.project.service.OrderService;

@Transactional
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;

	/**
	 * 查询订单
	 */
	@Override
	public List<OrderModel> orderList(int status,String userName) {
		
		return this.orderDao.orderList(status,userName);
	}
	
	
}
