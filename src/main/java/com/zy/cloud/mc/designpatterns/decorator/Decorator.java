package com.zy.cloud.mc.designpatterns.decorator;

/**
 * 装饰操作
 */
public class Decorator implements Basic {

	private Basic basic;

	public Decorator(Basic basic) {
		this.basic = basic;
	}

	@Override
	public void operation() {
		basic.operation();
	}

}