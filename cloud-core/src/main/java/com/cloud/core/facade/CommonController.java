package com.cloud.core.facade;

import com.cloud.core.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author sh00859
 * @description 实例代码
 * @date 2017/8/21
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CommonService commonService;


    /**
     * @description 获取业务id
     * @author sh00859
     * @date 2017/7/13
     */
    @RequestMapping(value = {"/getBusinessId"})
    @ResponseBody
    public String getBusinessId() {
        return commonService.getBusinessId();
    }

    /**
     * @description 获取序列号
     * @author sh00859
     * @date 2017/7/13
     */
    @RequestMapping(value = {"/getSerialNo"})
    @ResponseBody
    public String getSerialNo(@RequestParam(value = "type", required = false) String type) {
        return commonService.getSerialNo(type);
    }


}
