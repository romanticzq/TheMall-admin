package com.project.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
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
//		try {
//			if(typeName!=null&&typeName!="")
//				typeName= new String(typeName.getBytes("ISO-8859-1") , "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		System.out.println("进入显示"+typeName);
		ModelAndView modelAndView=new ModelAndView("product/productList");
		List<ProductModel> productList=this.productService.productList(productName,typeName);
		modelAndView.addObject("num", productList.size());
		modelAndView.addObject("typeName", typeName);
		modelAndView.addObject("productName", productName);
		modelAndView.addObject("typeList", this.productTypeService.productTypeList(null));
		
		int size=productList.size();
		if(size>5){
			productList=productList.subList(0, 5);
		}else if(size>0){
			productList=productList.subList(0, size);
		}
		modelAndView.addObject("productList", productList);
		return modelAndView;
	}
	
	/**
	 * 分页插件查询商品列表
	 */
	@RequestMapping(value="product_list_page_plug", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String productListPagePlug(String productName,String typeName,int index){
		
		System.out.println("进入显示");
		List<ProductModel> productList=this.productService.productListPage(productName, typeName, index);
		JSONObject jo=new JSONObject();
		jo.put("productList", productList);
		System.out.println("111:"+productList);
		return JSON.toJSONString(jo, SerializerFeature.DisableCircularReferenceDetect);
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
	public ModelAndView productEdit(HttpServletRequest request,ProductModel product,MultipartFile file,int id,String productName,int number,double price,String description,String typeName){

		String url="D:/eclipse_worksplace/TheMall-admin/src/main/webapp/upload";
		// 如果目录不存在我就创建
		if (!new File(url).isDirectory()) {
			new File(url).mkdirs();
		}
		StringBuffer fileName = new StringBuffer(UUID.randomUUID().toString());
		fileName.append(file.getOriginalFilename());
		try {
			file.transferTo(new File(url + File.separator + fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String imgUrl="/upload"+File.separator+ fileName;
		if(id>0){
			product.setId(id);
		}
		
		product.setProductName(productName);
		product.setNumber(number);
		product.setPrice(price);
		product.setDescription(description);
		System.out.println(typeName);
		ProductTypeModel type=new ProductTypeModel();
		type.setTypeName(typeName);
		product.setType(type);
		product.setImgUrl(imgUrl);
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
