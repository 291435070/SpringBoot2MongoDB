package com.zy.cloud.mc.test;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OtherTest {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			threadPool.execute(() -> {
				System.out.println(LocalDateTime.now());
			});
		}
		threadPool.shutdown();
	}

}