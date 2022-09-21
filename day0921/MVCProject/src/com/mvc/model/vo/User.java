package com.mvc.model.vo;
// board 테이블의 레코드 한 건의 정보를 저장하기 위한 클래스

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
