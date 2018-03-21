package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	/**
	 * 去到登录页面
	 * @return
	 */
	@RequestMapping(value="admin_to_login")
	public ModelAndView  adminToLogin(){
		System.out.println("进入登录页面");
		return new ModelAndView("login");
	}
	
	/**
	 * 判断用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value="admin_login")
	public ModelAndView  adminLogin(String name,String password){
		System.out.println("登录验证");
		System.out.println(name+password);
		if(this.loginService.adminLogin(name, password)){
			return new ModelAndView("main");
		}
		return new ModelAndView("login");
	}
}
