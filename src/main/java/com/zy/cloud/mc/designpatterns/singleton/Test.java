package com.zy.cloud.mc.designpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单例模式
 */
public class Test {

	private static final Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		logger.info("{}", SingletonEnum.INSTANCE.doSomething());
	}
}