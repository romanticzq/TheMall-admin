package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.project.model.ProductTypeModel;
import com.project.service.ProductTypeService;

@Controller
public class ProductTypeController {
	
	@Autowired
	private ProductTypeService productTypeService;

	/**
	 * 查询商品类型列表
	 */
	@RequestMapping(value="productType_list")
	public ModelAndView productTypeList(String typeName){
		System.out.println("进入显示");
		ModelAndView modelAndView=new ModelAndView("productType/productTypeList");
		List<ProductTypeModel> productTypeList=this.productTypeService.productTypeList(typeName);
		modelAndView.addObject("num", productTypeList.size());
		modelAndView.addObject("typeName", typeName);
		List<ProductTypeModel> list=null;
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
	public String productTypeListPagePlug(String name,int index){
		System.out.println("进入显示");
		List<ProductTypeModel> productTypeList=this.productTypeService.productTypeListPage(name, index);
		JSONObject jo=new JSONObject();
		jo.put("productTypeList", productTypeList);
		System.out.println(productTypeList);
		return jo.toJSONString();
	}
	
	/**
	 * 根据id查询商品类型
	 */
	@RequestMapping(value="productType_byid")
	public ProductTypeModel productTypeById(int id){
		System.out.println("根据id查询商品类型列表");
		return this.productTypeService.productTypeList(id);
	}
	
	/**
	 * 商品类型新增页或修改页
	 */
	@RequestMapping(value="productType_to_edit")
	public ModelAndView productTypeToEdit(ProductTypeModel productType){
		System.out.println("去新增或修改");
		ModelAndView modelAndView=new ModelAndView("productType/productTypeForm");
		if(productType.getId()>0){
			productType=productTypeById(productType.getId());
		}
		modelAndView.addObject("productType", productType);
		return modelAndView;
	}
	
	/**
	 * 商品类型新增或修改
	 */
	@RequestMapping(value="productType_edit",method=RequestMethod.POST)
	public ModelAndView productTypeEdit(ProductTypeModel productType){
		System.out.println("新增或修改");
		if(productType.getId()>0){
			productType.setCreateDate(productTypeById(productType.getId()).getCreateDate());
		}
		productTypeService.productTypeEdit(productType);
		return productTypeList(null);
	}
	
	/**
	 * 删除商品
	 */
	@RequestMapping(value="productType_delete")
	public ModelAndView productTypeDelete(int id){
		System.out.println("去新增或修改");
		productTypeService.productTypeDelete(id);
		return productTypeList(null);
	}
	
}
