package com.cloud.api.service.fallback;

import com.cloud.api.service.TestService;
import com.cloud.common.req.TestEntity;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestServiceFallbackFactory implements FallbackFactory<TestService> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public TestService create(Throwable cause) {
        return new TestService() {

            @Override
            public String addParam(TestEntity testEntity) {
                logger.error("调用提供者接口异常[{}]", cause.getMessage());
                return null;
            }
        };
    }

}