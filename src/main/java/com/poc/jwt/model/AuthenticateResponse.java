package com.poc.jwt.model;

import java.io.Serializable;

public class AuthenticateResponse implements Serializable {

	private static final long serialVersionUID = 690919680015167993L;
	private String jwttoken;
	private String username;

	public AuthenticateResponse() {
		super();
	}

	public AuthenticateResponse(String jwttoken, String username) {
		super();
		this.jwttoken = jwttoken;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	@Override
	public String toString() {
		return "AuthenticateResponse [jwttoken=" + jwttoken + ", username=" + username + "]";
	}

}