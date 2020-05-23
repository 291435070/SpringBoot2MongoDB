package com.zy.cloud.mc.designpatterns.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeChat {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void login() {
		logger.info("登陆微信程序");
	}

	public void logout() {
		logger.info("退出微信");
	}

}