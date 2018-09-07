package com.cloud.order.mapper;

import com.cloud.order.model.TblCapMessage;
import com.cloud.order.model.TblCapMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblCapMessageMapper {
    int countByExample(TblCapMessageExample example);

    int deleteByExample(TblCapMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblCapMessage record);

    int insertSelective(TblCapMessage record);

    List<TblCapMessage> selectByExample(TblCapMessageExample example);

    TblCapMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblCapMessage record, @Param("example") TblCapMessageExample example);

    int updateByExample(@Param("record") TblCapMessage record, @Param("example") TblCapMessageExample example);

    int updateByPrimaryKeySelective(TblCapMessage record);

    int updateByPrimaryKey(TblCapMessage record);
}