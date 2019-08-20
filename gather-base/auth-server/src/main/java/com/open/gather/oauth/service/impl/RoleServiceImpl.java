package com.open.gather.oauth.service.impl;

import com.open.gather.oauth.entity.SysRole;
import com.open.gather.oauth.mapper.SysRoleMapper;
import com.open.gather.oauth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-10
 * Time: 20:28
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> getRoleByUserId(Integer userId) {

        List<SysRole> roleList = roleMapper.getRoleByUserId(userId);
        return roleList;

    }
}
