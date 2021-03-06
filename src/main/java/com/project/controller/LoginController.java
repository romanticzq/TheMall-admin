package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
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
	 * 去到首页
	 * @param user
	 * @return
	 */
	@RequestMapping(value="index")
	public ModelAndView  index(){
		
		return new ModelAndView("main");
	}
	
	/**
	 * 去到首页
	 * @param user
	 * @return
	 */
	@RequestMapping(value="welcome")
	public ModelAndView  welcome(){
		
		return new ModelAndView("welcome");
	}
	
	/**
	 * 判断用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value="adminLogin")
	@ResponseBody
	public String  adminLogin(String name,String password,String val,HttpServletRequest request){
		System.out.println("登录验证");
		System.out.println(val);
		JSONObject json=new JSONObject();
		//验证码
        String validatecode = (String)request.getSession().getAttribute("ValidateCode");
        if(validatecode==null){
        	json.put("msg", "请刷新验证码");
        	return json.toJSONString();
        }
        request.getSession().removeAttribute("ValidateCode");
        if(!validatecode.equalsIgnoreCase(val)){
        	json.put("msg", "验证码错误");
        	return json.toJSONString();
        }
        json.put("msg", false);
		if(this.loginService.adminLogin(name, password)){
//			return new ModelAndView("main");
			json.put("success", true);
		}else{
			json.put("success", false);
		}
//		return new ModelAndView("redirect:/index.jsp");
		System.out.println(json.get("success"));
		return json.toJSONString();
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	@RequestMapping(value="admin_loginout")
	public ModelAndView  adminLoginOut(){
		return new ModelAndView("redirect:/");
	}
	
//	/**
//	 * 判断用户登录
//	 * @param user
//	 * @return
//	 */
//	@RequestMapping(value="admin_login")
//	public ModelAndView  adminLogin(String name,String password){
//		System.out.println("登录验证");
//		System.out.println(name+password);
//		if(this.loginService.adminLogin(name, password)){
//			Subject sub = SecurityUtils.getSubject();
//            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
//            sub.login(token);
//			return new ModelAndView("main");
//		}
//		return new ModelAndView("login");
//	}
}
