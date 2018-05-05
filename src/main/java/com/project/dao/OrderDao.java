package com.project.dao;

import java.util.List;

import com.project.model.Orders;

public interface OrderDao {

	//查询订单
	public List<Orders> orderList(String status,String userName);
				
	//分页查询订单
	public List<Orders> orderListPage(String status,String userName,int index);	
	
	//根据id查找订单
	public Orders findOrdersById(int id);
	
	//保存订单
	public void saveOrders(Orders order);
}
