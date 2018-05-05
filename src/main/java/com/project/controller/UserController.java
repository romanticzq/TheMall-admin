package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.project.model.User;
import com.project.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 查询用户
	 * @return
	 */
	@RequestMapping(value="user_list")
	public ModelAndView  userList(String userName,String status,String sex){
		System.out.println("进入显示");
		ModelAndView modelAndView=new ModelAndView("user/userList");
		
		List<User> userList=this.userService.userList(userName, status, sex);
		modelAndView.addObject("num", userList.size());
		modelAndView.addObject("sta",status);
		modelAndView.addObject("userName",userName);
		modelAndView.addObject("se",sex);
		int size=userList.size();
		if(size>5){
			userList=userList.subList(0, 5);
		}
		
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	
	/**
	 * 分页插件查询订单
	 */
	@RequestMapping(value="user_list_page_plug")
	@ResponseBody
	public String userListPagePlug(String userName,String status,String sex,int index){
		
		List<User> userList=this.userService.userListPage(userName, status, sex, index);
		JSONObject jo=new JSONObject();
		jo.put("userList", userList);
		return jo.toJSONString();
	}
	
	/**
	 * 修改用户状态
	 * @param id
	 * @return
	 */
	@RequestMapping(value="user_edit")
	public ModelAndView  userEdit(int id){
		System.out.println("进入修改");
		this.userService.userEdit(id);
		return userList(null,null,null);
	}
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value="user_delete")
	public ModelAndView  userDelete(int id){
		System.out.println("进入删除");
		this.userService.userDelete(id);
		return userList(null,null,null);
	}
}
