package com.cloud.core.service;

import com.cloud.common.req.TblAuthPermissionPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.core.model.TblAuthPermission;
import com.cloud.core.model.extend.TblAuthPermissionExtend;

public interface AuthPermissionService {

    /**
     * @description 获取参数
     * @author sh00859
     * @date 2017/7/13
     */
    public TblAuthPermission selectByKey(Long id);

    /**
     * @description 分页查询记录
     * @author sh00859
     * @date 2017/7/13
     */
    public PageResp<TblAuthPermission> selectListByPage(TblAuthPermissionPageReq pageReq);

    /**
     * @description 保存记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<TblAuthPermission> save(TblAuthPermission record);

    /**
     * @description 修改记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<TblAuthPermission> update(TblAuthPermission record);

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
    public PageResp<TblAuthPermissionExtend> selectRolePermissionListByPage(TblAuthPermissionPageReq pageReq);

    /**
     * @description
     * @author sh00859
     * @date 2017/11/24
     */
    public CommonResp<TblAuthPermission> allotPermission(String allotPermissionIds, String noAllotPermissionIds, String roleId);


}