package com.project.dao;

import java.util.List;

import com.project.model.OrderModel;

public interface OrderDao {

	//查询订单
	public List<OrderModel> orderList(int status,String userName);
				
		
}
