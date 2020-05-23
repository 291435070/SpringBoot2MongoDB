package com.zy.cloud.mc.designpatterns.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Facade {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private WeChat weChat;
	private QQChat qqChat;

	public Facade() {
		weChat = new WeChat();
		qqChat = new QQChat();
	}

	public void login() throws Exception {
		logger.info("登陆社交软件......");
		Thread.sleep(500);
		weChat.login();
		Thread.sleep(500);
		qqChat.login();
		Thread.sleep(500);
		logger.info("社交软件登陆成功!");
	}

	public void logout() throws Exception {
		logger.info("关闭社交软件中...");
		Thread.sleep(500);
		weChat.logout();
		Thread.sleep(500);
		qqChat.logout();
		Thread.sleep(500);
		logger.info("社交软件关闭完成。");
	}

}