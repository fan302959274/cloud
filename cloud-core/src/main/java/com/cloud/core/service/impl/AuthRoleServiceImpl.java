package com.cloud.core.service.impl;

import com.cloud.common.req.TblAuthRolePageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.ResponseCode;
import com.cloud.core.mapper.TblAuthRoleMapper;
import com.cloud.core.mapper.TblAuthUserRoleMapper;
import com.cloud.core.mapper.extend.TblAuthRoleExtendMapper;
import com.cloud.core.model.TblAuthRole;
import com.cloud.core.model.TblAuthRoleExample;
import com.cloud.core.model.TblAuthUserRole;
import com.cloud.core.model.TblAuthUserRoleExample;
import com.cloud.core.model.extend.TblAuthRoleExtend;
import com.cloud.core.service.AuthRoleService;
import com.github.pagehelper.PageHelper;
import com.movie.util.response.PageResp;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthRoleServiceImpl implements AuthRoleService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TblAuthRoleMapper tblAuthRoleMapper;
    @Resource
    private TblAuthRoleExtendMapper tblAuthRoleExtendMapper;
    @Resource
    private TblAuthUserRoleMapper tblAuthUserRoleMapper;


    @Override
    public CommonResp<TblAuthRole> save(TblAuthRole record) {
        CommonResp<TblAuthRole> resp = new CommonResp<TblAuthRole>();
        try {
            tblAuthRoleMapper.insertSelective(record);
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
    public PageResp<TblAuthRole> selectListByPage(TblAuthRolePageReq pageReq) {
        PageResp<TblAuthRole> resp = new PageResp<TblAuthRole>();
        TblAuthRoleExample example = new TblAuthRoleExample();
        try {
            Integer page = pageReq.getPage() == null ? 0 : pageReq.getPage();
            Integer limit = pageReq.getLimit() == null ? 10 : pageReq.getLimit();
            PageHelper.offsetPage((page - 1) * limit, limit);
            if (null != pageReq) {
                TblAuthRoleExample.Criteria criteria = example.createCriteria();
                if (!StringUtils.isBlank(pageReq.getName())) {
                    criteria.andNameLike("%" + pageReq.getName() + "%");
                }
                if (!StringUtils.isBlank(pageReq.getCode())) {
                    criteria.andCodeEqualTo(pageReq.getCode());
                }
            }
            List<TblAuthRole> list = tblAuthRoleMapper.selectByExample(example);
            Integer total = tblAuthRoleMapper.countByExample(example);
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
            TblAuthRoleExample example = new TblAuthRoleExample();
            String[] idLongs = ids.split(",");
            List<Long> values = new ArrayList<Long>();
            for (String id : idLongs) {
                values.add(Long.parseLong(id));
            }
            example.createCriteria().andIdIn(values);
            tblAuthRoleMapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("删除异常" + e.getMessage());
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            return resp;
        }
        return resp;
    }


    @Override
    public CommonResp<TblAuthRole> update(TblAuthRole record) {
        CommonResp<TblAuthRole> resp = new CommonResp<TblAuthRole>();
        try {
            tblAuthRoleMapper.updateByPrimaryKeySelective(record);
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
    public TblAuthRole selectByKey(Long id) {
        return tblAuthRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResp<TblAuthRoleExtend> selectUserRoleListByPage(TblAuthRolePageReq pageReq) {
        PageResp<TblAuthRoleExtend> resp = new PageResp<TblAuthRoleExtend>();
        TblAuthRoleExample example = new TblAuthRoleExample();
        Map param = new HashMap();
        try {
            Integer page = pageReq.getPage() == null ? 0 : pageReq.getPage();
            Integer limit = pageReq.getLimit() == null ? 10 : pageReq.getLimit();
            param.put("offset", (page - 1) * limit);
            param.put("limit", limit);
            if (null != pageReq) {
                TblAuthRoleExample.Criteria criteria = example.createCriteria();
                if (!StringUtils.isBlank(pageReq.getName())) {
                    criteria.andNameLike("%" + pageReq.getName() + "%");
                    param.put("name", pageReq.getName());
                }
                if (!StringUtils.isBlank(pageReq.getCode())) {
                    criteria.andCodeEqualTo(pageReq.getCode());
                    param.put("code", pageReq.getCode());
                }
                param.put("userId", pageReq.getUserId());
            }
            List<TblAuthRoleExtend> list = tblAuthRoleExtendMapper.selectUserRoleByExample(param);
            Integer total = tblAuthRoleMapper.countByExample(example);
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
    public CommonResp<TblAuthRole> allotRole(String allotRoleIds, String noAllotRoleIds, String userId) {
        CommonResp<TblAuthRole> resp = new CommonResp<TblAuthRole>();
        try {
            List<Long> allotRoleIdList = new ArrayList<Long>();
            List<Long> noAllotRoleIdList = new ArrayList<Long>();
            TblAuthUserRoleExample example = new TblAuthUserRoleExample();

            if (StringUtils.isNotBlank(allotRoleIds)) {
                String[] allotRoleIdArr = allotRoleIds.split(",");
                for (String id : allotRoleIdArr) {
                    allotRoleIdList.add(Long.parseLong(id));
                }
                example.createCriteria().andUserIdEqualTo(Long.parseLong(userId)).andRoleIdIn(allotRoleIdList);
                tblAuthUserRoleMapper.deleteByExample(example);
                allotRoleIdList.forEach(aLong -> {
                    TblAuthUserRole record = new TblAuthUserRole();
                    record.setRoleId(aLong);
                    record.setUserId(Long.parseLong(userId));
                    tblAuthUserRoleMapper.insertSelective(record);
                });
            }

            if (StringUtils.isNotBlank(noAllotRoleIds)) {
                String[] noAllotRoleArr = noAllotRoleIds.split(",");
                for (String id : noAllotRoleArr) {
                    noAllotRoleIdList.add(Long.parseLong(id));
                }
                example = new TblAuthUserRoleExample();
                example.createCriteria().andUserIdEqualTo(Long.parseLong(userId)).andRoleIdIn(noAllotRoleIdList);
                tblAuthUserRoleMapper.deleteByExample(example);
            }

            resp.setResultList(null);
        } catch (Exception e) {
            logger.error("保存异常" + e.getMessage());
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            return resp;
        }
        return resp;
    }
}