package com.zy.cloud.mc.designpatterns.chain;

public class Department extends Handler {

	@Override
	public String handlerReq(String user, int days) {
		if (days < 30) {
			System.out.println("②院系主任同意" + user + "同学的请假请求：" + days);
		} else {
			System.err.println("②院系主任无法处理" + user + "同学的请假请求");
		}

		if (null != getNextHandler()) {
			return getNextHandler().handlerReq(user, days);
		}

		return null;
	}

}