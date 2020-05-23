package com.zy.cloud.mc.designpatterns.proxy.dynamic1;

public class WellFilm implements Film {

	@Override
	public void doPlay() {
		System.out.println("正在播放优秀的电影");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}