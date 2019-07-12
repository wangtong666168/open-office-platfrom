package com.open.office.oauth.mapper;

import com.open.office.oauth.entity.SysMenu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysMenuMapper  {
    @Select(value = "select menu.* from sys_menu menu,sys_privilege p where menu.id=p.menu_id and p.role_id=#{roleId}")
    List<SysMenu> getPermissionsByRoleId(Integer roleId);
}