package com.zy.cloud.mc.designpatterns.command;

public class Invoker {

	Command onCommand;
	Command offCommand;

	public Invoker() {
	}

	public void setInvoker(Command onCommand, Command offCommand) {
		this.onCommand = onCommand;
		this.offCommand = offCommand;
	}

	public void openLight() {
		onCommand.execute();
	}

	public void closeLight() {
		offCommand.execute();
	}

}