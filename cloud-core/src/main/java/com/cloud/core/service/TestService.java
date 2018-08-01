package com.cloud.core.service;/**
 * Created by sh00859 on 2018/5/22.
 */

import com.cloud.common.req.TestEntity;
import com.cloud.core.mapper.TblParamMapper;
import com.cloud.core.model.TblParam;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author
 * @create 2018-05-22 14:09
 **/
@Service
public class TestService {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TblParamMapper tblParamMapper;

    public void insertParam(TestEntity testEntity) {
        TblParam record = new TblParam();
        try {
            PropertyUtils.copyProperties(record, testEntity);
        } catch (Exception e) {
            log.error("属性copy异常");
        }
        tblParamMapper.insert(record);

    }
}