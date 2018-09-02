package com.cloud.core.service;

import com.cloud.common.req.TblAuthUserPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.core.model.TblAuthPermission;
import com.cloud.core.model.TblAuthUser;

import java.util.List;

public interface AuthUserService {
    /**
     * @description 通过名称获取
     * @author sh00859
     * @date 2017/11/23
     */
    TblAuthUser findUserByNickName(String nickname);

    /**
     * @description 获取参数
     * @author sh00859
     * @date 2017/7/13
     */
    public TblAuthUser selectByKey(Long id);

    /**
     * @description 分页查询记录
     * @author sh00859
     * @date 2017/7/13
     */
    public PageResp<TblAuthUser> selectListByPage(TblAuthUserPageReq pageReq);

    /**
     * @description 保存记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<TblAuthUser> save(TblAuthUser record);

    /**
     * @description 修改记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<TblAuthUser> update(TblAuthUser record);

    /**
     * @description 删除记录
     * @author sh00859
     * @date 2017/7/13
     */
    public CommonResp<String> delete(String ids);

    /**
     * @description 通过昵称获取用户的权限
     * @author sh00859
     * @date 2017/11/23
     */
    List<TblAuthPermission> findUserPermissionByNickName(String nickname);


}