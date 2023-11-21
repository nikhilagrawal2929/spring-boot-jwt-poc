package com.poc.jwt.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String password = "admin123";
	    String encodedPassword = passwordEncoder.encode(password);
	    System.out.println(encodedPassword);
	}

}
