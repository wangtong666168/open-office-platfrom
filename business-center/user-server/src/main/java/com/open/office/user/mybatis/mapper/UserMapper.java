package com.open.office.user.mybatis.mapper;

import com.open.office.user.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    Integer selectUserCount();
}