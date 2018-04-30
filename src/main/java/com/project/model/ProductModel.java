package com.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_product")
public class ProductModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	private String productName;
	private int number;
	private double price;
	private String description;
	private String imgUrl;
	private String createDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private String editDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="type_id")
	private ProductTypeModel type;
	
	public ProductTypeModel getType() {
		return type;
	}
	public void setType(ProductTypeModel type) {
		this.type = type;
	}
	
	/*
	 * setter and getter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	
	/*
	 * 构造方法
	 */
	public ProductModel(int id, String productName, int number, double price, String description, String imgUrl,
			String createDate, String editDate) {
		super();
		this.id = id;
		this.productName = productName;
		this.number = number;
		this.price = price;
		this.description = description;
		this.imgUrl = imgUrl;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public ProductModel(String productName, int number, double price, String description, String imgUrl,
			String createDate, String editDate) {
		super();
		this.productName = productName;
		this.number = number;
		this.price = price;
		this.description = description;
		this.imgUrl = imgUrl;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public ProductModel(int id) {
		super();
		this.id = id;
	}
	public ProductModel() {
		super();
	}
	
	/*
	 * toString方法
	 */
	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", productName=" + productName + ", number=" + number + ", price=" + price
				+ ", description=" + description + ", imgUrl=" + imgUrl + ", createDate=" + createDate + ", editDate="
				+ editDate + "]";
	}
	
}
