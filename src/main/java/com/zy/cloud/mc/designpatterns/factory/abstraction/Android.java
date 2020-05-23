package com.zy.cloud.mc.designpatterns.factory.abstraction;

public class Android implements Mobile {

	@Override
	public void brand() {
		System.out.println("这是一部安卓手机");
	}

}