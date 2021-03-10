package com.mcexpress.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String email;
	private String password;
	
	public CredenciaisDTO() {
	}
	

	public String getLogin() {
		return login;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
