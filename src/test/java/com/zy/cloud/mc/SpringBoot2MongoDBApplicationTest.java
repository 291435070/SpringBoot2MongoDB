package com.zy.cloud.mc;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.zy.cloud.mc.model.News;
import com.zy.cloud.mc.service.NewsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot2MongoDBApplicationTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private Logger toFile1 = LoggerFactory.getLogger("toFile1");
	private Logger toFile2 = LoggerFactory.getLogger("toFile2");

	@Autowired
	private NewsService newsService;

	@Test
	public void logbackTest() {
		News news = newsService.select(null);
		logger.debug(JSON.toJSONString(news));
		logger.info(JSON.toJSONString(news));
		logger.warn(JSON.toJSONString(news));
		logger.error(JSON.toJSONString(news));

		toFile1.debug(JSON.toJSONString(news));
		toFile1.info(JSON.toJSONString(news));
		toFile1.warn(JSON.toJSONString(news));
		toFile1.error(JSON.toJSONString(news));

		toFile2.debug(JSON.toJSONString(news));
		toFile2.info(JSON.toJSONString(news));
		toFile2.warn(JSON.toJSONString(news));
		toFile2.error(JSON.toJSONString(news));
	}

	// 测试redis消息
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void redisMessageTest() {
		stringRedisTemplate.convertAndSend("topic", LocalDateTime.now().toString());
		stringRedisTemplate.convertAndSend("order", LocalDateTime.now().toString());
	}

}