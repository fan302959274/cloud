package com.movie.util.response;/**
 * Created by sh00859 on 2017/7/20.
 */


import com.cloud.common.resp.ResponseCode;

import java.util.List;

/**
 * 通用返回类
 *
 * @author
 * @create 2017-07-20 10:57
 **/
public class PageResp<T> {
    private String code = ResponseCode.SUCCESS.getCode();
    private String msg = ResponseCode.SUCCESS.getMsg();
    private T result;
    private List<T> data;
    private Integer page;
    private Integer pageSize;
    private Integer count;
    private Integer countPage;
    private Integer offset;
    private Integer limit;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountPage() {
        return countPage;
    }

    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
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