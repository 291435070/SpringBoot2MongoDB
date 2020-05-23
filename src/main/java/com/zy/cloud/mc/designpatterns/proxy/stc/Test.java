package com.zy.cloud.mc.designpatterns.proxy.stc;

/**
 * 静态代理模式
 */
public class Test {

	public static void main(String[] args) {
		ComedyProxy proxy = new ComedyProxy(new Cinema());
		proxy.doPlay();

		System.out.println();

		KungfuProxy proxy2 = new KungfuProxy();
		proxy2.doPlay();
		
	}

}