package com.zy.cloud.mc.designpatterns.factory.abstraction;

public class IPhone implements Mobile {

	@Override
	public void brand() {
		System.out.println("这是一部苹果手机");
	}

}