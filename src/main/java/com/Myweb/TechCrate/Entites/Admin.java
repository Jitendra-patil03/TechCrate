package com.Myweb.TechCrate.Entites;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="id")
	private String id;
	@Column(name="authid")
	private String authid;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + ", Id=" + id + ", authId=" + authid + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		id = id;
	}
	public String getAuthid() {
		return authid;
	}
	public void setAuthid(String authId) {
		this.authid = authId;
	}
		
}
