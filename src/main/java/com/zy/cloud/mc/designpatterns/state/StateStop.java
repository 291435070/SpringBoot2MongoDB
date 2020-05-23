package com.zy.cloud.mc.designpatterns.state;

public class StateStop implements State {

	@Override
	public void doAction(Content content) {
		System.out.println("Player is in stop state");
		content.setState(this);
	}

	public String toString() {
		return "State Stop []";
	}

}