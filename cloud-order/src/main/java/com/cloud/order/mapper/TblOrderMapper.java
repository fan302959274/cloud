package com.cloud.order.mapper;

import com.cloud.order.model.TblOrder;
import com.cloud.order.model.TblOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrderMapper {
    int countByExample(TblOrderExample example);

    int deleteByExample(TblOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblOrder record);

    int insertSelective(TblOrder record);

    List<TblOrder> selectByExample(TblOrderExample example);

    TblOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblOrder record, @Param("example") TblOrderExample example);

    int updateByExample(@Param("record") TblOrder record, @Param("example") TblOrderExample example);

    int updateByPrimaryKeySelective(TblOrder record);

    int updateByPrimaryKey(TblOrder record);
}