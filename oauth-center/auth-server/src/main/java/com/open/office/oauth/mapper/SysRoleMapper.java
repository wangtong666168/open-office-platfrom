package com.open.office.oauth.mapper;

import com.open.office.oauth.entity.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMapper {
    @Select(value = "select role.* from sys_role role,sys_user_role ur where role.id=ur.role_id and ur.user_id=#{userId}")
    List<SysRole> getRoleByUserId(Integer userId);
}