package com.cloud.account.service.impl;

import com.cloud.account.mapper.TblAccountMapper;
import com.cloud.account.model.TblAccount;
import com.cloud.account.model.TblAccountExample;
import com.cloud.account.service.AmountService;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.ResponseCode;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AmountServiceImpl implements AmountService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TblAccountMapper tblAccountMapper;

    @Override
    public CommonResp<TblAccount> operateAmount(String accountNo, BigDecimal amount) {
        CommonResp<TblAccount> resp = new CommonResp<>();
        try {
            TblAccount record = new TblAccount();
            record.setAccountAmount(amount);
            TblAccountExample example = new TblAccountExample();
            example.createCriteria().andAccountNoEqualTo(accountNo);
            Assert.isTrue(CollectionUtils.isNotEmpty(tblAccountMapper.selectByExample(example)), "未获取到客户");
            tblAccountMapper.updateByExampleSelective(record, example);
            resp.setResult(tblAccountMapper.selectByExample(example).get(0));
            return resp;
        } catch (IllegalArgumentException e) {
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(e.getMessage());
            resp.setResult(null);
            return resp;
        } catch (Exception e) {
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            resp.setResult(null);
            return resp;
        }
    }
}