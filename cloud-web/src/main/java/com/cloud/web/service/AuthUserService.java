package com.cloud.web.service;

import com.cloud.common.entity.TblAuthPermission;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface AuthUserService {

    List<TblAuthPermission> findUserPermissionByNickName(String nickname);

}