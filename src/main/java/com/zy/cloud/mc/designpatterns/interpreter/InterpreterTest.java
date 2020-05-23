package com.zy.cloud.mc.designpatterns.interpreter;

/**
 * 解释器模式
 */
public class InterpreterTest {

	public static void main(String[] args) {
		Expression male = getMaleExpression();
		Expression madam = getMadamExpression();

		System.out.println("John is male? " + male.interpret("John"));
		System.out.println("Julie is a married women? " + madam.interpret("Married Julie"));
	}

	public static Expression getMaleExpression() {
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}

	public static Expression getMadamExpression() {
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}

}