package com.open.gather.oauth.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.open.gather.oauth.common.util.StatusCode;
import com.open.gather.oauth.common.vo.Result;
import com.open.gather.oauth.common.vo.UserVo;
import com.open.gather.oauth.entity.SysMenu;
import com.open.gather.oauth.entity.SysRole;
import com.open.gather.oauth.entity.SysUser;
import com.open.gather.oauth.service.PermissionService;
import com.open.gather.oauth.service.RoleService;
import com.open.gather.oauth.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mr.Yangxiufeng on 2017/12/27.
 * Time:16:37
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       SysUser sysUser = userService.findByUsername(username);
        if (sysUser==null) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        boolean enabled = true; // 可用性 :true:可用 false:不可用
        boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
        boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
        boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(sysUser,userVo);
		List<SysRole> roleVoList = roleService.getRoleByUserId(userVo.getId());
		for (SysRole role:roleVoList){
			//角色必须是ROLE_开头，可以在数据库中设置
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
			grantedAuthorities.add(grantedAuthority);
			//获取权限
			Result<List<SysMenu>> perResult  = permissionService.getRolePermission(role.getId());
			if (perResult.getCode() != StatusCode.SUCCESS_CODE){
				List<SysMenu> permissionList = perResult.getData();
				for (SysMenu menu:permissionList) {
					GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
					grantedAuthorities.add(authority);
				}
			}
		}
        User user = new User(userVo.getUsername(), userVo.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
