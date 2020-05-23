package com.zy.cloud.mc.designpatterns.iterator;

/**
 * 迭代器模式
 */
public class IteratorTest {

	public static void main(String[] args) {
		NameRepository names = new NameRepository();

		for (MyIterator it = names.getMyIterator(); it.hasNext();) {
			String name = (String) it.next();
			System.out.println("Name : " + name);
		}
	}

}