package com.cloud.core.mapper.extend;

import com.cloud.core.model.TblAuthPermission;
import com.cloud.core.model.extend.TblAuthPermissionExtend;

import java.util.List;
import java.util.Map;

public interface TblAuthPermissionExtendMapper {
    List<TblAuthPermissionExtend> selectRolePermissionByExample(Map map);


    List<TblAuthPermission> findUserPermissionByNickName(String nickname);

}