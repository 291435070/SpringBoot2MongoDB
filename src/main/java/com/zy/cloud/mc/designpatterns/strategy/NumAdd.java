package com.zy.cloud.mc.designpatterns.strategy;

public class NumAdd implements Strategy {

	@Override
	public int operation(int num1, int num2) {
		return num1 + num2;
	}

}