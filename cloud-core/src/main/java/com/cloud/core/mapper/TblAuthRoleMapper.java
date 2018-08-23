package com.cloud.core.mapper;

import com.cloud.core.model.TblAuthRole;
import com.cloud.core.model.TblAuthRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblAuthRoleMapper {
    int countByExample(TblAuthRoleExample example);

    int deleteByExample(TblAuthRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblAuthRole record);

    int insertSelective(TblAuthRole record);

    List<TblAuthRole> selectByExample(TblAuthRoleExample example);

    TblAuthRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblAuthRole record, @Param("example") TblAuthRoleExample example);

    int updateByExample(@Param("record") TblAuthRole record, @Param("example") TblAuthRoleExample example);

    int updateByPrimaryKeySelective(TblAuthRole record);

    int updateByPrimaryKey(TblAuthRole record);
}