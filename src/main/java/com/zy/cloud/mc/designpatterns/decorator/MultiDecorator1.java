package com.zy.cloud.mc.designpatterns.decorator;

public class MultiDecorator1 extends Decorator {

	public MultiDecorator1(Basic basic) {
		super(basic);
	}

	@Override
	public void operation() {
		super.operation();
		this.modify();
	}

	public void modify() {
		System.out.println("添加操作 : modify");
	}

}