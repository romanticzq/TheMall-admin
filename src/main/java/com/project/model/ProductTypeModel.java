package com.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="tb_productType")
public class ProductTypeModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="type_id")
	private int id;
	private String typeName;
	private String createDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private String editDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	/*
	 * setter and getter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	public ProductTypeModel(int id, String typeName, String createDate, String editDate) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public ProductTypeModel(String typeName, String createDate, String editDate) {
		super();
		this.typeName = typeName;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public ProductTypeModel(int id) {
		super();
		this.id = id;
	}
	public ProductTypeModel() {
		super();
	}
	
	/*
	 * toString方法
	 */
	@Override
	public String toString() {
		return "ProductTypeModel [id=" + id + ", typeName=" + typeName + ", createDate=" + createDate + ", editDate="
				+ editDate + "]";
	}
	
}
