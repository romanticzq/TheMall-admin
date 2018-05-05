package com.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String receiverName;
	private String telephone;
	private String address;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="u_id")
	private User user;

	/*
	 * setter and getter
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * 构造方法
	 */
	public Address(int id, String receiverName, String telephone, String address) {
		super();
		this.id = id;
		this.receiverName = receiverName;
		this.telephone = telephone;
		this.address = address;
	}

	public Address(String receiverName, String telephone, String address) {
		super();
		this.receiverName = receiverName;
		this.telephone = telephone;
		this.address = address;
	}

	public Address(int id) {
		super();
		this.id = id;
	}

	public Address() {
		super();
	}

	/*
	 * toString
	 */
//	@Override
//	public String toString() {
//		return "Address [id=" + id + ", receiverName=" + receiverName + ", telephone=" + telephone + ", address="
//				+ address + ", user=" + user + "]";
//	}
	
}
