package com.open.office.oauth.mapper;


import com.open.office.oauth.entity.SysUser;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper  extends Mapper<SysUser> {

	@Select(value = "SELECT * FROM sys_user WHERE username = #{userName}")
	SysUser getSysUserByUserName(String userName);
}