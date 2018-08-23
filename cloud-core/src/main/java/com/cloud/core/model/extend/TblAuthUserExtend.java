package com.cloud.core.model.extend;

import com.cloud.core.model.TblAuthUser;

public class TblAuthUserExtend extends TblAuthUser {

    private String lastLoginTimeStr;

    public String getLastLoginTimeStr() {
        return lastLoginTimeStr;
    }

    public void setLastLoginTimeStr(String lastLoginTimeStr) {
        this.lastLoginTimeStr = lastLoginTimeStr;
    }
}