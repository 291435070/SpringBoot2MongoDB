package com.zy.cloud.mc.designpatterns.bridge;

/**
 * 桥接模式:将抽象的事物与具体实现分开，使其都可以独立变化
 */
public class Test {

	public static void main(String[] args) {
		Bridge bridge = new MyBridge();

		DataSource mysql = new MySQLSource();
		bridge.setDataSource(mysql);
		bridge.driver();

		DataSource oracle = new OracleSource();
		bridge.setDataSource(oracle);
		bridge.driver();

	}

}