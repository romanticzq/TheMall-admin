package com.project.controller;


import java.util.Date;
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
import com.project.model.BigType;
import com.project.model.Commodity;
import com.project.model.SmallType;
import com.project.service.BigTypeService;
import com.project.service.ProductService;
import com.project.service.ProductTypeService;

@Controller
public class ProductTypeController {
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@Autowired
	private BigTypeService bigTypeService;
	
	@Autowired
	private ProductService productService;

	/**
	 * 查询商品类型列表
	 */
	@RequestMapping(value="productType_list")
	public ModelAndView productTypeList(String typeName,String bigTypeName){
		System.out.println("进入显示");
		ModelAndView modelAndView=new ModelAndView("productType/productTypeList");
		List<SmallType> productTypeList=this.productTypeService.productTypeList(typeName,bigTypeName);
		modelAndView.addObject("num", productTypeList.size());
		modelAndView.addObject("typeName", typeName);
		modelAndView.addObject("bigTypeName", bigTypeName);
		modelAndView.addObject("bigTypeList", this.bigTypeService.bigTypeList());
		
		List<SmallType> list=null;
		int size=productTypeList.size();
		if(size>5){
			list=productTypeList.subList(0, 5);
		}else if(size>0){
			list=productTypeList.subList(0, size);
		}
		
		
		modelAndView.addObject("productTypeList", list);
		return modelAndView;
	}
	
	
	/**
	 * 分页插件查询商品类型列表
	 */
	@RequestMapping(value="productType_list_page_plug", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String productTypeListPagePlug(String name,String bigTypeName,int index){
		System.out.println("进入显示");
		List<SmallType> productTypeList=this.productTypeService.productTypeListPage(name,bigTypeName,index);
		JSONObject jo=new JSONObject();
		jo.put("productTypeList", productTypeList);
		System.out.println(productTypeList);
		return JSON.toJSONString(jo, SerializerFeature.DisableCircularReferenceDetect);
	}
	
	/**
	 * 根据id查询商品类型
	 */
	@RequestMapping(value="productType_byid")
	public SmallType productTypeById(int id){
		return this.productTypeService.productTypeList(id);
	}
	
	/**
	 * 商品类型修改页
	 */
	@RequestMapping(value="productType_to_edit")
	public ModelAndView productTypeToEdit(int id){
		System.out.println("修改");
		ModelAndView modelAndView=new ModelAndView("productType/productTypeEdit");
		SmallType productType=null;
		if(id>0){
			productType=productTypeById(id);
		}
		modelAndView.addObject("productType", productType);
		List<BigType> bigType=bigTypeService.bigTypeList();
		modelAndView.addObject("bigType", bigType);
		return modelAndView;
	}
	
	/**
	 * 商品类型新增页
	 */
	@RequestMapping(value="productType_to_form")
	public ModelAndView productTypeToForm(int id){
		System.out.println("去新增");
		ModelAndView modelAndView=new ModelAndView("productType/productTypeForm");
		SmallType productType=null;
		if(id>0){
			productType=productTypeById(id);
		}
		modelAndView.addObject("productType", productType);
		List<BigType> bigType=bigTypeService.bigTypeList();
		modelAndView.addObject("bigType", bigType);
		return modelAndView;
	}
	
	/**
	 * 商品类型修改或修改
	 */
	@RequestMapping(value="productType_edit",method=RequestMethod.POST)
	public ModelAndView productTypeEdit(SmallType productType,String bigTypeName){
		if(productType.getId()>0){
			productType.setCreateDate(productTypeById(productType.getId()).getCreateDate());
		}else{
			productType.setCreateDate(new Date());
		}
		productType.setBigType(bigTypeService.bigTypeByName(bigTypeName));
		productType.setEditDate(new Date());
		productTypeService.productTypeEdit(productType);
		return productTypeList(null,null);
	}

	/**
	 * 删除商品类型
	 */
	@RequestMapping(value="productType_delete")
	@ResponseBody
	public String productTypeDelete(int id){
		JSONObject jo=new JSONObject();
		SmallType smallType=productTypeById(id);
		List<Commodity> comList= productService.productList(null, smallType.getTypeName(), null);
		if(comList==null||comList.size()<1){
			productTypeService.productTypeDelete(id);
			jo.put("msg", "success");
		}else{
			jo.put("msg", "default");
		}
		return jo.toJSONString();
	}
	
}
