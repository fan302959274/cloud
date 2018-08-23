package com.cloud.web.fegin.config;/**
 * Created by sh00859 on 2018/8/2.
 */

import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AuthUserFeginService配置类
 *
 * @author
 * @create 2018-08-02 10:50
 **/
@Configuration
public class AuthUserFeginServiceConfig {

    @Bean
    public RoundRobinRule feignContract() {
        return new WeightedResponseTimeRule();
    }
}