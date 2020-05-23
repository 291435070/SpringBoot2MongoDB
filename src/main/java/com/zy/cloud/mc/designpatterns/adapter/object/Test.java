package com.zy.cloud.mc.designpatterns.adapter.object;

/**
 * 对象的适配器模式
 * @description:将一个类的接口变换成客户端所期待的另一种接口，使原本接口不匹配而无法一起工作的两个类能够在一起工作
 */
public class Test {

	public static void main(String[] args) {
		Target target = new Adapter(new Adaptee());
		target.doRead();
	}

}