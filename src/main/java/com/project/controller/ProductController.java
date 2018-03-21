package com.project.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.ProductModel;
import com.project.model.ProductTypeModel;
import com.project.service.ProductService;
import com.project.service.ProductTypeService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	/**
	 * 查询商品
	 */
	@RequestMapping(value="product_list")
	public ModelAndView productList(String productName,String typeName){
		try {
			if(typeName!=null&&typeName!="")
				typeName= new String(typeName.getBytes("ISO-8859-1") , "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("进入显示"+typeName);
		ModelAndView modelAndView=new ModelAndView("product/productList");
		modelAndView.addObject("productList", this.productService.productList(productName,typeName));
		modelAndView.addObject("typeList", this.productTypeService.productTypeList(null));
		return modelAndView;
	}
	
	/**
	 * 根据id查询商品
	 */
	@RequestMapping(value="product_byid",method=RequestMethod.POST)
	public ProductModel productById(int id){
		System.out.println("根据id查询商品类型列表");
		return this.productService.productById(id);
	}
	
	/**
	 * 商品类型新增页或修改页
	 */
	@RequestMapping(value="product_to_edit",method=RequestMethod.POST)
	public ModelAndView productToEdit(ProductModel product){
		System.out.println("去新增或修改");
		ModelAndView modelAndView=new ModelAndView("product/productForm");
		if(product.getId()>0){
			product=productById(product.getId());
		}
		modelAndView.addObject("product", product);
		List<ProductTypeModel> type=productTypeService.productTypeList(null);
		modelAndView.addObject("type", type);
		return modelAndView;
	}
	
	/**
	 * 商品类型新增或修改
	 */
	@RequestMapping(value="product_edit",method=RequestMethod.POST)
	public ModelAndView productEdit(ProductModel product){
		System.out.println("新增或修改:");
		if(product.getId()>0){
			product.setCreateDate(productById(product.getId()).getCreateDate());
		}
		productService.productEdit(product);
		return productList(null,null);
	}
	
	/**
	 * 删除商品
	 */
	@RequestMapping(value="product_delete",method=RequestMethod.POST)
	public ModelAndView productTypeDelete(int id){
		System.out.println("去新增或修改");
		productService.productDelete(id);
		return productList(null,null);
	}
}
