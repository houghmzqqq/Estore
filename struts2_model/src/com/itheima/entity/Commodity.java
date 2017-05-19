package com.itheima.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Commodity implements Serializable 
{
	private int id;
	private String name;
	private String type;
	private String stock;//¿â´æ
	private double unitPrice;
	private Set<CommodityImg> comImgs;
	
	@Id @Column(name="commodity_id")
	@GeneratedValue(generator="com_id")
	@GenericGenerator(name="com_id", strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@OneToMany(targetEntity=CommodityImg.class,mappedBy="commodity")
	public Set<CommodityImg> getComImgs() {
		return comImgs;
	}
	public void setComImgs(Set<CommodityImg> comImgs) {
		this.comImgs = comImgs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Commodity() {
		super();
	}
	public Commodity(String name, String type, String stock, double unitPrice) {
		super();
		this.name = name;
		this.type = type;
		this.stock = stock;
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Commodity [name=" + name + ", type=" + type + ", stock=" + stock + ", unitPrice=" + unitPrice + "]";
	}
	
	
}

