package com.zy.cloud.mc.designpatterns.composite;

/**
 * 组合模式
 */
public class Test {

	public static void main(String[] args) throws Exception {
		AbstractArea root = new Composite("广东省");

		root.add(new Leaf("广州市"));
		root.add(new Leaf("东莞市"));

		AbstractArea city = new Composite("深圳市");
		city.add(new Composite("罗湖区"));
		city.add(new Composite("南山区"));

		AbstractArea towns = new Composite("龙岗区");
		towns.add(new Leaf("六约"));
		towns.add(new Leaf("塘坑"));
		Leaf leaf = new Leaf("横岗");
		towns.add(leaf);
		// towns.remove(leaf);
		city.add(towns);

		root.add(city);

		root.print(1);

	}

}