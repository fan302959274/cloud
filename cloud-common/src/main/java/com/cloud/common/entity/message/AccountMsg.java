package com.cloud.common.entity.message;/**
 * Created by sh00859 on 2018/9/7.
 */

/**
 * 客户消息传递
 *
 * @author
 * @create 2018-09-07 11:46
 **/
public class AccountMsg {
    private String messageNo;
    private String orderNo;
    private String accountNo;
    private String orderStatus;
    private String operateType;

    public String getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }
}