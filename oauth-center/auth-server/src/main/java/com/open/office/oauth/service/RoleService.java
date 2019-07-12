package com.open.office.oauth.service;

import com.open.office.oauth.common.vo.Result;
import com.open.office.oauth.entity.SysRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-10
 * Time: 20:26
 */
public interface RoleService {
    Result<List<SysRole>> getRoleByUserId(Integer userId);
}
