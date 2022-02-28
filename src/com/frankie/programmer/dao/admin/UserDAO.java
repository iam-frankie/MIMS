package com.frankie.programmer.dao.admin;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frankie.programmer.entity.admin.User;
import com.frankie.programmer.service.admin.UserService;

/*
 * User
 * DAO层(data access object)
 */

@Repository  //标识数据访问层标识
public interface UserDAO {
	public User findByUsername(String username);
}
