package com.zy.cloud.mc.designpatterns.factory.abstraction;

/**
 * 抽象工厂模式
 */
public class Test {

	public static void main(String[] args) {
		AbstractFactory factory = null;

		System.out.println("###高价位产品###");
		factory = new HighPrice();
		factory.getMobile().brand();
		factory.getComputer().os();

		System.out.println("\n###普通价位产品###");
		factory = new LowPrice();
		factory.getMobile().brand();
		factory.getComputer().os();

	}
}