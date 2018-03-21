package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_admin")
public class AdminModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String password;
	
	/*
	 * getter and setter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*
	 * 构造方法
	 */
	public AdminModel(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	public AdminModel(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public AdminModel(int id) {
		super();
		this.id = id;
	}
	public AdminModel() {
		super();
	}
	
	/*
	 * toString方法
	 */
	@Override
	public String toString() {
		return "AdminModel [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
