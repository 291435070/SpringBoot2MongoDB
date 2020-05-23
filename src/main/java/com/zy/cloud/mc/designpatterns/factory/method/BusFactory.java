package com.zy.cloud.mc.designpatterns.factory.method;

public class BusFactory implements VehicleFactory {

	@Override
	public Vehicle getVehicle() {
		return new Bus();
	}

}