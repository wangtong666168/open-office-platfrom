package com.open.office.user.service;

import com.open.office.user.mybatis.pojo.User;

import java.util.List;

public interface IUserService {
    Integer getUser(String username) throws Exception;

}
