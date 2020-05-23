package com.zy.cloud.mc.designpatterns.command;

public class LightOff implements Command {

	public Light light;

	@Override
	public void execute() {
		light.off();
	}

	public LightOff(Light light) {
		this.light = light;
	}

}