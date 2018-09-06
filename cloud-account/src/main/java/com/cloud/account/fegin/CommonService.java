package com.cloud.account.fegin;/**
 * Created by sh00859 on 2018/8/2.
 */

import com.cloud.account.fegin.config.CommonServiceConfig;
import com.cloud.account.fegin.fallback.CommonServiceFallbackFactory;
import com.cloud.common.req.TestEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feigin测试类
 *
 * @author
 * @create 2018-08-02 10:12
 **/
@FeignClient(value = "cloud-core", fallbackFactory = CommonServiceFallbackFactory.class, configuration = CommonServiceConfig.class)
public interface CommonService {

    /**
     * @description 获取序列号
     * @author sh00859
     * @date 2017/7/13
     */
    @RequestMapping(value = "/common/getSerialNo", method = RequestMethod.POST)
    public String getSerialNo(@RequestParam(value = "type", required = false) String type);
}