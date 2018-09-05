package com.cloud.account.mapper;


import com.cloud.account.model.TblAccount;
import com.cloud.account.model.TblAccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TblAccountMapper {
    int countByExample(TblAccountExample example);

    int deleteByExample(TblAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblAccount record);

    int insertSelective(TblAccount record);

    List<TblAccount> selectByExample(TblAccountExample example);

    TblAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblAccount record, @Param("example") TblAccountExample example);

    int updateByExample(@Param("record") TblAccount record, @Param("example") TblAccountExample example);

    int updateByPrimaryKeySelective(TblAccount record);

    int updateByPrimaryKey(TblAccount record);
}