package com.cloud.common.entity.extend;

import com.cloud.common.entity.TblAuthRole;

public class TblAuthRoleExtend extends TblAuthRole {
    private Long userId;

    private Boolean isUserHave;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getUserHave() {
        return isUserHave;
    }

    public void setUserHave(Boolean userHave) {
        isUserHave = userHave;
    }
}