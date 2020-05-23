package com.zy.cloud.mc.designpatterns.mediator;

import java.time.LocalDateTime;

public class ChatRoom {

	public static void showMessage(User user, String message) {
		System.out.println(LocalDateTime.now() + " --- " + user.getName() + " --- " + message);
	}

}