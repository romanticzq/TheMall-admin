package com.project.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	private String userName;
	private String password;
	private String payPassword;
	private int sex;
	private String email;
	private int count;
	private int status;
	private String realName;
	private String personId;
	private String address;
	private String createDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	private String editDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
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
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public UserModel(int id, String userName, String password, String payPassword, int sex, String email, int count,
			int status, String realName, String personId, String address, String createDate, String editDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.payPassword = payPassword;
		this.sex = sex;
		this.email = email;
		this.count = count;
		this.status = status;
		this.realName = realName;
		this.personId = personId;
		this.address = address;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public UserModel(String userName, String password, String payPassword, int sex, String email, int count, int status,
			String realName, String personId, String address, String createDate, String editDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.payPassword = payPassword;
		this.sex = sex;
		this.email = email;
		this.count = count;
		this.status = status;
		this.realName = realName;
		this.personId = personId;
		this.address = address;
		this.createDate = createDate;
		this.editDate = editDate;
	}
	public UserModel(int id) {
		super();
		this.id = id;
	}
	public UserModel() {
		super();
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", userName=" + userName + ", password=" + password + ", payPassword="
				+ payPassword + ", sex=" + sex + ", email=" + email + ", count=" + count + ", status=" + status
				+ ", realName=" + realName + ", personId=" + personId + ", address=" + address + ", createDate="
				+ createDate + ", editDate=" + editDate + "]";
	}
	
	
}
