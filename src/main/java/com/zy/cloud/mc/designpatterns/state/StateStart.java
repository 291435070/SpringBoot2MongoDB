package com.zy.cloud.mc.designpatterns.state;

public class StateStart implements State {

	@Override
	public void doAction(Content content) {
		System.out.println("Player is in start state");
		content.setState(this);
	}

	public String toString() {
		return "State Start []";
	}

}