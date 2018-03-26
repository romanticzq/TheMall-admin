package com.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tb_order")
public class OrderModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int id;
	private int status;
	private double price;
	private String createDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private String editDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private String detail;
	private int number;
	private String message;
	
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private UserModel user;
	
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	@OneToMany
	private Set<OrderModel> OrderModels;
	
	public Set<OrderModel> getOrderModels() {
		return OrderModels;
	}
	public void setOrderModels(Set<OrderModel> orderModels) {
		OrderModels = orderModels;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	/*
	 * 构造方法
	 */
	public OrderModel(int id, int status, double price, String createDate, String editDate, String detail, int number,
			String message) {
		super();
		this.id = id;
		this.status = status;
		this.price = price;
		this.createDate = createDate;
		this.editDate = editDate;
		this.detail = detail;
		this.number = number;
		this.message = message;
	}
	public OrderModel(int status, double price, String createDate, String editDate, String detail, int number,
			String message) {
		super();
		this.status = status;
		this.price = price;
		this.createDate = createDate;
		this.editDate = editDate;
		this.detail = detail;
		this.number = number;
		this.message = message;
	}
	public OrderModel(int id) {
		super();
		this.id = id;
	}
	public OrderModel() {
		super();
	}
	
	
	/*
	 * toString方法
	 */
	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", status=" + status + ", price=" + price + ", createDate=" + createDate
				+ ", editDate=" + editDate + ", detail=" + detail + ", number=" + number + ", message=" + message + "]";
	}
}
