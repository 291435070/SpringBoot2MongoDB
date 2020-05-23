package com.zy.cloud.mc.designpatterns.chain;

public class Leader extends Handler {

	@Override
	public String handlerReq(String user, int days) {
		if (days >= 30) {
			System.out.println("③校级主任同意" + user + "同学的请假请求：" + days);
		} else if (null != getNextHandler()) {
			return getNextHandler().handlerReq(user, days);
		}

		return null;
	}

}