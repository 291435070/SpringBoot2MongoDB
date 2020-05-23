package com.zy.cloud.mc.designpatterns.bridge;

public abstract class Bridge {

	private DataSource dataSource;

	public void driver() {
		this.dataSource.driver();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}