package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/**
	 * 查询订单
	 */
	@RequestMapping(value="order_list")
	public ModelAndView orderList(String status,String userName){
		System.out.println("进入显示");
		ModelAndView modelAndView=new ModelAndView("order/orderList");
		int sta=0;
		if(status!=null&&status!=""){
			if(status.equals("w")){
				sta=1;
			}else if(status.equals("f")){
				sta=2;
			}else if(status.equals("q")){
				sta=3;
			}
		}
		modelAndView.addObject("orderList", this.orderService.orderList(sta,userName));
		return modelAndView;
	}
	
	/**
	 * 查看详情
	 */
	@RequestMapping(value="order_detail",method=RequestMethod.GET)
	public ModelAndView orderDetail(int id){
		System.out.println("进入显示");
		ModelAndView modelAndView=new ModelAndView("order/orderForm");
		modelAndView.addObject("productList", null);
		return modelAndView;
	}
}
