package com.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_bigType")
public class BigType {

	@Id                                                           
	@GeneratedValue(strategy=GenerationType.IDENTITY)             
	private int id;//id                                           
	private String typeName;//类型名称                                
	private String imgUrl;//图片路径                                  
	private String createDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private String editDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());                            
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)                           
	private Set<ProductTypeModel> smallTypes=new HashSet<ProductTypeModel>();
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
	public Set<ProductTypeModel> getSmallTypes() {
		return smallTypes;
	}
	public void setSmallTypes(Set<ProductTypeModel> smallTypes) {
		this.smallTypes = smallTypes;
	}
	public BigType(int id, String typeName, String imgUrl, String createDate, String editDate) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.imgUrl = imgUrl;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public BigType(String typeName, String imgUrl, String createDate, String editDate) {
		super();
		this.typeName = typeName;
		this.imgUrl = imgUrl;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public BigType(int id) {
		super();
		this.id = id;
	}
	public BigType() {
		super();
	}
	@Override
	public String toString() {
		return "BigType [id=" + id + ", typeName=" + typeName + ", imgUrl=" + imgUrl + ", createDate=" + createDate
				+ ", editDate=" + editDate + ", smallTypes=" + smallTypes + "]";
	}  
	
	
}
