package com.spring.jwt.models;

/**
 * Information will sent in Post Request
 * 
 * @author sakshamwason
 *
 */

public class AuthorizationRequest {

	/**
	 * must as same format as UserSevice is expecting , then only it will be mapped
	 */
	private String username;
	private String password;

	public AuthorizationRequest() {
		super();

	}

	public AuthorizationRequest(String username, String password) {
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

}
