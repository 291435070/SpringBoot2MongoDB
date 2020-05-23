package com.zy.cloud.mc.designpatterns.adapter.object;

public class Adapter implements Target {

	private Adaptee adaptee;

	public Adapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void doRead() {
		this.adaptee.doWrite();
	}

}