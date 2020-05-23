package com.zy.cloud.mc.designpatterns.chain;

/**
 * 责任链模式
 */
public class ChainTest {

	public static void main(String[] args) throws Exception {
		Handler h1 = new HeadTeacher();
		Handler h2 = new Department();
		Handler h3 = new Leader();

		h2.setNextHandler(h3);

		h1.handlerReq("张三", 5);
		Thread.sleep(500);
		System.out.println("--------------------------");
		h2.handlerReq("李四", 15);
		Thread.sleep(500);
		System.out.println("--------------------------");
		h2.handlerReq("王五", 30);
		Thread.sleep(500);
		h3.handlerReq("王五ss", 20);
	}

}