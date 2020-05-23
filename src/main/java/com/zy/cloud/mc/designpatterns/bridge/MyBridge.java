package com.zy.cloud.mc.designpatterns.bridge;

public class MyBridge extends Bridge {

	@Override
	public void driver() {
		getDataSource().driver();
	}

}