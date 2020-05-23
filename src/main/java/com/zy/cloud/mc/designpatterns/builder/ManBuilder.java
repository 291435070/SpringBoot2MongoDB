package com.zy.cloud.mc.designpatterns.builder;

public class ManBuilder implements PersonBuilder {

	Person person;

	public ManBuilder() {
		person = new Person();
	}

	@Override
	public void buildHead() {
		person.setHead("1.构建头部");
	}

	@Override
	public void buildBody() {
		person.setBody("2.构建身体");
	}

	@Override
	public void buildFoot() {
		person.setFoot("3.构建脚部");
	}

	@Override
	public Person build() {
		return person;
	}

}