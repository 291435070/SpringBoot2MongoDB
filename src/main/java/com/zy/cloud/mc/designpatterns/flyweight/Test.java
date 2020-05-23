package com.zy.cloud.mc.designpatterns.flyweight;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 享元模式
 * @description:运用共享技术有效地支持大量细粒度的对象(对象池化)
 */
public class Test {

	private static final String[] COLOR = { "Red", "Green", "Blue", "Black", "White" };

	private static String getColor() {
		return COLOR[ThreadLocalRandom.current().nextInt(0, COLOR.length)];
	}

	private static int random() {
		return (int) (Math.random() * 100);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			Circle circle = (Circle) ShapeFactory.getCircle(getColor());
			circle.setX(random());
			circle.setY(random());
			circle.setRadius(100);
			circle.draw();
		}
	}

}