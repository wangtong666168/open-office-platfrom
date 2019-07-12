package com.open.office.oauth.service.impl;

import com.open.office.oauth.common.vo.Result;
import com.open.office.oauth.entity.SysUser;
import com.open.office.oauth.mapper.SysUserMapper;
import com.open.office.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-10
 * Time: 19:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public Result<SysUser>  findByUsername(String username) {
//        SysUser user = userService.findByUsername(username);
//        if (user == null){
//            return Result.failure(100,"用户不存在");
//        }
        SysUser user = new SysUser();
        return Result.ok().setData(user);
    }
}
