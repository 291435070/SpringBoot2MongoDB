package com.zy.cloud.mc.designpatterns.bridge;

public class MySQLSource implements DataSource {

	@Override
	public void driver() {
		System.out.println("MySQL数据源");
	}

}