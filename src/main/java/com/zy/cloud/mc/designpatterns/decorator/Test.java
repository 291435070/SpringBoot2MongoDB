package com.zy.cloud.mc.designpatterns.decorator;

/**
 * 装饰者模式
 * @description:动态地为对象附加额外的职责
 */
public class Test {

	public static void main(String[] args) throws Exception {
		Basic basic = new MultiBasic();
		basic.operation();

		Thread.sleep(1000);
		System.err.println("----------------------");
		Decorator decorator = new MultiDecorator(basic);
		decorator.operation();

		Thread.sleep(1000);
		System.err.println("----------------------");
		Decorator decorator1 = new MultiDecorator1(decorator);
		decorator1.operation();

	}

}