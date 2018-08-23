package com.cloud.web.fegin;

import com.cloud.common.entity.TblAuthRole;
import com.cloud.common.entity.TblAuthUser;
import com.cloud.common.entity.extend.TblAuthRoleExtend;
import com.cloud.common.req.TblAuthRolePageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.web.fegin.config.AuthUserFeginServiceConfig;
import com.cloud.web.fegin.fallback.AuthRoleFeginServiceFallbackFactory;
import com.movie.util.response.PageResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-core", fallbackFactory = AuthRoleFeginServiceFallbackFactory.class, configuration = AuthUserFeginServiceConfig.class)
public interface AuthRoleFeginService {


    /**
     * @description 获取
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/role/get", method = RequestMethod.POST)
    public TblAuthRole selectByKey(@RequestParam(value = "id") Long id);


    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/role/data", method = RequestMethod.POST)
    public PageResp<TblAuthRole> list(@RequestBody TblAuthRolePageReq pageReq);


    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    public CommonResp<TblAuthRole> save(@RequestBody TblAuthRole record);


    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */

    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    public CommonResp<TblAuthRole> update(@RequestBody TblAuthRole record);

    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */

    @RequestMapping(value = "/role/delete", method = RequestMethod.POST)
    public CommonResp<String> delete(@RequestParam(value = "ids") String ids);


    /**
     * @description 用户角色数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/role/userroledata", method = RequestMethod.POST)
    public PageResp<TblAuthRoleExtend> userroledata(@RequestBody TblAuthRolePageReq pageReq);

    /**
     * @description 用户角色分配
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/role/userroleallot", method = RequestMethod.POST)
    public CommonResp<TblAuthRole> userroleallot(@RequestParam(value = "allotRoleIds") String allotRoleIds, @RequestParam(value = "noAllotRoleIds") String noAllotRoleIds, @RequestParam(value = "userId") String userId);

}