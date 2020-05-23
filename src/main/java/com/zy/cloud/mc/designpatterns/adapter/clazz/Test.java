package com.zy.cloud.mc.designpatterns.adapter.clazz;

/**
 * 类的适配器模式
 */
public class Test {

	public static void main(String[] args) {
		Target target = new Adapter();
		target.doRead();
	}

}