package com.open.office.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;


    /**
     * 也可以放在application.yml配置文件里面
     *
     * clientId: 必需，客户端ID secret
     * : 对于信任的客户端必需 scope : 客户端允许访问资源的范围，如果该字段未定义或为空，则客户端访问范围不受限制。
     * authorizedGrantTypes: 指定客户端支持的grant_type authorities: 客户端所拥有的Spring Security的权限值
     */
	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
        .inMemory()
        .withClient("zuul_server")
        .secret("secret")
        .scopes("WRIGTH", "read").autoApprove(true)
        .authorities("WRIGTH_READ", "WRIGTH_WRITE")
        .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code");
    }



	@Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
        .tokenStore(jwtTokenStore())
        .tokenEnhancer(jwtTokenConverter())
        .authenticationManager(authenticationManager);
    }

    @Bean // 声明TokenStore实现
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtTokenConverter());
    }
    
    @Bean
    protected JwtAccessTokenConverter jwtTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("springcloud123");
        return converter;
    }
}
