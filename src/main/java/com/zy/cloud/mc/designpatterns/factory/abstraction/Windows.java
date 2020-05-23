package com.zy.cloud.mc.designpatterns.factory.abstraction;

public class Windows implements Computer {

	@Override
	public void os() {
		System.out.println("微软视窗操作系统");
	}

}