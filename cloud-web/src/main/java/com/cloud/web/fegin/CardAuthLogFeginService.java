package com.cloud.web.fegin;

import com.cloud.common.entity.TblAuthPermission;
import com.cloud.common.entity.TblAdmCardauthlog;
import com.cloud.common.req.TblAdmCardauthlogPageReq;
import com.cloud.common.req.TblAuthUserPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.web.fegin.config.AuthUserFeginServiceConfig;
import com.cloud.web.fegin.fallback.AuthUserFeginServiceFallbackFactory;
import com.cloud.web.fegin.fallback.CardAuthLogFeginServiceFallbackFactory;
import com.movie.util.response.PageResp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "cloud-core", fallbackFactory = CardAuthLogFeginServiceFallbackFactory.class, configuration = AuthUserFeginServiceConfig.class)
public interface CardAuthLogFeginService {

    /**
     * @description 获取
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/cardauth/get", method = RequestMethod.POST)
    public TblAdmCardauthlog selectByKey(@RequestParam(value = "id") Long id);

    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */

    @RequestMapping(value = "/cardauth/data", method = RequestMethod.POST)
    public PageResp<TblAdmCardauthlog> list(@RequestBody TblAdmCardauthlogPageReq pageReq);


    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/cardauth/save", method = RequestMethod.POST)
    public CommonResp<TblAdmCardauthlog> save(@RequestBody TblAdmCardauthlog TblAdmCardauthlog);

    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/cardauth/update", method = RequestMethod.POST)
    public CommonResp<TblAdmCardauthlog> update(@RequestBody TblAdmCardauthlog TblAdmCardauthlog);


    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = "/cardauth/delete", method = RequestMethod.POST)
    public CommonResp<String> delete(@RequestParam(value = "ids") String ids);



}