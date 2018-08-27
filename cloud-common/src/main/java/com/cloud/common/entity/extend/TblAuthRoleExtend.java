package com.cloud.common.entity.extend;

import com.cloud.common.entity.TblAuthRole;

public class TblAuthRoleExtend extends TblAuthRole {
    private Long userId;

    private Boolean isuserhave;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsuserhave() {
        return isuserhave;
    }

    public void setIsuserhave(Boolean isuserhave) {
        this.isuserhave = isuserhave;
    }
}