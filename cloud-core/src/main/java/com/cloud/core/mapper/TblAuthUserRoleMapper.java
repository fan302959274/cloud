package com.cloud.core.mapper;

import com.cloud.core.model.TblAuthUserRole;
import com.cloud.core.model.TblAuthUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblAuthUserRoleMapper {
    int countByExample(TblAuthUserRoleExample example);

    int deleteByExample(TblAuthUserRoleExample example);

    int insert(TblAuthUserRole record);

    int insertSelective(TblAuthUserRole record);

    List<TblAuthUserRole> selectByExample(TblAuthUserRoleExample example);

    int updateByExampleSelective(@Param("record") TblAuthUserRole record, @Param("example") TblAuthUserRoleExample example);

    int updateByExample(@Param("record") TblAuthUserRole record, @Param("example") TblAuthUserRoleExample example);
}