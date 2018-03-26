package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.project.model.UserModel;
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
		
		int sta=0;
		if(status!=null&&status!=""){
			if(status.equals("z")){
				sta=1;
			}else if(status.equals("d")){
				sta=2;
			}
		}
		
		int se=0;
		if(sex!=null&&sex!=""){
			if(sex.equals("m")){
				se=1;
			}else if(sex.equals("f")){
				se=2;
			}
		}
		
		List<UserModel> userList=this.userService.userList(userName, sta, se);
		modelAndView.addObject("num", userList.size());
		modelAndView.addObject("sta",sta);
		modelAndView.addObject("userName",userName);
		modelAndView.addObject("se",se);
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
		
		int sta=0;
		if(status!=null&&status!=""){
			if(status.equals("1")){
				sta=1;
			}else if(status.equals("2")){
				sta=2;
			}
		}
		
		int s=0;
		if(sex!=null&&sex!=""){
			if(sex.equals("1")){
				s=1;
			}else if(sex.equals("2")){
				s=2;
			}
		}
		List<UserModel> userList=this.userService.userListPage(userName, sta, s, index);
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
		this.userService.userDelete(id);;
		return userList(null,null,null);
	}
}
