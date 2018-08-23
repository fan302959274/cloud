package com.cloud.core.mapper;

import com.cloud.core.model.TblAuthUser;
import com.cloud.core.model.TblAuthUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblAuthUserMapper {
    int countByExample(TblAuthUserExample example);

    int deleteByExample(TblAuthUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblAuthUser record);

    int insertSelective(TblAuthUser record);

    List<TblAuthUser> selectByExample(TblAuthUserExample example);

    TblAuthUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblAuthUser record, @Param("example") TblAuthUserExample example);

    int updateByExample(@Param("record") TblAuthUser record, @Param("example") TblAuthUserExample example);

    int updateByPrimaryKeySelective(TblAuthUser record);

    int updateByPrimaryKey(TblAuthUser record);
}