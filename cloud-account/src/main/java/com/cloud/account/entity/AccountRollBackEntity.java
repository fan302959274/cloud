package com.cloud.account.entity;/**
 * Created by sh00859 on 2018/9/7.
 */

import java.math.BigDecimal;

/**
 * 客户回滚实体
 *
 * @author
 * @create 2018-09-07 11:13
 **/
public class AccountRollBackEntity {
    private String serialNo;
    private String orderNo;
    private String accountNo;
    private BigDecimal amount;
    private BigDecimal oldAmount;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getOldAmount() {
        return oldAmount;
    }

    public void setOldAmount(BigDecimal oldAmount) {
        this.oldAmount = oldAmount;
    }
}