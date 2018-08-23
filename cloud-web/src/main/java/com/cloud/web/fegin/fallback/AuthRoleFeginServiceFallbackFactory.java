package com.cloud.web.fegin.fallback;

import com.cloud.common.entity.TblAuthRole;
import com.cloud.common.entity.extend.TblAuthRoleExtend;
import com.cloud.common.req.TblAuthRolePageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.web.fegin.AuthRoleFeginService;
import com.movie.util.response.PageResp;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthRoleFeginServiceFallbackFactory implements FallbackFactory<AuthRoleFeginService> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public AuthRoleFeginService create(Throwable throwable) {
        return new AuthRoleFeginService() {

            @Override
            public TblAuthRole selectByKey(Long id) {
                return null;
            }

            @Override
            public PageResp<TblAuthRole> list(TblAuthRolePageReq pageReq) {
                return null;
            }

            @Override
            public CommonResp<TblAuthRole> save(TblAuthRole record) {
                return null;
            }

            @Override
            public CommonResp<TblAuthRole> update(TblAuthRole record) {
                return null;
            }

            @Override
            public CommonResp<String> delete(String ids) {
                return null;
            }

            @Override
            public PageResp<TblAuthRoleExtend> userroledata(TblAuthRolePageReq pageReq) {
                return null;
            }

            @Override
            public CommonResp<TblAuthRole> userroleallot(String allotRoleIds, String noAllotRoleIds, String userId) {
                return null;
            }
        };
    }

}