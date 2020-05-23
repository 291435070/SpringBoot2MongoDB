package com.zy.cloud.mc.designpatterns.bridge;

public class OracleSource implements DataSource {

	@Override
	public void driver() {
		System.out.println("Oracle数据源");
	}

}