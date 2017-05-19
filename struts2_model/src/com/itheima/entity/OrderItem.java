package com.itheima.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class OrderItem implements Serializable 
{
	private int id;
	private int count_of_commodity;
	private TheOrder order;
	private Commodity commodity;
	
	@Id @Column(name="orderItem_id")
	@GeneratedValue(generator="orit_id")
	@GenericGenerator(name="orit_id", strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount_of_commodity() {
		return count_of_commodity;
	}
	public void setCount_of_commodity(int count_of_commodity) {
		this.count_of_commodity = count_of_commodity;
	}
	@ManyToOne(targetEntity=TheOrder.class)
	@JoinColumn(name="order_id",nullable=false)
	public TheOrder getOrder() {
		return order;
	}
	public void setOrder(TheOrder order) {
		this.order = order;
	}
	@ManyToOne(targetEntity=Commodity.class)
	@JoinColumn(name="commodity_id",nullable=false)
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public OrderItem(int id, int count_of_commodity, TheOrder order, Commodity commodity) {
		super();
		this.id = id;
		this.count_of_commodity = count_of_commodity;
		this.order = order;
		this.commodity = commodity;
	}
	public OrderItem(int count_of_commodity, TheOrder order, Commodity commodity) {
		super();
		this.count_of_commodity = count_of_commodity;
		this.order = order;
		this.commodity = commodity;
	}
	public OrderItem() {
		super();
	}
	
}
