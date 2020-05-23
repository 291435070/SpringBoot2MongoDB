package com.zy.cloud.mc.designpatterns.composite;

public abstract class AbstractArea {

	protected String name;

	public AbstractArea(String name) {
		this.name = name;
	}

	public void add(AbstractArea area) throws Exception {
		throw new Exception("此操作不能创建");
	}

	public void remove(AbstractArea area) throws Exception {
		throw new Exception("此操作不能删除");
	}

	public abstract void print(int depth);

}