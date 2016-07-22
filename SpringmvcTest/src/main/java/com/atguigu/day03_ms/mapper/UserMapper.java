package com.atguigu.day03_ms.mapper;

import java.util.List;
/*
 * 约定
 */
import com.atguigu.day03_ms.bean.User;

public interface UserMapper {

	int save(User user);

	int update(User user);

	int delete(int id);

	User findById(int id);

	List<User> findAll();

}
