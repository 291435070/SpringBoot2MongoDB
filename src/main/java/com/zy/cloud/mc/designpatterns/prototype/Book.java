package com.zy.cloud.mc.designpatterns.prototype;

public class Book implements Cloneable {

	private String name;
	private String price;
	private String author;

	public Book(String name, String price, String author) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getAuthor() {
		return author;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}