package com.projectmanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SessionEntry {
	@Id
	private String sessionId;

	private String userName;

	public SessionEntry(String sessionId, String userName) {
		super();
		this.sessionId = sessionId;
		this.userName = userName;
	}

	public SessionEntry() {

	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
