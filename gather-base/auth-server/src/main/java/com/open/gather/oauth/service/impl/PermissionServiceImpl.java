package com.open.gather.oauth.service.impl;

import com.open.gather.oauth.common.vo.Result;
import com.open.gather.oauth.entity.SysMenu;
import com.open.gather.oauth.mapper.SysMenuMapper;
import com.open.gather.oauth.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:12
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysMenuMapper menuMapper;
    @Override
    public Result<List<SysMenu>> getRolePermission(Integer roleId) {
        List<SysMenu> menuList = menuMapper.getPermissionsByRoleId(roleId);

        return Result.ok().setData(menuList);
    }
}
