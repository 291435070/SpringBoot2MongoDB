package com.zy.cloud.mc.web.demo;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("session")
@RestController
public class SessionSharingController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${server.port}")
	private Integer port;

	@GetMapping("set")
	public Object set(HttpSession session) {
		logger.info("port : {}", port);
		session.setAttribute("USERNAME", "JAMES L.G.");
		return port;
	}

	@GetMapping("get")
	public Object get(HttpSession session) {
		Object attribute = session.getAttribute("USERNAME");
		logger.info("port : {} {}", port, attribute);
		return String.format("%s : %s", port, attribute);
	}

}