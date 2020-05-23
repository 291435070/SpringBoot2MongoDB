package com.zy.cloud.mc.designpatterns.proxy.dynamic1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class Test {

	public static void main(String[] args) {
		WellFilm wellFilm = new WellFilm();
		InvocationHandler handler = new FilmHandle(wellFilm);
		Class<?> clazz = wellFilm.getClass();
		Film f = (Film) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
		f.doPlay();
	}

}