package com.hualala.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

@Configuration
public class RedisLockConfiguration {
    /** 分布式锁的组名称 **/
    private static final String INTEGRATIONGROUPKEY = "redis_integration";
    /** 分布式锁持有时间（避免获取后处理业务异常，锁不释放）**/
    private static final long EXPIREAFTER = 10L*1000L;

    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        return new RedisLockRegistry(redisConnectionFactory, INTEGRATIONGROUPKEY,EXPIREAFTER);
    }

}