package com.frankie.programmer.service.admin;

import org.springframework.stereotype.Service;

import com.frankie.programmer.entity.admin.User;

/*
 * Service层
 * 定义服务方法
 */

@Service  //标识服务层标识
public interface UserService {
	public User findByUsername(String username);
}
