package com.zy.cloud.mc.spring;

import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;

import com.zy.cloud.mc.model.UserInfo;

public class ReadResource {

	private static final Logger logger = LoggerFactory.getLogger(ReadResource.class);

	public static void main(String[] args) throws Exception {
		// 方法1
		Resource resource = new ClassPathResource("email.properties");
		InputStream input = resource.getInputStream();
		Properties prop = new Properties();
		prop.load(input);
		Enumeration<?> en = prop.propertyNames();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String property = prop.getProperty(key);
			logger.info(String.format("%s=%s", key, property));
		}

		// 方法2
		Properties props = PropertiesLoaderUtils.loadAllProperties("email.properties");
		logger.info("方法2 : {}", props.getProperty("username"));

		// 方法3
		ResourceBundle bundle = ResourceBundle.getBundle("email");
		logger.info("方法3 : {}", bundle.getString("password"));

		// model -> map
		UserInfo user = new UserInfo();
		user.setId(1);
		user.setUsername("admin");
		user.setEmail("123456@qq.com");
		user.setPhone("10010");
		BeanMap map = new BeanMap(user);
		logger.info("{}", map.getBean());
		logger.info("{}", beanToMap(user));

		Locale locale = LocaleContextHolder.getLocale();
		logger.info("{}", locale);

		Assert.hasText(user.getEmail(), "email must not be empty");
		Assert.hasText(user.getPassword(), "password must not be empty");

	}

	public static Map<String, Object> beanToMap(Object object) {
		Map<String, Object> params = new HashMap<>();
		try {
			PropertyUtilsBean prop = new PropertyUtilsBean();
			PropertyDescriptor[] descriptors = prop.getPropertyDescriptors(object);
			for (int i = 0; i < descriptors.length; i++) {
				String name = descriptors[i].getName();
				if (!"class".equals(name)) {
					params.put(name, prop.getNestedProperty(object, name));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}

}