package com.zy.cloud.mc.designpatterns.observer;

public interface Observerable {

	void enroll(Observer ob);

	void remove(Observer ob);

	void notice();

}