package com.cloud.core.facade;

import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.ResponseCode;
import com.cloud.core.model.TblAuthUser;
import com.cloud.core.service.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;


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
    @RequestMapping(value = {"/ajaxlogin"})
    @ResponseBody
    public CommonResp<TblAuthUser> ajaxlogin(TblAuthUser tblAuthUser, HttpSession session) throws Exception {
        CommonResp<TblAuthUser> resp = new CommonResp<>();

        //先校验用户信息
        if (Objects.isNull(tblAuthUser)) {
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            return resp;
        }
        if (Objects.isNull(tblAuthUser.getNickname())) {
            resp.setCode(ResponseCode.NICKNAME_EMPTY.getCode());
            resp.setMsg(ResponseCode.NICKNAME_EMPTY.getMsg());
            return resp;
        }
        if (Objects.isNull(tblAuthUser.getPswd())) {
            resp.setCode(ResponseCode.PASSWORD_EMPTY.getCode());
            resp.setMsg(ResponseCode.PASSWORD_EMPTY.getMsg());
            return resp;
        }
        TblAuthUser authUser = authUserService.findUserByNickName(tblAuthUser.getNickname());

        if (Objects.isNull(authUser)) {
            resp.setCode(ResponseCode.NICKNAME_NOT_EXISTS.getCode());
            resp.setMsg(ResponseCode.NICKNAME_NOT_EXISTS.getMsg());
            return resp;
        }

        if (!Objects.equals(tblAuthUser.getPswd(), authUser.getPswd())) {
            resp.setCode(ResponseCode.PASSWORD_ERROR.getCode());
            resp.setMsg(ResponseCode.PASSWORD_ERROR.getMsg());
            return resp;
        }

//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(tblAuthUser.getNickname(), tblAuthUser.getPswd());
//        Subject subject = SecurityUtils.getSubject();
//        subject.login(usernamePasswordToken);   //完成登录
//        TblAuthUser user = (TblAuthUser) subject.getPrincipal();
//        session.setAttribute("user", user);
        return resp;
    }


}
