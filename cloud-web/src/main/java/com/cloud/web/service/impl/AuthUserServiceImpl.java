package com.cloud.web.service.impl;

import com.cloud.common.entity.TblAuthPermission;
import com.cloud.web.fegin.AuthUserFeginService;
import com.cloud.web.service.AuthUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AuthUserFeginService authUserFeginService;
    @Override
    public List<TblAuthPermission> findUserPermissionByNickName(String nickname) {
        return authUserFeginService.findUserPermissionByNickName(nickname);
    }
}