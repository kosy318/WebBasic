package com.mvc.model.vo;

public class User {
	private String id, pass;

	public User() {}
	public User(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
