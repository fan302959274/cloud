package com.cloud.core.service.impl;

import com.cloud.common.req.TblAdmCardauthlogPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.common.resp.ResponseCode;
import com.cloud.core.mapper.TblAdmCardauthlogMapper;
import com.cloud.core.model.TblAdmCardauthlog;
import com.cloud.core.model.TblAdmCardauthlogExample;
import com.cloud.core.service.CardAuthLogService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardAuthLogServiceImpl implements CardAuthLogService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TblAdmCardauthlogMapper tblAdmCardauthlogMapper;


    @Override
    public CommonResp<TblAdmCardauthlog> save(TblAdmCardauthlog tblAdmCardauthlog) {
        CommonResp<TblAdmCardauthlog> resp = new CommonResp<TblAdmCardauthlog>();
        try {
            tblAdmCardauthlogMapper.insertSelective(tblAdmCardauthlog);
            resp.setResultList(null);
        } catch (Exception e) {
            logger.error("保存异常" + e.getMessage());
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            return resp;
        }
        return resp;
    }

    @Override
    public PageResp<TblAdmCardauthlog> selectListByPage(TblAdmCardauthlogPageReq pageReq) {
        PageResp<TblAdmCardauthlog> resp = new PageResp<TblAdmCardauthlog>();
        TblAdmCardauthlogExample example = new TblAdmCardauthlogExample();
        try {
            Integer page = pageReq.getPage() == null ? 0 : pageReq.getPage();
            Integer limit = pageReq.getLimit() == null ? 10 : pageReq.getLimit();
            PageHelper.offsetPage((page - 1) * limit, limit);
            if (null != pageReq) {
                TblAdmCardauthlogExample.Criteria criteria = example.createCriteria();
                if (!StringUtils.isBlank(pageReq.getCalAuthBankName())) {
                    criteria.andCalAuthBankNameLike("%" + pageReq.getCalAuthBankName() + "%");
                }
                if (!StringUtils.isBlank(pageReq.getCalAuthBankCard())) {
                    criteria.andCalAuthBankCardEqualTo(pageReq.getCalAuthBankCard());
                }
            }
            long starttime = System.currentTimeMillis();
            List<TblAdmCardauthlog> list = tblAdmCardauthlogMapper.selectByExample(example);
            Integer total = tblAdmCardauthlogMapper.countByExample(example);
            long endtime = System.currentTimeMillis();
            logger.info("search cost time:{}", endtime - starttime);
            resp.setCountPage(total % limit == 0 ? total / limit : (total / limit + 1));
            resp.setCount(total);
            resp.setOffset((page - 1) * limit);
            resp.setLimit(limit);
            resp.setData(list);
        } catch (Exception e) {
            logger.error("获取异常" + e.getMessage());
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            return resp;
        }
        return resp;
    }

    @Override
    public CommonResp<String> delete(String ids) {
        CommonResp<String> resp = new CommonResp<String>();
        try {
            TblAdmCardauthlogExample example = new TblAdmCardauthlogExample();
            String[] idLongs = ids.split(",");
            List<Long> values = new ArrayList<Long>();
            for (String id : idLongs) {
                values.add(Long.parseLong(id));
            }
            example.createCriteria().andIdIn(values);
            tblAdmCardauthlogMapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("删除异常" + e.getMessage());
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            return resp;
        }
        return resp;
    }


    @Override
    public CommonResp<TblAdmCardauthlog> update(TblAdmCardauthlog TblAdmCardauthlog) {
        CommonResp<TblAdmCardauthlog> resp = new CommonResp<TblAdmCardauthlog>();
        try {
            tblAdmCardauthlogMapper.updateByPrimaryKeySelective(TblAdmCardauthlog);
            resp.setResultList(null);
        } catch (Exception e) {
            logger.error("保存异常" + e.getMessage());
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            return resp;
        }
        return resp;
    }

    @Override
    public TblAdmCardauthlog selectByKey(Long id) {
        return tblAdmCardauthlogMapper.selectByPrimaryKey(id);
    }


}