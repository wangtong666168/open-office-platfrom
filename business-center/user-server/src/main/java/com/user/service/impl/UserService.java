package com.user.service.impl;


import com.user.mybatis.mapper.UserMapper;
import com.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class UserService implements IUserService{

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
