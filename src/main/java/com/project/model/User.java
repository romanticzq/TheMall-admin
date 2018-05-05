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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;//用户id
	
	private String userName;//用户名
	private String nickname;//昵称
	private String password;//登录密码
	private String payPassword;//支付密码
	private String gender;//性别
	private String email;//电子邮箱
	private String status="正常";//用户状态,默认为正常
	private String realName;//真实姓名
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private Date birthday;//生日
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE)
	private Date createDate;//创建时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE)
	private Date editDate;//修改时间
	private String phone;//电话号码
	private double balance;//账户余额
	private String imageUrl;//头像
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Role role=new Role(); //用户所对应的角色
	
	/*
	 * 死循环，栈溢出
	 */
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	private Set<Address> addresses=new HashSet<>();//用户对应的收货地址

	/*
	 * setter and getter
	 */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

//	public Set<Address> getAddresses() {
//		return addresses;
//	}
//
//	public void setAddresses(Set<Address> addresses) {
//		this.addresses = addresses;
//	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	/*
	 * 构造方法
	 */

	public User(String userName, String nickname, String password, String payPassword, String gender, String email,
			String status, String realName, Date birthday, Date createDate, Date editDate, String phone, double balance,
			String imageUrl) {
		super();
		this.userName = userName;
		this.nickname = nickname;
		this.password = password;
		this.payPassword = payPassword;
		this.gender = gender;
		this.email = email;
		this.status = status;
		this.realName = realName;
		this.birthday = birthday;
		this.createDate = createDate;
		this.editDate = editDate;
		this.phone = phone;
		this.balance = balance;
		this.imageUrl = imageUrl;
	}

	public User(int userId, String userName, String nickname, String password, String payPassword, String gender,
			String email, String status, String realName, Date birthday, Date createDate, Date editDate, String phone,
			double balance, String imageUrl) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickname = nickname;
		this.password = password;
		this.payPassword = payPassword;
		this.gender = gender;
		this.email = email;
		this.status = status;
		this.realName = realName;
		this.birthday = birthday;
		this.createDate = createDate;
		this.editDate = editDate;
		this.phone = phone;
		this.balance = balance;
		this.imageUrl = imageUrl;
	}

	public User(int userId) {
		super();
		this.userId = userId;
	}

	public User() {
		super();
	}

	
	/*
	 * toString
	 */

//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userName=" + userName + ", nickname=" + nickname + ", password=" + password
//				+ ", payPassword=" + payPassword + ", gender=" + gender + ", email=" + email + ", status=" + status
//				+ ", realName=" + realName + ", birthday=" + birthday + ", createDate=" + createDate + ", editDate="
//				+ editDate + ", phone=" + phone + ", balance=" + balance + ", imageUrl=" + imageUrl + ", role=" + role
//				+ ", addresses=" + addresses + "]";
//	}

}
