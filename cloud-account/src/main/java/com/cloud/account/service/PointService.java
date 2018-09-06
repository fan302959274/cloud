package com.cloud.account.service;/**
 * Created by sh00859 on 2018/5/22.
 */

import com.cloud.account.model.TblAccount;
import com.cloud.common.resp.CommonResp;

import java.math.BigDecimal;

/**
 * @author
 * @create 2018-05-22 14:09
 **/
public interface PointService {
    /**
     * @description 操作积分method
     * @author sh00859
     * @date 2018/9/6
     */
    public CommonResp<TblAccount> operatePoint(String accountNo, BigDecimal point);


}