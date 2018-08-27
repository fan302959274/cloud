package com.cloud.core.model.extend;

import com.cloud.core.model.TblAuthPermission;

public class TblAuthPermissionExtend extends TblAuthPermission {
    private Long roleId;

    private Boolean isrolehave;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Boolean getIsrolehave() {
        return isrolehave;
    }

    public void setIsrolehave(Boolean isrolehave) {
        this.isrolehave = isrolehave;
    }
}