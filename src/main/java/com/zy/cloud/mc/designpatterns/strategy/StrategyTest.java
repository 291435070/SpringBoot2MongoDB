package com.zy.cloud.mc.designpatterns.strategy;

/**
 * 策略模式
 */
public class StrategyTest {

	public static void main(String[] args) {
		Content content = new Content(new NumAdd());
		System.out.println("10 + 5 = " + content.execute(10, 5));

		content = new Content(new NumSub());
		System.out.println("10 - 5 = " + content.execute(10, 5));

		content = new Content(new NumMul());
		System.out.println("10 * 5 = " + content.execute(10, 5));
	}

}