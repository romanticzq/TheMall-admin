package com.project.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String logistics;//物流方式
	private String mailingFee;//包邮
	private String orderStatus;//订单状态
	private double total_fee;//总金额
	private String message;//买方留言
	private int count;//商品数量
	private String deliveryNo;//商品快递单号
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE)
	private Date createDate;//下单时间
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="e_id1")//快递信息
	private Express express;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="u_id1")
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="a_id1")
	private Address address;//收货地址
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="c_id1")
	private Commodity commodity;//商品信息
	
	/*
	 * setter and getter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogistics() {
		return logistics;
	}
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	public String getMailingFee() {
		return mailingFee;
	}
	public void setMailingFee(String mailingFee) {
		this.mailingFee = mailingFee;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	
	public Express getExpress() {
		return express;
	}
	public void setExpress(Express express) {
		this.express = express;
	}
	public String getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/*
	 * 构造方法
	 */
	public Orders(String logistics, String mailingFee, String orderStatus, double total_fee, String message, int count,
			String deliveryNo, Date createDate) {
		super();
		this.logistics = logistics;
		this.mailingFee = mailingFee;
		this.orderStatus = orderStatus;
		this.total_fee = total_fee;
		this.message = message;
		this.count = count;
		this.deliveryNo = deliveryNo;
		this.createDate = createDate;
	}
	public Orders(int id, String logistics, String mailingFee, String orderStatus, double total_fee, String message,
			int count, String deliveryNo, Date createDate) {
		super();
		this.id = id;
		this.logistics = logistics;
		this.mailingFee = mailingFee;
		this.orderStatus = orderStatus;
		this.total_fee = total_fee;
		this.message = message;
		this.count = count;
		this.deliveryNo = deliveryNo;
		this.createDate = createDate;
	}
	public Orders(int id) {
		super();
		this.id = id;
	}
	public Orders() {
		super();
	}
	
	
	/*
	 * toString方法
	 */
	@Override
	public String toString() {
		return "Orders [id=" + id + ", logistics=" + logistics + ", mailingFee=" + mailingFee + ", orderStatus="
				+ orderStatus + ", total_fee=" + total_fee + ", message=" + message + ", count=" + count
				+ ", createDate=" + createDate + ", express=" + express + ", user=" + user + ", address=" + address
				+ ", commodity=" + commodity + "]";
	}
	
}
