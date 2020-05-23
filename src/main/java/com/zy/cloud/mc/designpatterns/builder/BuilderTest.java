package com.zy.cloud.mc.designpatterns.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 创建者模式
 * @description:将一个复杂对象的构建与它的部件及组装方式分离，使得构件和组装方式可以独立应对变化
 */
public class BuilderTest {

	private static final Logger logger = LoggerFactory.getLogger(BuilderTest.class);

	public static void main(String[] args) {
		Director director = new Director();
		Person person = director.construct(new ManBuilder());
		logger.info("{}", person.getHead());
		logger.info("{}", person.getBody());
		logger.info("{}", person.getFoot());

	}

}