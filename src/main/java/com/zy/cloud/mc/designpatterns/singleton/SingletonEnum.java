package com.zy.cloud.mc.designpatterns.singleton;

import java.util.concurrent.ThreadLocalRandom;

public enum SingletonEnum {

	INSTANCE;

	public long doSomething() {
		return ThreadLocalRandom.current().nextLong(1000, 10000);
	}

}