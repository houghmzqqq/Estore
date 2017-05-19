package com.itheima.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_info")
public class User implements Serializable 
{
	private int id;
	private String username;
	private String password;
	private String email;
	private String isActivation;
	private String activationCode;
	private String role;

	@Id @Column(name="user_id")
	@GeneratedValue(generator="us_id")
	@GenericGenerator(name="us_id", strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIsActivation() {
		return isActivation;
	}
	public void setIsActivation(String isActivation) {
		this.isActivation = isActivation;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String username, String password, String email, String isActivation, String activationCode,
			String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.isActivation = isActivation;
		this.activationCode = activationCode;
		this.role = role;
	}
	public User() {
		super();
	}
	
	public String toString()
	{
		return "name:" + username + ",pass:" + password + ",email:" + email
				+ ",isActivation:" + isActivation + ",activationCode:" + activationCode
				+ ",role:" + role;
		
	}
}
