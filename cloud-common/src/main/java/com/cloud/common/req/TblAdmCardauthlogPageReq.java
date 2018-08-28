package com.cloud.common.req;/**
 * Created by sh00859 on 2017/7/20.
 */


import com.cloud.common.entity.extend.TblAdmCardauthlogExtend;
import com.cloud.common.entity.extend.TblAuthUserExtend;

/**
 * 通用请求类
 *
 * @author
 * @create 2017-07-20 10:57
 **/
public class TblAdmCardauthlogPageReq extends TblAdmCardauthlogExtend {

    private Integer page = 1;
    private Integer pageSize = 10;
    private Integer offset = 0;
    private Integer limit = 10;

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