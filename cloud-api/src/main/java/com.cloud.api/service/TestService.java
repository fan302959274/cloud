package com.cloud.api.service;/**
 * Created by sh00859 on 2018/8/2.
 */

import com.cloud.api.service.config.TestServiceConfig;
import com.cloud.api.service.fallback.TestServiceFallbackFactory;
import com.cloud.common.req.TestEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * feigin测试类
 *
 * @author
 * @create 2018-08-02 10:12
 **/
@FeignClient(value = "cloud-core", fallbackFactory = TestServiceFallbackFactory.class, configuration = TestServiceConfig.class)
public interface TestService {

    @RequestMapping(value = "/testParam", method = RequestMethod.POST)
    String addParam(@RequestBody TestEntity testEntity);
}