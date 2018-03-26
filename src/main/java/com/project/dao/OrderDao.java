package com.project.dao;

import java.util.List;

import com.project.model.OrderModel;

public interface OrderDao {

	//查询订单
	public List<OrderModel> orderList(int status,String userName);
				
	//分页查询订单
	public List<OrderModel> orderListPage(int status,String userName,int index);	
	
	//订单发货
	public void orderSend(int id);
}
