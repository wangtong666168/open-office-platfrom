package com.user.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

public interface UserMapper {
    Integer selectUserCount();
}