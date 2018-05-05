package com.project.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class BigType {

	@Id                                                           
	@GeneratedValue(strategy=GenerationType.IDENTITY)             
	private int id;//id                                           
	private String typeName;//类型名称                                
	private String imgUrl;//图片路径                                  
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE)
	private Date createDate;//创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE)
	private Date editDate;//修改时间              
	
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)                           
//	private Set<SmallType> smallTypes=new HashSet<SmallType>();
	
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
//	public Set<SmallType> getSmallTypes() {
//		return smallTypes;
//	}
//	public void setSmallTypes(Set<SmallType> smallTypes) {
//		this.smallTypes = smallTypes;
//	}
	
	/*
	 * 构造方法
	 */
	public BigType(int id, String typeName, String imgUrl, Date createDate, Date editDate) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.imgUrl = imgUrl;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public BigType(String typeName, String imgUrl, Date createDate, Date editDate) {
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
	
	/*
	 * toString方法
	 */
	@Override
	public String toString() {
		return "BigType [id=" + id + ", typeName=" + typeName + ", imgUrl=" + imgUrl + ", createDate=" + createDate
				+ ", editDate=" + editDate + "]";
	}
	
}
