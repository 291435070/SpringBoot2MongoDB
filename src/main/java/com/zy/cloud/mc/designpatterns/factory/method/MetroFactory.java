package com.zy.cloud.mc.designpatterns.factory.method;

public class MetroFactory implements VehicleFactory {

	@Override
	public Vehicle getVehicle() {
		return new Metro();
	}

}