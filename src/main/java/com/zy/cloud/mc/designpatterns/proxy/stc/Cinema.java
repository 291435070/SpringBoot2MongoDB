package com.zy.cloud.mc.designpatterns.proxy.stc;

public class Cinema implements Film {

	@Override
	public void doPlay() {
		System.out.println("正在播放电影");
	}

}