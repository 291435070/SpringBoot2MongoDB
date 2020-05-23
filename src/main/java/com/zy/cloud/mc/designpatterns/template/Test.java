package com.zy.cloud.mc.designpatterns.template;

/**
 * 模板模式
 */
public class Test {

	public static void main(String[] args) {
		Game game = new Cricket();
		game.play();

		System.out.println();

		game = new Football();
		game.play();

	}

}