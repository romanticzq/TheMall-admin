package com.project.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class SmallType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String typeName;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE)
	private Date createDate;//创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE)
	private Date editDate;//修改时间
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="st_id")
	private Set<Commodity> commodities=new HashSet<Commodity>();//所涉及的商品
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="big_id")
	private BigType bigType;//所属大类
	
	
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
	public Set<Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(Set<Commodity> commodities) {
		this.commodities = commodities;
	}
	public BigType getBigType() {
		return bigType;
	}
	public void setBigType(BigType bigType) {
		this.bigType = bigType;
	}
	
	/*
	 * 构造方法
	 */
	public SmallType(int id, String typeName, Date createDate, Date editDate) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public SmallType(String typeName, Date createDate, Date editDate) {
		super();
		this.typeName = typeName;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public SmallType(int id) {
		super();
		this.id = id;
	}
	public SmallType() {
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
