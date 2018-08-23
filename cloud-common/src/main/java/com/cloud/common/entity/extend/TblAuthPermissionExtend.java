package com.cloud.common.entity.extend;


import com.cloud.common.entity.TblAuthPermission;

public class TblAuthPermissionExtend extends TblAuthPermission {
    private Long roleId;

    private Boolean isRoleHave;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Boolean getRoleHave() {
        return isRoleHave;
    }

    public void setRoleHave(Boolean roleHave) {
        isRoleHave = roleHave;
    }
}