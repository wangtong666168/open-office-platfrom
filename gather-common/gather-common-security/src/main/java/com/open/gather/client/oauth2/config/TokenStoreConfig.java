package com.open.gather.client.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class TokenStoreConfig {


	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	@Bean
	RedisTokenStore redisTokenStore(){
		return new RedisTokenStore(redisConnectionFactory);
	}
	

}
