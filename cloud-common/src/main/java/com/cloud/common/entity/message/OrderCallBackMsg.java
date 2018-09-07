package com.cloud.common.entity.message;/**
 * Created by sh00859 on 2018/9/7.
 */

/**
 * 订单回传实体
 *
 * @author
 * @create 2018-09-07 11:39
 **/
public class OrderCallBackMsg {
    private String operateType;
    private String messageNo;

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }
}