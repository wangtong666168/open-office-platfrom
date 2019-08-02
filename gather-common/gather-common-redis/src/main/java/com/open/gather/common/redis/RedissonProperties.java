package com.open.gather.common.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @author Nikita Koksharov
 *
 */
@ConfigurationProperties(prefix = "spring.redis.redisson")
public class RedissonProperties {

    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
        
}