package com.zy.cloud.mc.designpatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

	private static final Map<String, Shape> map = new HashMap<>();

	public static Shape getCircle(String color) {
		Circle circle = (Circle) map.get(color);
		if (null == circle) {
			circle = new Circle(color);
			map.put(color, circle);
			System.err.println(String.format("Creating circle of color %s", color));
		}
		return circle;
	}

}