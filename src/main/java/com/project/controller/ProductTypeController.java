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
import com.project.model.BigType;
import com.project.model.ProductTypeModel;
import com.project.service.BigTypeService;
import com.project.service.ProductTypeService;

@Controller
public class ProductTypeController {
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@Autowired
	private BigTypeService bigTypeService;

	/**
	 * 查询商品类型列表
	 */
	@RequestMapping(value="productType_list")
	public ModelAndView productTypeList(String typeName,String bigTypeName){
		System.out.println("进入显示");
		ModelAndView modelAndView=new ModelAndView("productType/productTypeList");
		List<ProductTypeModel> productTypeList=this.productTypeService.productTypeList(typeName,bigTypeName);
		modelAndView.addObject("num", productTypeList.size());
		modelAndView.addObject("typeName", typeName);
		modelAndView.addObject("bigTypeName", bigTypeName);
		modelAndView.addObject("bigTypeList", this.bigTypeService.bigTypeList());
		
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
	public String productTypeListPagePlug(String name,String bigTypeName,int index){
		System.out.println("进入显示");
		List<ProductTypeModel> productTypeList=this.productTypeService.productTypeListPage(name,bigTypeName,index);
		JSONObject jo=new JSONObject();
		jo.put("productTypeList", productTypeList);
		System.out.println(productTypeList);
		return JSON.toJSONString(jo, SerializerFeature.DisableCircularReferenceDetect);
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
		List<BigType> bigType=bigTypeService.bigTypeList();
		modelAndView.addObject("bigType", bigType);
		return modelAndView;
	}
	
	/**
	 * 商品类型新增或修改
	 */
	@RequestMapping(value="productType_edit",method=RequestMethod.POST)
	public ModelAndView productTypeEdit(ProductTypeModel productType,String bigTypeName){
		System.out.println("新增或修改");
		System.out.println(bigTypeName);
		if(productType.getId()>0){
			productType.setCreateDate(productTypeById(productType.getId()).getCreateDate());
		}
		productType.setBigType(bigTypeService.bigTypeByName(bigTypeName));
		productTypeService.productTypeEdit(productType);
		return productTypeList(null,null);
	}
	
	/**
	 * 删除商品
	 */
	@RequestMapping(value="productType_delete")
	public ModelAndView productTypeDelete(int id){
		System.out.println("去新增或修改");
		productTypeService.productTypeDelete(id);
		return productTypeList(null,null);
	}
	
}
