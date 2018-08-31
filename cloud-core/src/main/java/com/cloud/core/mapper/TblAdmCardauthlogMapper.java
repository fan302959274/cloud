package com.cloud.core.mapper;

import com.cloud.core.model.TblAdmCardauthlog;
import com.cloud.core.model.TblAdmCardauthlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblAdmCardauthlogMapper {
    int countByExample(TblAdmCardauthlogExample example);

    int deleteByExample(TblAdmCardauthlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblAdmCardauthlog record);

    int insertSelective(TblAdmCardauthlog record);

    List<TblAdmCardauthlog> selectByExample(TblAdmCardauthlogExample example);

    TblAdmCardauthlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblAdmCardauthlog record, @Param("example") TblAdmCardauthlogExample example);

    int updateByExample(@Param("record") TblAdmCardauthlog record, @Param("example") TblAdmCardauthlogExample example);

    int updateByPrimaryKeySelective(TblAdmCardauthlog record);

    int updateByPrimaryKey(TblAdmCardauthlog record);
}