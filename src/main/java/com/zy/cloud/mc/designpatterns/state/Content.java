package com.zy.cloud.mc.designpatterns.state;

public class Content {

	private State state;

	public Content() {
		state = null;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}