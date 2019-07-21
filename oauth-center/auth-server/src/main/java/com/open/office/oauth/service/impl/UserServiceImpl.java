package com.open.office.oauth.service.impl;

import com.open.office.oauth.common.vo.Result;
import com.open.office.oauth.entity.SysUser;
import com.open.office.oauth.mapper.SysUserMapper;
import com.open.office.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.Sqls;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser findByUsername(String username) {
		return userMapper.getSysUserByUserName(username);
    }
}
