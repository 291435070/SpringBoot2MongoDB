package com.zy.cloud.mc.designpatterns.factory.method;

public class Metro implements Vehicle {

	@Override
	public void work() {
		System.out.println("坐地铁去上班");
	}

}