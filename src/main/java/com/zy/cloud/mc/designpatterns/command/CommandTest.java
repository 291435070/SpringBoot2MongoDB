package com.zy.cloud.mc.designpatterns.command;

/**
 * 命令模式
 */
public class CommandTest {

	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		Light light = new Light();

		Command onCommand = new LightOn(light);
		Command offCommand = new LightOff(light);

		invoker.setInvoker(onCommand, offCommand);
		invoker.openLight();
		invoker.closeLight();
	}

}