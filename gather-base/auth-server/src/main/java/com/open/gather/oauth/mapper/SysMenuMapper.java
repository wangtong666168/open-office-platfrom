package com.open.gather.oauth.mapper;

import com.open.gather.oauth.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysMenuMapper   {
    @Select(value = "select menu.* from sys_menu menu,sys_privilege p where menu.id=p.menu_id and p.role_id=#{roleId}")
    List<SysMenu> getPermissionsByRoleId(Integer roleId);
}