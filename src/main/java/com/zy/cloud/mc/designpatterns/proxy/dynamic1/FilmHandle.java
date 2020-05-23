package com.zy.cloud.mc.designpatterns.proxy.dynamic1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class FilmHandle implements InvocationHandler {

	private Object target;

	public FilmHandle(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(String.format("开始准备 : %s", LocalDateTime.now()));

		Instant start = Instant.now();
		method.invoke(target, args);
		long seconds = Duration.between(start, Instant.now()).getSeconds();

		System.out.println(String.format("已完成，总耗时 : %s", seconds));
		return null;
	}

}