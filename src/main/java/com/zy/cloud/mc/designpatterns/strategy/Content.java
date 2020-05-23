package com.zy.cloud.mc.designpatterns.strategy;

public class Content {

	private Strategy strategy;

	public Content(Strategy strategy) {
		this.strategy = strategy;
	}

	public int execute(int num1, int num2) {
		return strategy.operation(num1, num2);
	}

}