package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResetCode {
	@Id
	private String randomCode;
	
	private String userName;

	public ResetCode(String randomCode, String userName) {
		super();
		this.randomCode = randomCode;
		this.userName = userName;
	}

	public ResetCode() {
	
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
		
	}
