package com.cloud.account.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cloud.account.entity.AccountRollBackEntity;
import com.cloud.account.fegin.CommonService;
import com.cloud.account.mapper.TblAccountMapper;
import com.cloud.account.mapper.TblCapMessageMapper;
import com.cloud.account.model.TblAccount;
import com.cloud.account.model.TblAccountExample;
import com.cloud.account.model.TblCapMessage;
import com.cloud.account.model.TblCapMessageExample;
import com.cloud.account.service.AmountService;
import com.cloud.common.entity.message.AccountMsg;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.ResponseCode;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AmountServiceImpl implements AmountService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TblAccountMapper tblAccountMapper;
    @Resource
    private TblCapMessageMapper tblCapMessageMapper;
    @Autowired
    private KafkaTemplate<String, String> template;
    @Autowired
    private CommonService commonService;


    @Override
    public CommonResp<TblAccount> operateAmount(String orderNo, String accountNo, BigDecimal amount) {
        CommonResp<TblAccount> resp = new CommonResp<>();
        String messageNo = commonService.getSerialNo("order");
        try {
            //1、更新金额
            Assert.notNull(messageNo, "未获取到流水号");
            TblAccount record = new TblAccount();
            record.setAccountAmount(amount);
            TblAccountExample example = new TblAccountExample();
            example.createCriteria().andAccountNoEqualTo(accountNo);
            Assert.isTrue(CollectionUtils.isNotEmpty(tblAccountMapper.selectByExample(example)), "未获取到客户");
            tblAccountMapper.updateByExampleSelective(record, example);
            resp.setResult(tblAccountMapper.selectByExample(example).get(0));
            //2、保存消息
            TblCapMessage message = new TblCapMessage();
            AccountRollBackEntity accountRollBackEntity = new AccountRollBackEntity();
            accountRollBackEntity.setAccountNo(accountNo);
            accountRollBackEntity.setAmount(amount);
            accountRollBackEntity.setOldAmount(tblAccountMapper.selectByExample(example).get(0).getAccountAmount());
            accountRollBackEntity.setOrderNo(orderNo);
            accountRollBackEntity.setSerialNo(messageNo);
            message.setMessageNo(messageNo);
            message.setMessageBody(JSONObject.toJSONString(accountRollBackEntity));
            tblCapMessageMapper.insertSelective(message);
            //3、通知订单修改订单状态为支付完成
            AccountMsg accountMsg = new AccountMsg();
            accountMsg.setAccountNo(accountNo);
            accountMsg.setMessageNo(messageNo);
            accountMsg.setOrderNo(orderNo);
            accountMsg.setOperateType("UPDATEORDER");
            accountMsg.setOrderStatus("S");
            accountMsg.setAccountNo(accountNo);
            template.send("acct-uni-notice-topic", JSONObject.toJSONString(accountMsg));
        } catch (IllegalArgumentException e) {
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(e.getMessage());
            resp.setResult(null);
            TblCapMessageExample example = new TblCapMessageExample();
            example.createCriteria().andMessageNoEqualTo(messageNo);
            tblCapMessageMapper.deleteByExample(example);
        } catch (Exception e) {
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            resp.setResult(null);
            TblCapMessageExample example = new TblCapMessageExample();
            example.createCriteria().andMessageNoEqualTo(messageNo);
            tblCapMessageMapper.deleteByExample(example);
        } finally {
            return resp;
        }
    }
}