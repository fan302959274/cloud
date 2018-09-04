package com.cloud.core.service.impl;

import com.cloud.common.util.DateUtil;
import com.cloud.core.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CommonServiceImpl implements CommonService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    RedisTemplate<Object, Object> redisTemplate;

    @Override
    public String getBusinessId() {
        RedisAtomicLong counter = new RedisAtomicLong("businessdata", redisTemplate.getConnectionFactory());
        return DateUtil.format(new Date(), DateUtil.YYYYMMDD) + StringUtils.leftPad(counter.incrementAndGet() + "", 10, "0");
    }

    @Override
    public String getSerialNo(String type) {
        RedisAtomicLong counter = new RedisAtomicLong("serialdata", redisTemplate.getConnectionFactory());
        String result = (StringUtils.isBlank(type) ? "serial" : type) + StringUtils.leftPad(counter.incrementAndGet() + "", 10, "0");
        return result;
    }
}