package com.zy.cloud.mc.designpatterns.decorator;

public class MultiDecorator extends Decorator {

	public MultiDecorator(Basic basic) {
		super(basic);
	}

	@Override
	public void operation() {
		super.operation();
		System.out.println("添加属性 : insert");
	}

}