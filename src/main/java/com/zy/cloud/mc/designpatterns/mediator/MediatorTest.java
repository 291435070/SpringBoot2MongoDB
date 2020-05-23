package com.zy.cloud.mc.designpatterns.mediator;

/**
 * 中介者模式
 */
public class MediatorTest {

	public static void main(String[] args) {
		User u1 = new User("张三");
		User u2 = new User("鲁班七号");

		u1.sendMessage("你是谁...");
		u2.sendMessage("王者般的存在");
	}

}