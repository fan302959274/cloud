package com.cloud.core.service.impl;

import com.cloud.common.req.TblAuthUserPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.ResponseCode;
import com.cloud.common.util.DateUtil;
import com.cloud.core.mapper.TblAuthUserMapper;
import com.cloud.core.mapper.extend.TblAuthPermissionExtendMapper;
import com.cloud.core.model.TblAuthPermission;
import com.cloud.core.model.TblAuthUser;
import com.cloud.core.model.TblAuthUserExample;
import com.cloud.core.service.AuthUserService;
import com.github.pagehelper.PageHelper;
import com.movie.util.response.PageResp;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AuthUserServiceImpl implements AuthUserService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TblAuthUserMapper tblAuthUserMapper;
    @Resource
    private TblAuthPermissionExtendMapper tblAuthPermissionExtendMapper;


    @Override
    public TblAuthUser findUserByNickName(String nickname) {
        TblAuthUserExample example = new TblAuthUserExample();
        example.createCriteria().andNicknameEqualTo(nickname);
        List<TblAuthUser> tblAuthUsers = tblAuthUserMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(tblAuthUsers)) {
            //更新客户的最近登录时间
            TblAuthUser tblAuthUser = tblAuthUsers.get(0);
            tblAuthUser.setLastLoginTime(new Date());
            tblAuthUserMapper.updateByPrimaryKeySelective(tblAuthUser);
            return tblAuthUsers.get(0);
        }
        return null;

    }

    @Override
    public CommonResp<TblAuthUser> save(TblAuthUser tblAuthUser) {
        CommonResp<TblAuthUser> resp = new CommonResp<TblAuthUser>();
        try {
            //初始密码000000
            tblAuthUser.setPswd("000000");
            tblAuthUserMapper.insertSelective(tblAuthUser);
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
    public PageResp<TblAuthUser> selectListByPage(TblAuthUserPageReq pageReq) {
        PageResp<TblAuthUser> resp = new PageResp<TblAuthUser>();
        TblAuthUserExample example = new TblAuthUserExample();
        try {
            Integer page = pageReq.getPage() == null ? 0 : pageReq.getPage();
            Integer limit = pageReq.getLimit() == null ? 10 : pageReq.getLimit();
            PageHelper.offsetPage((page - 1) * limit, limit);
            TblAuthUserExample.Criteria criteria = example.createCriteria();
            criteria.andNicknameNotEqualTo("admin");
            if (null != pageReq) {
                if (!StringUtils.isBlank(pageReq.getNickname())) {
                    criteria.andNicknameLike("%" + pageReq.getNickname() + "%");
                }
                if (!Objects.isNull(pageReq.getStatus())) {
                    criteria.andStatusEqualTo(pageReq.getStatus());
                }
                if (!StringUtils.isBlank(pageReq.getLastLoginTimeStr())) {
                    String[] times = pageReq.getLastLoginTimeStr().split(" - ");
                    criteria.andLastLoginTimeBetween(DateUtil.parse(times[0], DateUtil.YYYYMMDDCOMMON), DateUtil.parse(times[1], DateUtil.YYYYMMDDCOMMON));
                }
            }
            List<TblAuthUser> list = tblAuthUserMapper.selectByExample(example);
            Integer total = tblAuthUserMapper.countByExample(example);
            resp.setCountPage(total % limit == 0 ? total / limit : (total / limit + 1));
            resp.setCount(total);
            resp.setOffset((page - 1) * limit);
            resp.setLimit(limit);
            resp.setMsg("");
            resp.setCode("0");
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
            TblAuthUserExample example = new TblAuthUserExample();
            String[] idLongs = ids.split(",");
            List<Long> values = new ArrayList<Long>();
            for (String id : idLongs) {
                values.add(Long.parseLong(id));
            }
            example.createCriteria().andIdIn(values);
            tblAuthUserMapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("删除异常" + e.getMessage());
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            return resp;
        }
        return resp;
    }


    @Override
    public CommonResp<TblAuthUser> update(TblAuthUser tblAuthUser) {
        CommonResp<TblAuthUser> resp = new CommonResp<TblAuthUser>();
        try {
            tblAuthUserMapper.updateByPrimaryKeySelective(tblAuthUser);
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
    public TblAuthUser selectByKey(Long id) {
        return tblAuthUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TblAuthPermission> findUserPermissionByNickName(String nickname) {
        try {
            List<TblAuthPermission> list = tblAuthPermissionExtendMapper.findUserPermissionByNickName(nickname);
            return list;
        } catch (Exception e) {
            logger.error("保存异常" + e.getMessage());
            return null;
        }
    }
}