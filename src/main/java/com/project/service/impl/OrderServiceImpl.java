package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.OrderDao;
import com.project.model.Orders;
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
	public List<Orders> orderList(String status,String userName) {
		
		return this.orderDao.orderList(status,userName);
	}
	
	/**
	 * 分页查询订单
	 */
	@Override
	public List<Orders> orderListPage(String status,String userName,int index) {
		
		return this.orderDao.orderListPage(status,userName,index);
	}

	/**
	 * 根据id查询订单
	 */
	@Override
	public Orders findOrdersById(int id) {
		
		return this.orderDao.findOrdersById(id);
	}

	/**
	 * 保存订单
	 */
	@Override
	public void saveOrders(Orders order) {
		
		this.orderDao.saveOrders(order);
	}
}
