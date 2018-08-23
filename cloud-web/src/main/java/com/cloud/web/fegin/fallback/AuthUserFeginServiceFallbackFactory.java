package com.cloud.web.fegin.fallback;

import com.cloud.common.entity.TblAuthPermission;
import com.cloud.common.entity.TblAuthUser;
import com.cloud.common.req.TblAuthUserPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.web.fegin.AuthUserFeginService;
import com.movie.util.response.PageResp;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthUserFeginServiceFallbackFactory implements FallbackFactory<AuthUserFeginService> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public AuthUserFeginService create(Throwable throwable) {
        return new AuthUserFeginService() {
            @Override
            public TblAuthUser selectByKey(Long id) {
                return null;
            }

            @Override
            public PageResp<TblAuthUser> list(TblAuthUserPageReq pageReq) {
                return null;
            }

            @Override
            public CommonResp<TblAuthUser> save(TblAuthUser tblAuthUser) {
                logger.error("保存出现异常");
                return null;
            }

            @Override
            public CommonResp<TblAuthUser> update(TblAuthUser tblAuthUser) {
                return null;
            }

            @Override
            public CommonResp<String> delete(String ids) {
                return null;
            }
        };
    }
}