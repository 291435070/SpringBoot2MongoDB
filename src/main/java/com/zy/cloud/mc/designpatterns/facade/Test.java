package com.zy.cloud.mc.designpatterns.facade;

/**
 * 外观模式
 * @description:为子系统中的一组接口提供统一接口
 */
public class Test {

	public static void main(String[] args) throws Exception {
		Facade facade = new Facade();
		facade.login();
		facade.logout();
	}

}