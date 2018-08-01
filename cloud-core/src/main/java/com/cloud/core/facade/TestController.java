package com.cloud.core.facade;
/**
 * Created by sh00859 on 2018/5/22.
 */

import com.cloud.common.req.TestEntity;
import com.cloud.core.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试
 *
 * @author
 * @create 2018-05-22 13:56
 **/
@RestController
public class TestController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TestService testService;

    /**
     * @description 测试
     * @author sh00859
     * @date 2018/5/14
     */
    @RequestMapping("/testParam")
    @ResponseBody
    public String testParam(@RequestBody TestEntity testEntity) {
        log.info("方法进来了");
        testService.insertParam(testEntity);
        return "成功";
    }

    /**
     * @description 测试
     * @author sh00859
     * @date 2018/5/14
     */
    @RequestMapping("/name")
    @ResponseBody
    public String name() {
        log.info("方法进来了name");
        return "cff";
    }
}