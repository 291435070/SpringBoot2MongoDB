package com.zy.cloud.mc.designpatterns.builder;

public interface PersonBuilder {

	void buildHead();

	void buildBody();

	void buildFoot();

	Person build();

}