package com.open.gather.oauth.mapper;


import com.open.gather.oauth.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {

	@Select(value = "SELECT * FROM sys_user WHERE username = #{userName}")
	SysUser getSysUserByUserName(String userName);
}