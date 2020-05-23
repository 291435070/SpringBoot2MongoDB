package com.zy.cloud.mc.designpatterns.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 原型模式
 */
public class Test {

	private static final Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) throws Exception {
		Book book = new Book("红楼梦", "66.9", "曹雪芹");
		logger.info("{} : {}", book, JSON.toJSON(book));

		Book clone = (Book) book.clone();
		clone.setPrice("88.6");
		logger.info("{} : {}", clone, JSON.toJSON(clone));

	}

}