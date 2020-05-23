package com.zy.cloud.mc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageReceiver {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void receive(String message) {
		logger.info("receive : {}", message);
	}

}