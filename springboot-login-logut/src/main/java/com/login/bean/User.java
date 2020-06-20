package com.login.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	private String emailId;

	private String username;

	private String password;

	private String otp;

	public User() {

	}

	public User(String username, String password, String emailId, String otp) {
		super();
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.otp = otp;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getOtp() {
		return otp;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
