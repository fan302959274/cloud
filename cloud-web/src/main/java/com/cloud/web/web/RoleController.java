package com.cloud.web.web;

import com.cloud.common.entity.TblAuthRole;
import com.cloud.common.entity.extend.TblAuthRoleExtend;
import com.cloud.common.req.TblAuthRolePageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.web.fegin.AuthRoleFeginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


/**
 * @author sh00859
 * @description 实例代码
 * @date 2017/8/21
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthRoleFeginService authRoleFeginService;

    /**
     * @description 主界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/main"})
    public ModelAndView search(Map map) throws Exception {
        //获取所有的视频类型
        return new ModelAndView("/role/main", map);

    }


    /**
     * @description 添加界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/add"})
    public String add() throws Exception {
        return "/role/add";
    }


    /**
     * @description 更新页面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/edit"})
    public ModelAndView edit(TblAuthRole tblAuthRole, Map map) throws Exception {
        map.put("data", authRoleFeginService.selectByKey(tblAuthRole.getId()));
        return new ModelAndView("/role/edit", map);
    }


    /**
     * @description 分配界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/allot/{id}"})
    public ModelAndView allot(@PathVariable String id, Map map) throws Exception {
        map.put("roleId", id);
        return new ModelAndView("/role/allot", map);
    }

    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/data"})
    @ResponseBody
    public PageResp<TblAuthRole> list(TblAuthRolePageReq pageReq) throws Exception {
        PageResp<TblAuthRole> resp = authRoleFeginService.list(pageReq);
        return resp;
    }

    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/save"})
    @ResponseBody
    public CommonResp<TblAuthRole> save(TblAuthRole record) throws Exception {
        return authRoleFeginService.save(record);
    }

    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/update"})
    @ResponseBody
    public CommonResp<TblAuthRole> update(TblAuthRole record) throws Exception {
        return authRoleFeginService.update(record);
    }


    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public CommonResp<String> delete(String ids) throws Exception {
        return authRoleFeginService.delete(ids);
    }

    /**
     * @description 用户角色数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/userroledata"})
    @ResponseBody
    public PageResp<TblAuthRoleExtend> userroledata(TblAuthRolePageReq pageReq) throws Exception {
        PageResp<TblAuthRoleExtend> resp = authRoleFeginService.userroledata(pageReq);
        return resp;
    }

    /**
     * @description 用户角色分配
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/userroleallot"})
    @ResponseBody
    public CommonResp<TblAuthRole> userroleallot(String allotRoleIds, String noAllotRoleIds, String userId) throws Exception {
        CommonResp<TblAuthRole> resp = authRoleFeginService.userroleallot(allotRoleIds, noAllotRoleIds, userId);
        return resp;
    }


}
