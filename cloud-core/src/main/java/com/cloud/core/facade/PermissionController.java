package com.cloud.core.facade;

import com.cloud.common.req.TblAuthPermissionPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.core.model.TblAuthPermission;
import com.cloud.core.model.extend.TblAuthPermissionExtend;
import com.cloud.core.service.AuthPermissionService;
import com.movie.util.response.PageResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
    private AuthPermissionService authPermissionService;


    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/data"})
    @ResponseBody
    public PageResp<TblAuthPermission> list(@RequestBody TblAuthPermissionPageReq pageReq) throws Exception {
        PageResp<TblAuthPermission> resp = authPermissionService.selectListByPage(pageReq);
        return resp;
    }


    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/save"})
    @ResponseBody
    public CommonResp<TblAuthPermission> save(@RequestBody TblAuthPermission record) throws Exception {
        return authPermissionService.save(record);
    }

    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/update"})
    @ResponseBody
    public CommonResp<TblAuthPermission> update(@RequestBody TblAuthPermission record) throws Exception {
        return authPermissionService.update(record);
    }

    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public CommonResp<String> delete(@RequestParam(value = "ids") String ids) throws Exception {
        return authPermissionService.delete(ids);
    }


    /**
     * @description 用户角色数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/rolepermissiondata"})
    @ResponseBody
    public PageResp<TblAuthPermissionExtend> rolepermissiondata(@RequestBody TblAuthPermissionPageReq pageReq) throws Exception {
        PageResp<TblAuthPermissionExtend> resp = authPermissionService.selectRolePermissionListByPage(pageReq);
        return resp;
    }

    /**
     * @description 用户角色分配
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/rolepermissionallot"})
    @ResponseBody
    public CommonResp<TblAuthPermission> userroleallot(@RequestParam(value = "allotPermissionIds") String allotPermissionIds, @RequestParam(value = "noAllotPermissionIds") String noAllotPermissionIds, @RequestParam(value = "roleId") String roleId) throws Exception {
        CommonResp<TblAuthPermission> resp = authPermissionService.allotPermission(allotPermissionIds, noAllotPermissionIds, roleId);
        return resp;
    }


}
