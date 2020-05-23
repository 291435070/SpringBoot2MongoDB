package com.zy.cloud.mc.designpatterns.visitor;

/**
 * 观察者模式
 */
public class VisitorTest {

	public static void main(String[] args) {
		ComputerPart computer = new Computer();
		computer.accept(new ComputerPartVisitorDisplay());
	}

}