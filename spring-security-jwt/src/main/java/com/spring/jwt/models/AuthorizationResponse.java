package com.spring.jwt.models;

import lombok.Getter;
import lombok.Setter;


public class AuthorizationResponse {

	private String jwt;

	
	public AuthorizationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	@Override
	public String toString() {
		return "AuthorizationResponse [jwt=" + jwt + "]";
	}
	
	
	
}
