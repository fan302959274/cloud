package com.cloud.common.entity.extend;

import com.cloud.common.entity.TblAuthUser;

public class TblAuthUserExtend extends TblAuthUser {

    private String lastLoginTimeStr;

    public String getLastLoginTimeStr() {
        return lastLoginTimeStr;
    }

    public void setLastLoginTimeStr(String lastLoginTimeStr) {
        this.lastLoginTimeStr = lastLoginTimeStr;
    }
}