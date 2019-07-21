package com.open.office.oauth.service;

import com.open.office.oauth.common.vo.Result;
import com.open.office.oauth.entity.SysUser;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-09
 * Time: 9:48
 */
public interface UserService {
	SysUser findByUsername(String username);
}
