package com.zy.cloud.mc.designpatterns.proxy.dynamic2;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class FilmHandle implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class<?> clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println(String.format("开始准备 : %s", LocalDateTime.now()));

		Instant start = Instant.now();
		proxy.invokeSuper(obj, args);
		long seconds = Duration.between(start, Instant.now()).getSeconds();

		System.out.println(String.format("已完成，总耗时 : %s", seconds));
		return null;
	}

}