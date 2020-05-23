package com.zy.cloud.mc.designpatterns.chain;

public abstract class Handler {

	public Handler handler;

	public abstract String handlerReq(String user, int days);

	public Handler getNextHandler() {
		return handler;
	}

	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}

}