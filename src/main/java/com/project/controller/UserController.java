package com.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
				sta=1;
			}else if(sex.equals("f")){
				sta=2;
			}
		}
		modelAndView.addObject("userList", this.userService.userList(userName,sta,se));
		return modelAndView;
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
