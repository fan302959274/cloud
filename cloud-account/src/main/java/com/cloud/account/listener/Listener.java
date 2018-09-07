package com.cloud.account.listener;

import com.alibaba.fastjson.JSONObject;
import com.cloud.account.mapper.TblCapMessageMapper;
import com.cloud.account.model.TblCapMessageExample;
import com.cloud.common.entity.message.AccountMsg;
import com.cloud.common.entity.message.OrderCallBackMsg;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Listener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TblCapMessageMapper tblCapMessageMapper;


    @KafkaListener(topics = {"ORDER_NOTIFY"})
    public void listen(ConsumerRecord<?, ?> record) {
        try {
            OrderCallBackMsg ret = JSONObject.parseObject(record.value().toString(),OrderCallBackMsg.class);
            if ("DELETEORDER".equals(ret.getOperateType())) {
                TblCapMessageExample example = new TblCapMessageExample();
                example.createCriteria().andMessageNoEqualTo(ret.getMessageNo());
                tblCapMessageMapper.deleteByExample(example);
            }
        } catch (Exception e) {
            logger.error("消息处理出现异常");
        } finally {
            logger.info("消息处理完成");
        }

    }

}