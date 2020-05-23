package com.zy.cloud.mc.designpatterns.adapter.clazz;

public class Adapter extends Adaptee implements Target {

	@Override
	public void doRead() {
		this.doWrite();
	}

}