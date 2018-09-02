package com.cloud.web.web;

import com.cloud.common.entity.TblAuthPermission;
import com.cloud.common.entity.extend.TblAuthPermissionExtend;
import com.cloud.common.req.TblAuthPermissionPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.web.fegin.AuthPermissionFeginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/permission")
public class PermissionController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthPermissionFeginService authPermissionFeginService;

    /**
     * @description 主界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/main"})
    public ModelAndView search(Map map) throws Exception {
        //获取所有的视频类型
        return new ModelAndView("/permission/main", map);

    }


    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/data"})
    @ResponseBody
    public PageResp<TblAuthPermission> list(TblAuthPermissionPageReq pageReq) throws Exception {
        PageResp<TblAuthPermission> resp = authPermissionFeginService.list(pageReq);
        return resp;
    }


    /**
     * @description 添加界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/add"})
    public String add() throws Exception {
        return "/permission/add";
    }


    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/save"})
    @ResponseBody
    public CommonResp<TblAuthPermission> save(TblAuthPermission record) throws Exception {
        return authPermissionFeginService.save(record);
    }


    /**
     * @description 更新页面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/edit"})
    public ModelAndView edit(TblAuthPermission tblAuthUser, Map map) throws Exception {
        map.put("data", authPermissionFeginService.selectByKey(tblAuthUser.getId()));
        return new ModelAndView("/permission/edit", map);
    }

    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/update"})
    @ResponseBody
    public CommonResp<TblAuthPermission> update(TblAuthPermission record) throws Exception {
        return authPermissionFeginService.update(record);
    }

    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public CommonResp<String> delete(String ids) throws Exception {
        return authPermissionFeginService.delete(ids);
    }


    @RequestMapping(value = {"/allot"})
    public ModelAndView allot(String id, Map map) throws Exception {
        //获取所有的视频类型
        map.put("roleId", id);
        return new ModelAndView("/role/allot", map);
    }

    /**
     * @description 用户角色数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/rolepermissiondata"})
    @ResponseBody
    public PageResp<TblAuthPermissionExtend> rolepermissiondata(TblAuthPermissionPageReq pageReq) throws Exception {
        PageResp<TblAuthPermissionExtend> resp = authPermissionFeginService.rolepermissiondata(pageReq);
        return resp;
    }

    /**
     * @description 用户角色分配
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/rolepermissionallot"})
    @ResponseBody
    public CommonResp<TblAuthPermission> userroleallot(String allotPermissionIds, String noAllotPermissionIds, String roleId) throws Exception {
        CommonResp<TblAuthPermission> resp = authPermissionFeginService.userroleallot(allotPermissionIds, noAllotPermissionIds, roleId);
        return resp;
    }


}
