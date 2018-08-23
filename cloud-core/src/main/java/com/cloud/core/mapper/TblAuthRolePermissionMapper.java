package com.cloud.core.mapper;

import com.cloud.core.model.TblAuthRolePermission;
import com.cloud.core.model.TblAuthRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblAuthRolePermissionMapper {
    int countByExample(TblAuthRolePermissionExample example);

    int deleteByExample(TblAuthRolePermissionExample example);

    int insert(TblAuthRolePermission record);

    int insertSelective(TblAuthRolePermission record);

    List<TblAuthRolePermission> selectByExample(TblAuthRolePermissionExample example);

    int updateByExampleSelective(@Param("record") TblAuthRolePermission record, @Param("example") TblAuthRolePermissionExample example);

    int updateByExample(@Param("record") TblAuthRolePermission record, @Param("example") TblAuthRolePermissionExample example);
}