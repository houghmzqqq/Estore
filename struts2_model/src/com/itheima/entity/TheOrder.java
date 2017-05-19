package com.itheima.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;


@Entity//定义实体类
//@Table(name="theOrder")//定义生成的数据库表名称
public class TheOrder implements Serializable
{
	private int id;
	private Date down_time;
	private String address;
	private String isPay;
	private double amount_of_money;
	private User user;
	
	@Id @Column(name="order_id")//设置id，映射的数据库表ID名称为order_id
	//定义主键生成策略
	@GeneratedValue(generator="to_id")
	@GenericGenerator(name="to_id", strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDown_time() {
		return down_time;
	}
	public void setDown_time(Date down_time) {
		this.down_time = down_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	public double getAmount_of_money() {
		return amount_of_money;
	}
	public void setAmount_of_money(double amount_of_money) {
		this.amount_of_money = amount_of_money;
	}
	//定义多对一表单映射关系
	@ManyToOne(targetEntity=User.class)
	//映射外键咧，指定外键咧的列明为user_id，不允许为空
	@JoinColumn(name="user_id",nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public TheOrder(Date down_time, String address, String isPay, double amount_of_money, User user) {
		super();
		this.down_time = down_time;
		this.address = address;
		this.isPay = isPay;
		this.amount_of_money = amount_of_money;
		this.user = user;
	}
	public TheOrder() {
		super();
	}
	
}
