package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.project.model.OrderModel;
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
		
		List<OrderModel> orderList=this.orderService.orderList(sta,userName);
		modelAndView.addObject("num",orderList.size());
		modelAndView.addObject("sta",sta);
		modelAndView.addObject("userName",userName);
		int size=orderList.size();
		if(size>5){
			orderList=orderList.subList(0, 5);
		}
		
		modelAndView.addObject("orderList", orderList);
		return modelAndView;
	}
	
	/**
	 * 分页插件查询订单
	 */
	@RequestMapping(value="order_list_page_plug")
	@ResponseBody
	public String orderListPagePlug(String status,String userName,int index){
		System.out.println("进入显示");
		int sta=0;
		if(status!=null&&status!=""){
			if(status.equals("1")){
				sta=1;
			}else if(status.equals("2")){
				sta=2;
			}else if(status.equals("3")){
				sta=3;
			}
		}
		List<OrderModel> orderList=this.orderService.orderListPage(sta, userName, index);
		
		JSONObject jo=new JSONObject();
		jo.put("orderList", orderList);
		System.out.println(orderList);
		return JSON.toJSONString(jo, SerializerFeature.DisableCircularReferenceDetect);
	}
	
	/**
	 * 查看详情
	 */
	@RequestMapping(value="order_send",method=RequestMethod.POST)
	public ModelAndView orderSend(int id){
		System.out.println("进入发货");
		this.orderService.orderSend(id);
		return orderList(null, null);
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
