package com.tap.model;

import java.sql.Timestamp;

public class User {
	
	private int UserId;
	private String UserName;
	private String Password;
	private String Email;
	private String Address;
	private String Role;
	private Timestamp CreatedDate;
	private Timestamp LastLoginDate;
	
	

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password, String email, String address, String role) {
		super();
		UserName = userName;
		Password = password;
		Email = email;
		Address = address;
		Role = role;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Timestamp getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
	}

	public Timestamp getLastLoginDate() {
		return LastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		LastLoginDate = lastLoginDate;
	}
 
	 
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", Email=" + Email
				+ ", Address=" + Address + ", Role=" + Role + ", CreatedDate=" + CreatedDate + ", LastLoginDate="
				+ LastLoginDate + "]";
	}
	
	

}
