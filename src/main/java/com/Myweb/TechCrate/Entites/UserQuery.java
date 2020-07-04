package com.Myweb.TechCrate.Entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="userquery")
public class UserQuery {
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Column(name="mobile")
	private String mobile;
	@Column(name="email")
	private String email;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="requestid")
	private int requestid;
	@Column(name="date")
	private String date;
	
	@Override
	public String toString() {
		return "UserQuery [mobile=" + mobile + ", email=" + email + ", requestId=" + requestid + ", date=" + date
				+ ", message=" + message + ", name=" + name + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="name")
	private String name;
}
