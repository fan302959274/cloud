package com.cloud.core.facade;

import com.cloud.common.req.TblAuthUserPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.common.resp.ResponseCode;
import com.cloud.core.model.TblAuthPermission;
import com.cloud.core.model.TblAuthUser;
import com.cloud.core.service.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;


/**
 * @author sh00859
 * @description 实例代码
 * @date 2017/8/21
 */
@Controller
@RequestMapping("/user")
public class UserController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthUserService authUserService;


    /**
     * @description 获取参数
     * @author sh00859
     * @date 2017/7/13
     */
    @RequestMapping(value = {"/get"})
    @ResponseBody
    public TblAuthUser selectByKey(@RequestParam(value = "id") Long id) {
        return authUserService.selectByKey(id);
    }


    /**
     * @description 获取用户(通过名称)
     * @author sh00859
     * @date 2017/7/13
     */
    @RequestMapping(value = {"/findByNickName"})
    @ResponseBody
    public TblAuthUser findByNickName(@RequestParam(value = "nickname") String nickname) {
        return authUserService.findUserByNickName(nickname);
    }

    /**
     * @description 通过昵称获取用户的权限
     * @author sh00859
     * @date 2017/11/23
     */
    @RequestMapping(value = {"/findPermissionByNickName"})
    @ResponseBody
    List<TblAuthPermission> findUserPermissionByNickName(@RequestParam(value = "nickname") String nickname) {
        return authUserService.findUserPermissionByNickName(nickname);
    }

    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/data"})
    @ResponseBody
    public PageResp<TblAuthUser> list(@RequestBody TblAuthUserPageReq pageReq) throws Exception {
        PageResp<TblAuthUser> resp = authUserService.selectListByPage(pageReq);
        return resp;
    }

    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/save"})
    @ResponseBody
    public CommonResp<TblAuthUser> save(@RequestBody TblAuthUser tblAuthUser) throws Exception {
        return authUserService.save(tblAuthUser);
    }

    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/update"})
    @ResponseBody
    public CommonResp<TblAuthUser> update(@RequestBody TblAuthUser tblAuthUser) throws Exception {
        return authUserService.update(tblAuthUser);
    }

    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public CommonResp<String> delete(@RequestParam(value = "ids") String ids) throws Exception {
        return authUserService.delete(ids);
    }

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
    public CommonResp<TblAuthUser> ajaxlogin(@RequestBody TblAuthUser tblAuthUser) throws Exception {
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

        return resp;
    }


}
