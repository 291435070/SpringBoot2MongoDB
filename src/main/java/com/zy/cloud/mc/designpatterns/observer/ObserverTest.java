package com.zy.cloud.mc.designpatterns.observer;

/**
 * 观察者模式
 */
public class ObserverTest {

	public static void main(String[] args) {
		WechatServer server = new WechatServer();

		Observer user1 = new WechatUser("狄仁杰");
		Observer user2 = new WechatUser("赵子龙");
		Observer user3 = new WechatUser("诸葛亮");

		server.enroll(user1);
		server.enroll(user2);
		server.enroll(user3);
		server.setMessage("PHP是世界上最好用的语言");

		System.out.println("--------------------------------");
		server.remove(user2);
		server.setMessage("JAVA是世界上最好用的语言");

	}

}