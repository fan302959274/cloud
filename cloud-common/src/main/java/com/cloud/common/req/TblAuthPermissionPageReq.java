package com.cloud.common.req;

import com.cloud.common.entity.extend.TblAuthPermissionExtend;

/**
 * 通用请求类
 *
 * @author
 * @create 2017-07-20 10:57
 **/
public class TblAuthPermissionPageReq extends TblAuthPermissionExtend {

    private Integer page;
    private Integer pageSize;
    private Integer offset;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}