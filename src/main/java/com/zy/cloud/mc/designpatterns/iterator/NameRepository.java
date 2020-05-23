package com.zy.cloud.mc.designpatterns.iterator;

public class NameRepository implements Container {

	public String names[] = { "赵子龙", "鲁班七号", "狄仁杰", "黄忠" };

	@Override
	public MyIterator getMyIterator() {
		return new NameIterator();
	}

	private class NameIterator implements MyIterator {
		int index = 0;

		@Override
		public boolean hasNext() {
			return index < names.length;
		}

		@Override
		public Object next() {
			if (this.hasNext()) {
				return names[index++];
			}
			return null;
		}
	}

}