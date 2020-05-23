package com.zy.cloud.mc.designpatterns.state;

/**
 * 状态模式
 */
public class StateTest {

	public static void main(String[] args) {
		Content content = new Content();

		StateStart start = new StateStart();
		start.doAction(content);
		System.out.println(content.getState().toString());

		StateStop stop = new StateStop();
		stop.doAction(content);
		System.out.println(content.getState().toString());
	}

}