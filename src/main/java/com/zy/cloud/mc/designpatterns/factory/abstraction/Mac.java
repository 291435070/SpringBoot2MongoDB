package com.zy.cloud.mc.designpatterns.factory.abstraction;

public class Mac implements Computer {

	@Override
	public void os() {
		System.out.println("苹果操作系统");
	}

}