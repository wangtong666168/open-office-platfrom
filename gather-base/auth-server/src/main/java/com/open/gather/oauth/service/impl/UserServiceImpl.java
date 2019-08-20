package com.open.gather.oauth.service.impl;

import com.open.gather.oauth.entity.SysUser;
import com.open.gather.oauth.mapper.SysUserMapper;
import com.open.gather.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser findByUsername(String username) {
		return userMapper.getSysUserByUserName(username);
    }
}
