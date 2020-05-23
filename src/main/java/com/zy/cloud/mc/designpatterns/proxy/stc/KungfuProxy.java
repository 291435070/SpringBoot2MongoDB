package com.zy.cloud.mc.designpatterns.proxy.stc;

public class KungfuProxy extends Cinema {

	@Override
	public void doPlay() {
		System.out.println("功夫片已开始准备...");
		super.doPlay();
		System.out.println("功夫片放映完成。");
	}

}