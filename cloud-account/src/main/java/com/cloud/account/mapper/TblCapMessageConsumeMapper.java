package com.cloud.account.mapper;

import com.cloud.account.model.TblCapMessageConsume;
import com.cloud.account.model.TblCapMessageConsumeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblCapMessageConsumeMapper {
    int countByExample(TblCapMessageConsumeExample example);

    int deleteByExample(TblCapMessageConsumeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblCapMessageConsume record);

    int insertSelective(TblCapMessageConsume record);

    List<TblCapMessageConsume> selectByExample(TblCapMessageConsumeExample example);

    TblCapMessageConsume selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblCapMessageConsume record, @Param("example") TblCapMessageConsumeExample example);

    int updateByExample(@Param("record") TblCapMessageConsume record, @Param("example") TblCapMessageConsumeExample example);

    int updateByPrimaryKeySelective(TblCapMessageConsume record);

    int updateByPrimaryKey(TblCapMessageConsume record);
}