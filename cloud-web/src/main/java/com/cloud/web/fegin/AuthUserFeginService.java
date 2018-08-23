package com.cloud.web.fegin;

import com.cloud.common.entity.TblAuthUser;
import com.cloud.common.req.TblAuthUserPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.web.fegin.config.AuthUserFeginServiceConfig;
import com.cloud.web.fegin.fallback.AuthUserFeginServiceFallbackFactory;
import com.movie.util.response.PageResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "cloud-core", fallbackFactory = AuthUserFeginServiceFallbackFactory.class, configuration = AuthUserFeginServiceConfig.class)
public interface AuthUserFeginService {

    /**
     * @description 获取
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/user/get", method = RequestMethod.POST)
    public TblAuthUser selectByKey(@RequestParam(value = "id") Long id);


    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */

    @RequestMapping(value = "/user/data", method = RequestMethod.POST)
    public PageResp<TblAuthUser> list(@RequestBody TblAuthUserPageReq pageReq);


    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public CommonResp<TblAuthUser> save(@RequestBody TblAuthUser tblAuthUser);

    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public CommonResp<TblAuthUser> update(@RequestBody TblAuthUser tblAuthUser);


    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public CommonResp<String> delete(@RequestParam(value = "ids") String ids);


}