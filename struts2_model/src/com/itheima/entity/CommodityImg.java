package com.itheima.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class CommodityImg implements Serializable 
{
	private int id;
	private String uuidname;
	private String realname;
	private String savepath;
	private String ip;
	private Timestamp uploadtime;
	private Commodity commodity;
	
	@ManyToOne(targetEntity=Commodity.class)
	@JoinColumn(name="commodity_id",nullable=false)
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	@Id @Column(name="img_id")
	@GeneratedValue(generator="iid")
	@GenericGenerator(name="iid",strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUuidname() {
		return uuidname;
	}
	public void setUuidname(String uuidname) {
		this.uuidname = uuidname;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSavepath() {
		return savepath;
	}
	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Timestamp uploadtime) {
		this.uploadtime = uploadtime;
	}
	@Override
	public String toString() {
		return "CommodityImg [uuidname=" + uuidname + ", realname=" + realname + ", savepath=" + savepath + ", ip=" + ip
				+ ", uploadtime=" + uploadtime + "]";
	}
	
	
}
