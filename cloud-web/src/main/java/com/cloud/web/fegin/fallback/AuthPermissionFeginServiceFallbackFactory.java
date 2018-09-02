package com.cloud.web.fegin.fallback;

import com.cloud.common.entity.TblAuthPermission;
import com.cloud.common.entity.extend.TblAuthPermissionExtend;
import com.cloud.common.req.TblAuthPermissionPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.web.fegin.AuthPermissionFeginService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthPermissionFeginServiceFallbackFactory implements FallbackFactory<AuthPermissionFeginService> {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public AuthPermissionFeginService create(Throwable throwable) {
        return new AuthPermissionFeginService() {

            @Override
            public TblAuthPermission selectByKey(Long id) {
                return null;
            }

            @Override
            public PageResp<TblAuthPermission> list(TblAuthPermissionPageReq pageReq) {
                return null;
            }

            @Override
            public CommonResp<TblAuthPermission> save(TblAuthPermission record) {
                return null;
            }

            @Override
            public CommonResp<TblAuthPermission> update(TblAuthPermission record) {
                return null;
            }

            @Override
            public CommonResp<String> delete(String ids) {
                return null;
            }

            @Override
            public PageResp<TblAuthPermissionExtend> rolepermissiondata(TblAuthPermissionPageReq pageReq) {
                return null;
            }

            @Override
            public CommonResp<TblAuthPermission> userroleallot(String allotPermissionIds, String noAllotPermissionIds, String roleId) {
                logger.error(throwable.getMessage());
                return null;
            }
        };
    }

}