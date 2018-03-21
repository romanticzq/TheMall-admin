package com.project.service;

import java.util.List;

import com.project.model.OrderModel;

public interface OrderService {

	//查询订单
	public List<OrderModel> orderList(int status,String userName);
}
