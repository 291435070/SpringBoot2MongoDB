package com.zy.cloud.mc.designpatterns.factory.simple;

/**
 * 简单工厂模式
 */
public class Test {

	public static void main(String[] args) {
		ColorFactory factory = new ColorFactory();
		factory.type("white").process();
	}

}