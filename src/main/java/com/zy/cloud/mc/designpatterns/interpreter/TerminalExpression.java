package com.zy.cloud.mc.designpatterns.interpreter;

public class TerminalExpression implements Expression {

	private String data;

	public TerminalExpression(String data) {
		this.data = data;
	}

	@Override
	public boolean interpret(String content) {
		return content.contains(data);
	}

}