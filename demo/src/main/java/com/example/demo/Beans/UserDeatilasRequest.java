package com.example.demo.Beans;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDeatilasRequest {
	
	@NotNull(message="firstname shounld not be null:")
	private  String firstname;
	
	@NotNull(message="lastname shounld not be null:")
	@Email
	 private  String email;
	
	@NotNull(message="username shounld not be null:")
	 private  String userName;
	
	
	@NotNull(message="password shounld not be null:")
	@Size(min=8,max=16,message="password must be equal or greater than 8 characters:")
	private String pasword;
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String eamil) {
		this.email = eamil;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	 

}
