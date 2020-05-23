package com.zy.cloud.mc.designpatterns.factory.abstraction;

public class LowPrice extends AbstractFactory {

	@Override
	public Mobile getMobile() {
		return new Android();
	}

	@Override
	public Computer getComputer() {
		return new Windows();
	}

}