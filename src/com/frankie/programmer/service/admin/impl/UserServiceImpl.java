package com.frankie.programmer.service.admin.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frankie.programmer.dao.admin.UserDAO;
import com.frankie.programmer.entity.admin.User;
import com.frankie.programmer.service.admin.UserService;

/*
 * user用户
 * Serviceimpl
 * 服务实现层
 */
@Service //实现层同样在服务层，要进行service标识
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

}
