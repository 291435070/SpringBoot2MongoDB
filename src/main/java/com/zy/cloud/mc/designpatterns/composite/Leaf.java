package com.zy.cloud.mc.designpatterns.composite;

public class Leaf extends AbstractArea {

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void print(int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print('-');
		}
		System.out.println("L : " + name);
	}

}