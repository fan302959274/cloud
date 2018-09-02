package com.cloud.web.web;

import com.cloud.common.entity.TblAuthUser;
import com.cloud.common.req.TblAuthUserPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.web.fegin.AuthUserFeginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
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
    private AuthUserFeginService authUserFeginService;

    /**
     * @description 主界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/main"})
    public ModelAndView search(Map map) throws Exception {
        //获取所有的视频类型
        return new ModelAndView("/user/main", map);

    }


    /**
     * @description 添加界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/add"})
    public String add() throws Exception {
        return "/user/add";
    }


    /**
     * @description 更新页面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/edit"})
    public ModelAndView edit(TblAuthUser tblAuthUser, Map map) throws Exception {
        map.put("data", authUserFeginService.selectByKey(tblAuthUser.getId()));
        return new ModelAndView("/user/edit", map);
    }

    /**
     * @description 分配界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/allot/{id}"})
    public ModelAndView allot(@PathVariable String id, Map map) throws Exception {
        map.put("userId", id);
        return new ModelAndView("/user/allot", map);
    }


    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/data"})
    @ResponseBody
    public PageResp<TblAuthUser> list(TblAuthUserPageReq pageReq) throws Exception {
        PageResp<TblAuthUser> resp = authUserFeginService.list(pageReq);
        return resp;
    }


    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/save"})
    @ResponseBody
    public CommonResp<TblAuthUser> save(TblAuthUser tblAuthUser) throws Exception {
        return authUserFeginService.save(tblAuthUser);
    }

    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/update"})
    @ResponseBody
    public CommonResp<TblAuthUser> update(TblAuthUser tblAuthUser) throws Exception {
        return authUserFeginService.update(tblAuthUser);
    }

    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public CommonResp<String> delete(String ids) throws Exception {
        return authUserFeginService.delete(ids);
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
    public CommonResp<TblAuthUser> ajaxlogin(TblAuthUser tblAuthUser) throws Exception {
        CommonResp<TblAuthUser> resp = authUserFeginService.ajaxlogin(tblAuthUser);
        if (Objects.equals("0", resp.getCode())) {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(tblAuthUser.getNickname(), tblAuthUser.getPswd());
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);   //完成登录
            logger.info("login over");
        }
        return resp;
    }


}
