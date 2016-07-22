package com.atguigu.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.day03_ms.bean.User;
import com.atguigu.day03_ms.mapper.UserMapper;

@Service
public class HelloWorldService {

	@Autowired
	private UserMapper mapper;
	
	@Value("${email.Host}")
	private String email_Host;

	public HelloWorldService() {

		System.out.println("HelloWorldService Constructor...");
	}

	@Transactional(rollbackFor = Exception.class)
	public String shiwu() {
		System.out.println(email_Host);
		User user = new User(-1, "Lucy5", new Date(), 12);
		User user1 = new User(-1, "Lili4", new Date(), 35);
		System.out.println(mapper.save(user));
		System.out.println(1 / 0);
		System.out.println(mapper.save(user1));
		return "success";
	}
	
}
