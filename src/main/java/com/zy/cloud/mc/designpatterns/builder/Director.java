package com.zy.cloud.mc.designpatterns.builder;

public class Director {

	public Person construct(PersonBuilder person) {
		person.buildHead();
		person.buildBody();
		person.buildFoot();
		return person.build();
	}

}