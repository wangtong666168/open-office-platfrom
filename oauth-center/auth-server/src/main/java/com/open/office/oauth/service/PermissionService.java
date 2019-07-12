package com.open.office.oauth.service;

import com.open.office.oauth.common.vo.Result;
import com.open.office.oauth.entity.SysMenu;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:12
 */
public interface PermissionService {
    Result<List<SysMenu>> getRolePermission(Integer roleId);
}
