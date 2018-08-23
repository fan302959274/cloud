package com.cloud.web.fegin;

import com.cloud.common.entity.TblAuthPermission;
import com.cloud.common.entity.extend.TblAuthPermissionExtend;
import com.cloud.common.req.TblAuthPermissionPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.web.fegin.config.AuthUserFeginServiceConfig;
import com.cloud.web.fegin.fallback.AuthPermissionFeginServiceFallbackFactory;
import com.movie.util.response.PageResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-core", fallbackFactory = AuthPermissionFeginServiceFallbackFactory.class, configuration = AuthUserFeginServiceConfig.class)
public interface AuthPermissionFeginService {

    /**
     * @description 获取
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/permission/get", method = RequestMethod.POST)
    public TblAuthPermission selectByKey(@RequestParam(value = "id") Long id);

    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/permission/data", method = RequestMethod.POST)
    public PageResp<TblAuthPermission> list(@RequestBody TblAuthPermissionPageReq pageReq);


    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */

    @RequestMapping(value = "/permission/save", method = RequestMethod.POST)
    public CommonResp<TblAuthPermission> save(@RequestBody TblAuthPermission record);


    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */

    @RequestMapping(value = "/permission/update", method = RequestMethod.POST)
    public CommonResp<TblAuthPermission> update(@RequestBody TblAuthPermission record);

    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */

    @RequestMapping(value = "/permission/delete", method = RequestMethod.POST)
    public CommonResp<String> delete(@RequestParam(value = "ids") String ids);


    /**
     * @description 用户角色数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/permission/rolepermissiondata", method = RequestMethod.POST)
    public PageResp<TblAuthPermissionExtend> rolepermissiondata(@RequestBody TblAuthPermissionPageReq pageReq);

    /**
     * @description 用户角色分配
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/permission/rolepermissionallot", method = RequestMethod.POST)
    public CommonResp<TblAuthPermission> userroleallot(@RequestParam(value = "allotPermissionIds") String allotPermissionIds, @RequestParam(value = "noAllotPermissionIds") String noAllotPermissionIds, @RequestParam(value = "roleId") String roleId);


}