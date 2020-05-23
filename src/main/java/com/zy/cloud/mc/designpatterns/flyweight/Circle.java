package com.zy.cloud.mc.designpatterns.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Circle implements Shape {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private String color;
	private int x, y, radius;

	public Circle(String color) {
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		logger.info("Circle : color={},x={},y={},radius={}", color, x, y, radius);
	}

}