package com.zy.cloud.mc.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observerable {

	private List<Observer> list;
	private String message;

	public WechatServer() {
		list = new ArrayList<>();
	}

	@Override
	public void enroll(Observer ob) {
		list.add(ob);
	}

	@Override
	public void remove(Observer ob) {
		if (list.size() > 0) {
			list.remove(ob);
		}
	}

	@Override
	public void notice() {
		for (Observer observer : list) {
			observer.update(message);
		}
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("微信服务更新消息 : " + message);
		this.notice();
	}

}