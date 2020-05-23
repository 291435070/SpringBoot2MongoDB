package com.zy.cloud.mc.designpatterns.memento;

public class Originator {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Memento saveStatus() {
		return new Memento(status);
	}

	public void getStatus(Memento memento) {
		status = memento.getStatus();
	}

}