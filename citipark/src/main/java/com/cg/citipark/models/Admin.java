package com.cg.citipark.models;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

	@Id
	
	private String loginId;
	private String password;
	
	public Admin() {
	}

	public Admin(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [ loginId=" + loginId + ", password=" + password + "]";
	}
	
}
