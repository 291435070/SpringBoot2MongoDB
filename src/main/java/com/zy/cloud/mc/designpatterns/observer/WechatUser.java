package com.zy.cloud.mc.designpatterns.observer;

public class WechatUser implements Observer {

	private String name;
	private String message;

	public WechatUser(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		this.message = message;
		this.read();
	}

	public void read() {
		System.out.println("WechatUser [name=" + name + ", message=" + message + "]");
	}

}