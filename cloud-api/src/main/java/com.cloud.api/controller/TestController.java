package com.cloud.api.controller;
/**
 * Created by sh00859 on 2018/5/22.
 */

import com.cloud.common.req.TestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 测试
 *
 * @author
 * @create 2018-05-22 13:56
 **/
@RestController
public class TestController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    /**
     * @description 测试
     * @author sh00859
     * @date 2018/5/14
     */
    @RequestMapping("/testParam")
    public void testParam() {
        log.info("方法进来了");
        TestEntity testEntity = new TestEntity();
        testEntity.setParamType("3232");
        String str = restTemplate.postForEntity("http://cloud-core/testParam", testEntity, String.class).getBody();
        log.info("str:===================" + str);
    }
}