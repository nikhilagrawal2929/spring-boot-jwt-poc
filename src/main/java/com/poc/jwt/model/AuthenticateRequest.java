package com.poc.jwt.model;

import java.io.Serializable;

public class AuthenticateRequest implements Serializable {

	private static final long serialVersionUID = -2340918048807671446L;

	private String username;

	private String password;

	public AuthenticateRequest() {
		super();
	}

	public AuthenticateRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "AuthenticateRequest [username=" + username + ", password=" + password + "]";
	}

}