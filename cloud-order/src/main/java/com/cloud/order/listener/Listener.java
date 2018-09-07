package com.cloud.order.listener;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.entity.message.AccountMsg;
import com.cloud.common.entity.message.OrderCallBackMsg;
import com.cloud.order.mapper.TblCapMessageConsumeMapper;
import com.cloud.order.mapper.TblOrderMapper;
import com.cloud.order.model.TblCapMessageConsume;
import com.cloud.order.model.TblCapMessageConsumeExample;
import com.cloud.order.model.TblOrder;
import com.cloud.order.model.TblOrderExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
public class Listener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate<String, String> template;
    @Resource
    private TblCapMessageConsumeMapper tblCapMessageConsumeMapper;
    @Resource
    private TblOrderMapper tblOrderMapper;


    @KafkaListener(topics = {"acct-uni-notice-topic"})
    public void listen(ConsumerRecord<?, ?> record) {
        try {
            AccountMsg ret = JSONObject.parseObject(record.value().toString(), AccountMsg.class);
            String operateType = ret.getOperateType();
            if ("UPDATEORDER".equals(operateType)) {
                String orderNo = ret.getOrderNo();
                String messageNo = ret.getMessageNo();
                String status = ret.getOrderStatus();
                TblCapMessageConsumeExample tblCapMessageConsumeExample = new TblCapMessageConsumeExample();
                tblCapMessageConsumeExample.createCriteria().andMessageNoEqualTo(messageNo);
                List<TblCapMessageConsume> tblCapMessageConsumes = tblCapMessageConsumeMapper.selectByExample(tblCapMessageConsumeExample);
                if (CollectionUtils.isEmpty(tblCapMessageConsumes)) {
                    TblOrder tblOrder = new TblOrder();
                    tblOrder.setOrderStatus(status);
                    TblOrderExample example = new TblOrderExample();
                    example.createCriteria().andOrderNoEqualTo(orderNo);
                    tblOrderMapper.updateByExampleSelective(tblOrder, example);
                    TblCapMessageConsume tblCapMessageConsume = new TblCapMessageConsume();
                    tblCapMessageConsume.setMessageNo(messageNo);
                    tblCapMessageConsume.setMessageType(operateType);
                    tblCapMessageConsume.setConsumeDate(new Date());
                    tblCapMessageConsumeMapper.insertSelective(tblCapMessageConsume);
                    OrderCallBackMsg orderCallBackEntity = new OrderCallBackMsg();
                    orderCallBackEntity.setMessageNo(messageNo);
                    orderCallBackEntity.setOperateType("DELETEORDER");
                    template.send("ORDER_NOTIFY", JSONObject.toJSONString(orderCallBackEntity));
                }
            }
        } catch (Exception e) {
            logger.error("消息处理出现异常");
        } finally {
            logger.info("消息处理完成");
        }

    }

}