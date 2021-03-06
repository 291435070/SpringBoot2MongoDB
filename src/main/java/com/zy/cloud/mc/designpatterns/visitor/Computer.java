package com.zy.cloud.mc.designpatterns.visitor;

public class Computer implements ComputerPart {

	ComputerPart[] parts;

	public Computer() {
		parts = new ComputerPart[] { new Keyboard(), new Monitor(), new Mouse() };
	}

	@Override
	public void accept(ComputerPartVisitor visitor) {
		for (int i = 0; i < parts.length; i++) {
			parts[i].accept(visitor);
		}

		visitor.visit(this);
	}

}