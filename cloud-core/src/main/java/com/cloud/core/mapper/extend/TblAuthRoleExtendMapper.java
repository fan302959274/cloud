package com.cloud.core.mapper.extend;


import com.cloud.core.model.extend.TblAuthRoleExtend;

import java.util.List;
import java.util.Map;

public interface TblAuthRoleExtendMapper {
    List<TblAuthRoleExtend> selectUserRoleByExample(Map map);

}