package com.zy.cloud.mc.designpatterns.factory.simple;

public class ColorFactory {

	public Color type(String type) {
		if ("White".equalsIgnoreCase(type)) {
			return new White();
		} else if ("Black".equalsIgnoreCase(type)) {
			return new Black();
		} else {
			return null;
		}
	}

}