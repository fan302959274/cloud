package com.cloud.web.config;

import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author sh00859
 * @description guava相关配置
 * 超时时间100秒，最多缓存1000个
 * @date 2018/9/3
 */
@Configuration
public class GuavaCacheConfig {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public CacheManager cacheManager() {
        GuavaCacheManager guavaCacheManager = new GuavaCacheManager();
        guavaCacheManager.setCacheBuilder(

                CacheBuilder.newBuilder().expireAfterWrite(100, TimeUnit.SECONDS).maximumSize(1000)
        );
        return guavaCacheManager;
    }
}
