package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Bankcard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String realName;//真实姓名
	private String IDnumber;//身份证号
	private String cardNumber;//银行卡号
	private String telephone;//手机号
	private String bankName;//银行
	private double balance;//余额
	
	@ManyToOne
	@JoinColumn(name="b_id")
	private User user;//关联的用户
	
	/*
	 * setter and getter
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIDnumber() {
		return IDnumber;
	}
	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
	public Bankcard(int id, String realName, String iDnumber, String cardNumber, String telephone, String bankName,
			double balance) {
		super();
		this.id = id;
		this.realName = realName;
		IDnumber = iDnumber;
		this.cardNumber = cardNumber;
		this.telephone = telephone;
		this.bankName = bankName;
		this.balance = balance;
	}
	public Bankcard(String realName, String iDnumber, String cardNumber, String telephone, String bankName,
			double balance) {
		super();
		this.realName = realName;
		IDnumber = iDnumber;
		this.cardNumber = cardNumber;
		this.telephone = telephone;
		this.bankName = bankName;
		this.balance = balance;
	}
	public Bankcard(int id) {
		super();
		this.id = id;
	}
	public Bankcard() {
		super();
	}
	

	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Bankcard [id=" + id + ", realName=" + realName + ", IDnumber=" + IDnumber + ", cardNumber=" + cardNumber
				+ ", telephone=" + telephone + ", bankName=" + bankName + ", balance=" + balance + ", user=" + user
				+ "]";
	}
	
}
