package com.cloud.account.fegin.fallback;

import com.cloud.account.fegin.CommonService;
import com.cloud.common.req.TestEntity;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommonServiceFallbackFactory implements FallbackFactory<CommonService> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public CommonService create(Throwable cause) {
        return new CommonService() {

            @Override
            public String getSerialNo(String type) {
                return null;
            }
        };
    }

}