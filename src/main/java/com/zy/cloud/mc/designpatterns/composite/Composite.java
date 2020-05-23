package com.zy.cloud.mc.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends AbstractArea {

	private List<AbstractArea> areas = new ArrayList<>();

	public Composite(String name) {
		super(name);
	}

	@Override
	public void add(AbstractArea area) throws Exception {
		areas.add(area);
	}

	@Override
	public void remove(AbstractArea area) throws Exception {
		areas.remove(area);
	}

	@Override
	public void print(int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.print('-');
		}
		System.out.println("C : " + name);
		for (AbstractArea a : areas) {// 子节点遍历
			a.print(depth + 1);
		}
	}

}