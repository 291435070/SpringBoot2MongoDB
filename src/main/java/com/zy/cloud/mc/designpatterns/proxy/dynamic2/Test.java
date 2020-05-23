package com.zy.cloud.mc.designpatterns.proxy.dynamic2;

/**
 * cglib动态代理
 */
public class Test {

	public static void main(String[] args) {
		FilmHandle handle = new FilmHandle();
		WellFilm wellFilm = (WellFilm) handle.getProxy(WellFilm.class);
		wellFilm.doPlay();
	}

}