package com.zy.cloud.mc.designpatterns.factory.method;

/**
 * 工厂方法模式
 */
public class Test {

	public static void main(String[] args) {
		VehicleFactory factory = null;

		factory = new MetroFactory();
		factory.getVehicle().work();

		factory = new BusFactory();
		factory.getVehicle().work();

	}

}