package com.project.model;

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
@Table(name="tb_op")
public class OrderProductModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="op_id")
	private int id;
	private int buyNumber;
	
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	private OrderModel order;
	
	public OrderModel getOrder() {
		return order;
	}
	public void setOrder(OrderModel order) {
		this.order = order;
	}
	
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="product_id")
	private ProductModel product;
	
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyNumber() {
		return buyNumber;
	}
	public void setBuyNumber(int buyNumber) {
		this.buyNumber = buyNumber;
	}
	public OrderProductModel(int id, int buyNumber) {
		super();
		this.id = id;
		this.buyNumber = buyNumber;
	}
	
	public OrderProductModel(int buyNumber) {
		super();
		this.buyNumber = buyNumber;
	}
	public OrderProductModel() {
		super();
	}
	@Override
	public String toString() {
		return "OrderProductModel [id=" + id + ", buyNumber=" + buyNumber + "]";
	}
	
	
}
