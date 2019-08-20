package com.open.gather.core.log.mapper;

import com.open.gather.core.model.log.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

	@Insert("insert into sys_log(username, module, params, remark, flag, createTime) values(#{username}, #{module}, #{params}, #{remark}, #{flag}, #{createTime})")
	int save(SysLog log);

}
