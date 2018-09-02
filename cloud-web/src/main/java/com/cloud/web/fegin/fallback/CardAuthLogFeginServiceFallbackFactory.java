package com.cloud.web.fegin.fallback;

import com.cloud.common.entity.TblAdmCardauthlog;
import com.cloud.common.req.TblAdmCardauthlogPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.web.fegin.CardAuthLogFeginService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CardAuthLogFeginServiceFallbackFactory implements FallbackFactory<CardAuthLogFeginService> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public CardAuthLogFeginService create(Throwable throwable) {
        return new CardAuthLogFeginService() {
            @Override
            public TblAdmCardauthlog selectByKey(Long id) {
                return null;
            }

            @Override
            public PageResp<TblAdmCardauthlog> list(TblAdmCardauthlogPageReq pageReq) {
                return null;
            }

            @Override
            public CommonResp<TblAdmCardauthlog> save(TblAdmCardauthlog TblAdmCardauthlog) {
                logger.error("保存出现异常");
                return null;
            }

            @Override
            public CommonResp<TblAdmCardauthlog> update(TblAdmCardauthlog TblAdmCardauthlog) {
                return null;
            }

            @Override
            public CommonResp<String> delete(String ids) {
                return null;
            }

        };
    }
}