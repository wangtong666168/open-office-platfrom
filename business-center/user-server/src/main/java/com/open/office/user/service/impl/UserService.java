package com.open.office.user.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.open.office.user.mybatis.mapper.UserMapper;
import com.open.office.user.mybatis.pojo.User;
import com.open.office.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 */
@Component
public class UserService implements IUserService{

	@Autowired
	private UserMapper rmsUserMapper;

	@Override
//	@HystrixCommand(fallbackMethod="defaultUser")
	public Integer getUser() throws Exception {
		int count = rmsUserMapper.selectUserCount();
		return count;
	}
	
	 /**
	  * 出错则调用该方法返回友好错误
	  * @param username
	  * @return
	  */
	 public String defaultUser(String username) {
	    return "The user does not exist in this system";
	 }
	 
}
