package com.zy.cloud.mc.designpatterns.visitor;

public interface ComputerPart {

	void accept(ComputerPartVisitor visitor);

}