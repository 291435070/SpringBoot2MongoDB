package com.zy.cloud.mc.utils.objectpool.t1;

public class ClientConnection {

	private boolean active;
	private String url;

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}