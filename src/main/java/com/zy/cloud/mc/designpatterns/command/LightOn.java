package com.zy.cloud.mc.designpatterns.command;

public class LightOn implements Command {

	public Light light;

	@Override
	public void execute() {
		light.on();
	}

	public LightOn(Light light) {
		this.light = light;
	}

}