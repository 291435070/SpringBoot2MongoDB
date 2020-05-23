package com.zy.cloud.mc.designpatterns.proxy.stc;

public class ComedyProxy implements Film {

	private Cinema cinema;

	public ComedyProxy(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public void doPlay() {
		System.out.println("喜剧片已开始准备...");
		cinema.doPlay();
		System.out.println("喜剧片放映完成。");
	}

}