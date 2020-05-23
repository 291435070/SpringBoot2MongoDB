package com.zy.cloud.mc.designpatterns.memento;

/**
 * 备忘录模式
 */
public class MementoTest {

	public static void main(String[] args) {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		originator.setStatus("Status #1");
		originator.setStatus("Status #2");
		careTaker.add(originator.saveStatus());
		originator.setStatus("Status #3");
		careTaker.add(originator.saveStatus());
		originator.setStatus("Status #4");

		System.out.println("Current Status : " + originator.getStatus());
		originator.getStatus(careTaker.get(0));
		System.out.println("First saved Status : " + originator.getStatus());
		originator.getStatus(careTaker.get(1));
		System.out.println("Second saved Status : " + originator.getStatus());
	}

}