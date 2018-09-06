package com.cloud.core.service;

public interface CommonService {

    /**
     * @description 获取唯一业务id
     * 业务日期+计数(10位不够的补0)
     * @author sh00859
     * @date 2017/7/13
     */
    public String getBusinessId();

    /**
     * @description 获取流水号
     * @author sh00859
     * @date 2017/7/13
     */
    public String getSerialNo(String type);


}