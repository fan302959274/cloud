package com.cloud.core.service;

import com.cloud.common.req.TblAdmCardauthlogPageReq;
import com.cloud.common.req.TblAuthUserPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.core.model.TblAdmCardauthlog;
import com.cloud.core.model.TblAuthPermission;
import com.cloud.core.model.TblAdmCardauthlog;
import com.movie.util.response.PageResp;

import java.util.List;

public interface CardAuthLogService {


    /**
     * @description 获取参数
     * @author sh00859
     * @date 2017/7/13
     */
    public TblAdmCardauthlog selectByKey(Long id);

    /**
     * @description 分页查询记录
     * @author sh00859
     * @date 2017/7/13
     */
    public PageResp<TblAdmCardauthlog> selectListByPage(TblAdmCardauthlogPageReq pageReq);

    /**
     * @description 保存记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<TblAdmCardauthlog> save(TblAdmCardauthlog record);

    /**
     * @description 修改记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<TblAdmCardauthlog> update(TblAdmCardauthlog record);

    /**
     * @description 删除记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<String> delete(String ids);



}