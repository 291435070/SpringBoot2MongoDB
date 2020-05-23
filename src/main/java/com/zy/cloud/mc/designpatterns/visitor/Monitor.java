package com.zy.cloud.mc.designpatterns.visitor;

public class Monitor implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor visitor) {
		visitor.visit(this);
	}

}