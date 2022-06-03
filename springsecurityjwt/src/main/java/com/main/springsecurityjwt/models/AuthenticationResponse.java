package com.main.springsecurityjwt.models;

public class AuthenticationResponse {

	private final String jwt;
	private String role;

	public String getJwt() {
		return jwt;
	}
	
	public String getRole() {
		return role;
	}

	public AuthenticationResponse(String jwt,String role) {
		this.jwt = jwt;
		this.role=role;
	}
	
}
