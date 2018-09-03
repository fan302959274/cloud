package com.cloud.core.service.impl;

import com.cloud.common.req.TblAuthPermissionPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.common.resp.ResponseCode;
import com.cloud.core.mapper.TblAuthPermissionMapper;
import com.cloud.core.mapper.TblAuthRolePermissionMapper;
import com.cloud.core.mapper.extend.TblAuthPermissionExtendMapper;
import com.cloud.core.model.TblAuthPermission;
import com.cloud.core.model.TblAuthPermissionExample;
import com.cloud.core.model.TblAuthRolePermission;
import com.cloud.core.model.TblAuthRolePermissionExample;
import com.cloud.core.model.extend.TblAuthPermissionExtend;
import com.cloud.core.service.AuthPermissionService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthPermissionServiceImpl implements AuthPermissionService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private TblAuthPermissionMapper tblAuthPermissionMapper;
    @Resource
    private TblAuthRolePermissionMapper tblAuthRolePermissionMapper;
    @Autowired
    private TblAuthPermissionExtendMapper tblAuthPermissionExtendMapper;


    @Override
    public CommonResp<TblAuthPermission> save(TblAuthPermission record) {
        CommonResp<TblAuthPermission> resp = new CommonResp<TblAuthPermission>();
        try {
            tblAuthPermissionMapper.insertSelective(record);
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
    public PageResp<TblAuthPermission> selectListByPage(TblAuthPermissionPageReq pageReq) {
        PageResp<TblAuthPermission> resp = new PageResp<TblAuthPermission>();
        TblAuthPermissionExample example = new TblAuthPermissionExample();
        try {
            Integer offset = pageReq.getOffset() == null ? 0 : pageReq.getOffset();
            Integer limit = pageReq.getLimit() == null ? 10 : pageReq.getLimit();
            PageHelper.offsetPage(offset, limit);
            if (null != pageReq) {
                TblAuthPermissionExample.Criteria criteria = example.createCriteria();
                if (!StringUtils.isBlank(pageReq.getName())) {
                    criteria.andNameLike("%" + pageReq.getName() + "%");
                }
                if (!StringUtils.isBlank(pageReq.getCode())) {
                    criteria.andCodeEqualTo(pageReq.getCode());
                }
            }
            List<TblAuthPermission> list = tblAuthPermissionMapper.selectByExample(example);
            Integer total = tblAuthPermissionMapper.countByExample(example);
            resp.setCountPage(total % limit == 0 ? total / limit : (total / limit + 1));
            resp.setCount(total);
            resp.setOffset(offset);
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
            TblAuthPermissionExample example = new TblAuthPermissionExample();
            String[] idLongs = ids.split(",");
            List<Long> values = new ArrayList<Long>();
            for (String id : idLongs) {
                values.add(Long.parseLong(id));
            }
            example.createCriteria().andIdIn(values);
            tblAuthPermissionMapper.deleteByExample(example);
        } catch (Exception e) {
            logger.error("删除异常" + e.getMessage());
            resp.setCode(ResponseCode.SYSTEM_ERROR.getCode());
            resp.setMsg(ResponseCode.SYSTEM_ERROR.getMsg());
            return resp;
        }
        return resp;
    }


    @Override
    public CommonResp<TblAuthPermission> update(TblAuthPermission record) {
        CommonResp<TblAuthPermission> resp = new CommonResp<TblAuthPermission>();
        try {
            tblAuthPermissionMapper.updateByPrimaryKeySelective(record);
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
    @Cacheable(value = "permissioncache", key = "'permission'+#id")
    public TblAuthPermission selectByKey(Long id) {
        return tblAuthPermissionMapper.selectByPrimaryKey(id);
    }


    @Override
    public PageResp<TblAuthPermissionExtend> selectRolePermissionListByPage(TblAuthPermissionPageReq pageReq) {
        PageResp<TblAuthPermissionExtend> resp = new PageResp<TblAuthPermissionExtend>();
        TblAuthPermissionExample example = new TblAuthPermissionExample();
        Map param = new HashMap();
        try {
            Integer offset = pageReq.getOffset() == null ? 0 : pageReq.getOffset();
            Integer limit = pageReq.getLimit() == null ? 10 : pageReq.getLimit();
            param.put("offset", offset);
            param.put("limit", limit);
            if (null != pageReq) {
                TblAuthPermissionExample.Criteria criteria = example.createCriteria();
                if (!StringUtils.isBlank(pageReq.getName())) {
                    criteria.andNameLike("%" + pageReq.getName() + "%");
                    param.put("name", pageReq.getName());
                }
                if (!StringUtils.isBlank(pageReq.getCode())) {
                    criteria.andCodeEqualTo(pageReq.getCode());
                    param.put("code", pageReq.getCode());
                }
                param.put("roleId", pageReq.getRoleId());
            }
            List<TblAuthPermissionExtend> list = tblAuthPermissionExtendMapper.selectRolePermissionByExample(param);
            Integer total = tblAuthPermissionMapper.countByExample(example);
            resp.setCountPage(total % limit == 0 ? total / limit : (total / limit + 1));
            resp.setCount(total);
            resp.setOffset(offset);
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
    public CommonResp<TblAuthPermission> allotPermission(String allotPermissionIds, String noAllotPermissionIds, String roleId) {
        CommonResp<TblAuthPermission> resp = new CommonResp<TblAuthPermission>();
        try {
            List<Long> allotPermissionIdList = new ArrayList<Long>();
            List<Long> noAllotPermissionIdList = new ArrayList<Long>();
            TblAuthRolePermissionExample example = new TblAuthRolePermissionExample();

            if (StringUtils.isNotBlank(allotPermissionIds)) {
                String[] allotPermissionIdArr = allotPermissionIds.split(",");
                for (String id : allotPermissionIdArr) {
                    allotPermissionIdList.add(Long.parseLong(id));
                }
                example.createCriteria().andRoleIdEqualTo(Long.parseLong(roleId)).andPermissionIdIn(allotPermissionIdList);
                tblAuthRolePermissionMapper.deleteByExample(example);
                allotPermissionIdList.forEach(aLong -> {
                    TblAuthRolePermission record = new TblAuthRolePermission();
                    record.setPermissionId(aLong);
                    record.setRoleId(Long.parseLong(roleId));
                    tblAuthRolePermissionMapper.insertSelective(record);
                });
            }

            if (StringUtils.isNotBlank(noAllotPermissionIds)) {
                String[] noAllotPermissionArr = noAllotPermissionIds.split(",");
                for (String id : noAllotPermissionArr) {
                    noAllotPermissionIdList.add(Long.parseLong(id));
                }
                example = new TblAuthRolePermissionExample();
                example.createCriteria().andRoleIdEqualTo(Long.parseLong(roleId)).andPermissionIdIn(noAllotPermissionIdList);
                tblAuthRolePermissionMapper.deleteByExample(example);
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