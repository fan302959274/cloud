package com.cloud.core.facade;

import com.cloud.common.req.TblAuthRolePageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.core.model.TblAuthRole;
import com.cloud.core.model.TblParam;
import com.cloud.core.model.extend.TblAuthRoleExtend;
import com.cloud.core.service.AuthRoleService;
import com.movie.util.response.PageResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private AuthRoleService authRoleService;




    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/data"})
    @ResponseBody
    public PageResp<TblAuthRole> list(@RequestBody TblAuthRolePageReq pageReq) throws Exception {
        PageResp<TblAuthRole> resp = authRoleService.selectListByPage(pageReq);
        return resp;
    }

    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/save"})
    @ResponseBody
    public CommonResp<TblAuthRole> save(@RequestBody TblAuthRole record) throws Exception {
        return authRoleService.save(record);
    }



    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/update"})
    @ResponseBody
    public CommonResp<TblAuthRole> update(@RequestBody TblAuthRole record) throws Exception {
        return authRoleService.update(record);
    }

    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public CommonResp<String> delete(String ids) throws Exception {
        return authRoleService.delete(ids);
    }

    /**
     * @description 用户角色数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/userroledata"})
    @ResponseBody
    public PageResp<TblAuthRoleExtend> userroledata(@RequestBody TblAuthRolePageReq pageReq) throws Exception {
        PageResp<TblAuthRoleExtend> resp = authRoleService.selectUserRoleListByPage(pageReq);
        return resp;
    }

    /**
     * @description 用户角色分配
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/userroleallot"})
    @ResponseBody
    public CommonResp<TblAuthRole> userroleallot(@RequestParam(value = "allotRoleIds") String allotRoleIds, @RequestParam(value = "noAllotRoleIds") String noAllotRoleIds, @RequestParam(value = "userId") String userId) throws Exception {
        CommonResp<TblAuthRole> resp = authRoleService.allotRole(allotRoleIds, noAllotRoleIds, userId);
        return resp;
    }


}
