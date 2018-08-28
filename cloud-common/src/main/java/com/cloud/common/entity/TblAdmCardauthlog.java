package com.cloud.common.entity;

import java.util.Date;

public class TblAdmCardauthlog {
    private Long id;

    private String calAuthBankName;

    private String calAuthBankCard;

    private String calAuthCustName;

    private String calAuthIdno;

    private String calAuthMobile;

    private String calAuthType;

    private Date createDate;

    private Date updateDate;

    private String creator;

    private String updator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalAuthBankName() {
        return calAuthBankName;
    }

    public void setCalAuthBankName(String calAuthBankName) {
        this.calAuthBankName = calAuthBankName;
    }

    public String getCalAuthBankCard() {
        return calAuthBankCard;
    }

    public void setCalAuthBankCard(String calAuthBankCard) {
        this.calAuthBankCard = calAuthBankCard;
    }

    public String getCalAuthCustName() {
        return calAuthCustName;
    }

    public void setCalAuthCustName(String calAuthCustName) {
        this.calAuthCustName = calAuthCustName;
    }

    public String getCalAuthIdno() {
        return calAuthIdno;
    }

    public void setCalAuthIdno(String calAuthIdno) {
        this.calAuthIdno = calAuthIdno;
    }

    public String getCalAuthMobile() {
        return calAuthMobile;
    }

    public void setCalAuthMobile(String calAuthMobile) {
        this.calAuthMobile = calAuthMobile;
    }

    public String getCalAuthType() {
        return calAuthType;
    }

    public void setCalAuthType(String calAuthType) {
        this.calAuthType = calAuthType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }
}