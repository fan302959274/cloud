package com.cloud.core.service;

import com.cloud.common.req.TblAuthRolePageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.core.model.TblAuthRole;
import com.cloud.core.model.extend.TblAuthRoleExtend;
import com.movie.util.response.PageResp;

public interface AuthRoleService {

    /**
     * @description 获取参数
     * @author sh00859
     * @date 2017/7/13
     */
    public TblAuthRole selectByKey(Long id);

    /**
     * @description 分页查询记录
     * @author sh00859
     * @date 2017/7/13
     */
    public PageResp<TblAuthRole> selectListByPage(TblAuthRolePageReq pageReq);

    /**
     * @description 保存记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<TblAuthRole> save(TblAuthRole record);

    /**
     * @description 修改记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<TblAuthRole> update(TblAuthRole record);

    /**
     * @description 删除记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<String> delete(String ids);

    /**
     * @description 分页查询记录
     * @author sh00859
     * @date 2017/7/13
     */
    public PageResp<TblAuthRoleExtend> selectUserRoleListByPage(TblAuthRolePageReq pageReq);


    /**
     * @description
     * @author sh00859
     * @date 2017/11/24
     */
    public CommonResp<TblAuthRole> allotRole(String allotRoleIds, String noAllotRoleIds, String userId);

}