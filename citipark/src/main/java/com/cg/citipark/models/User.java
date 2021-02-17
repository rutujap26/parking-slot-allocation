package com.cg.citipark.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	/*
	 * userId of the user
	 */
	private long userid;
	/*
	 * firstName of the user
	 */
	@Column
	private String firstName;
	/*
	 * lastName of the user
	 */
	@Column
	private String lastName;
	/*
	 * email id of the user
	 */
	@Column(unique=true)
	private String email;
	/*
	 * mobile number of the user
	 */
	@Column
	private String mobile;
	/*
	 * password of the user
	 */
	@Column
	private String password;
	
	//getters and setters
	public long getUserId() {
		return userid;
	}
	public void setUserId(long userid) {
		this.userid=userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", password=" + password + "]";
	}
	//default constructor
	public User()
	{
        super();
	}
	//Parameterized constructor
	public User(long userid, String firstName, String lastName, String email, String mobile, String password) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}


}