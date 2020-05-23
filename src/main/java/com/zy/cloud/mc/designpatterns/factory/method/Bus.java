package com.zy.cloud.mc.designpatterns.factory.method;

public class Bus implements Vehicle {

	@Override
	public void work() {
		System.out.println("坐公交车去上班");
	}

}