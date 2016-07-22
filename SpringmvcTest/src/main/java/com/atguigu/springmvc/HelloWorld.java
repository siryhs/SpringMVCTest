package com.atguigu.springmvc;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.day03_ms.bean.User;
import com.atguigu.day03_ms.mapper.UserMapper;
import com.atguigu.service.HelloWorldService;

@Controller
public class HelloWorld {

	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private HelloWorldService helloWorldService;
	
	@Value("${email.Host}")
	private String email_Host;

	public HelloWorld() {

		System.out.println("HelloWorld Constructor...");
	}

	@RequestMapping("/save")
	public String save() {
		User user = new User(-1, "Lucy", new Date(), 1235);
		System.out.println(mapper.save(user));
		return "success";
	}

	@RequestMapping("/helloworld")
	public String hello() {

		User user = mapper.findById(1);
		System.out.println(user);
		return "success";
	}

	@RequestMapping("/update")
	public String update() {

		User user = new User(1, "tom1", new Date(), 1);
		System.out.println(mapper.update(user));
		return "success";
	}

	@RequestMapping("/delete")
	public String delete() {

		System.out.println(mapper.delete(1));
		return "success";
	}

	@RequestMapping("/findAll")
	public String findAll() {

		List<User> users = mapper.findAll();
		System.out.println(users);
		System.out.println(email_Host);
		return "success";
	}

	@RequestMapping("/shiwu")
	@Transactional(rollbackFor = Exception.class)
	public String shiwu() {
		User user = new User(-1, "Lucy5", new Date(), 12);
		User user1 = new User(-1, "Lili4", new Date(), 35);
		System.out.println(mapper.save(user));
		System.out.println(1 / 0);
		System.out.println(mapper.save(user1));
		return "success";
	}
	@RequestMapping("/shiwu1")
	public String shiwu1() {
		helloWorldService.shiwu();
		return "success";
	}
}
