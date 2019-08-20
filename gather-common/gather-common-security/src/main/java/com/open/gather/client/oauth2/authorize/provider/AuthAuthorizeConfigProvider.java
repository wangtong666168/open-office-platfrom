package com.open.gather.client.oauth2.authorize.provider;

import com.open.gather.client.oauth2.authorize.AuthorizeConfigProvider;
import com.open.gather.core.props.PermitUrlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * 类说明 白名单
 */
@Component
@Order(Integer.MAX_VALUE - 1)
@EnableConfigurationProperties(PermitUrlProperties.class)
public class AuthAuthorizeConfigProvider implements AuthorizeConfigProvider {

	@Autowired(required = false)
	private PermitUrlProperties permitUrlProperties;

	@Override
	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

		// 免token登录设置
		config.antMatchers(permitUrlProperties.getIgnored()).permitAll();
		//前后分离时需要带上
		config.antMatchers(HttpMethod.OPTIONS).permitAll();
        
		return true;
	}

}
