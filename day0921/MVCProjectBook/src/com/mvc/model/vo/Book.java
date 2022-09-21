package com.mvc.model.vo;

public class Book {
	private String isbn, title, price, descript, regdate;

	public Book() {}

	public Book(String isbn, String title, String price, String descript, String regdate) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.descript = descript;
		this.regdate = regdate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
