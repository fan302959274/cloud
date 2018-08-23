package com.cloud.web.web;

import com.cloud.web.service.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author sh00859
 * @description 登录相关
 * @date 2017/8/21
 */
@Controller
public class LoginController {

    @Autowired
    private AuthUserService authUserService;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 登录页面
     *
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/login"})
    public String login() throws Exception {
        return "login";
    }


}
