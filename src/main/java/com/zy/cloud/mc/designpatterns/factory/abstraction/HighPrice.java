package com.zy.cloud.mc.designpatterns.factory.abstraction;

public class HighPrice extends AbstractFactory {

	@Override
	public Mobile getMobile() {
		return new IPhone();
	}

	@Override
	public Computer getComputer() {
		return new Mac();
	}

}