package com.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table
public class Record {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso=ISO.DATE)
	private Date createtime;
	private String type;//消费类型
	private double totalFee;//金额
	private double banlance;//余额
	@ManyToOne
	@JoinColumn(name="u_id")
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(double totalFee) {
		this.totalFee = totalFee;
	}
	public double getBanlance() {
		return banlance;
	}
	public void setBanlance(double banlance) {
		this.banlance = banlance;
	}
	
	/*
	 * 构造方法
	 */
	public Record(int id, Date createtime, String type, double totalFee, double banlance) {
		super();
		this.id = id;
		this.createtime = createtime;
		this.type = type;
		this.totalFee = totalFee;
		this.banlance = banlance;
	}
	public Record(Date createtime, String type, double totalFee, double banlance) {
		super();
		this.createtime = createtime;
		this.type = type;
		this.totalFee = totalFee;
		this.banlance = banlance;
	}
	public Record(int id) {
		super();
		this.id = id;
	}
	public Record() {
		super();
	}
	
	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Record [id=" + id + ", createtime=" + createtime + ", type=" + type + ", totalFee=" + totalFee
				+ ", banlance=" + banlance + ", user=" + user + "]";
	}

}
